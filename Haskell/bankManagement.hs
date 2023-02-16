import Data.Function (on)
import Data.List (sortBy)

-- Bank management system

clienti = [(1, "Marcello", 1000), (2, "Martina", 500), (3, "Leonardo", 1500), (4, "Giovanni", 2000)]

insertInto :: (String, Int) -> [(Int, String, Int)] -> [(Int, String, Int)]
insertInto (a,b) xs =  (getIdMaxList xs + 1, a, b) : xs


insertClienti :: [(Int, String, Int)] -> [(Int, String, Int)]
insertClienti xs = xs ++ clienti


makeRandom :: (Int -> Int) -> (Int, String, Int) -> (Int, String, Int)
makeRandom f (a, b, c) = (a, b, (f c))


makeListRandom :: (Int -> Int) -> [(Int, String, Int)] -> [(Int, String, Int)]
makeListRandom f xs =  [makeRandom f x | x <- xs ]


thrd :: (a, b, c) -> c
thrd (_, _, c) = c


fstt :: (a, b, c) -> a
fstt (a, _, _) = a


orderMaxSaldo :: [(Int, String, Int)] -> [(Int, String, Int)]
orderMaxSaldo [] = []
orderMaxSaldo xs = sortBy (compare `on` thrd) xs


getTuple :: [(a)] -> (a)
getTuple [] = error "Error list is not appropriate"
getTuple (x:xs) = x


findIdClient :: Int -> [(Int, String, Int)] -> (Int, String, Int)
findIdClient x [] = error "Error list is not appropriate"
findIdClient x (y:ys) = getTuple [y | y <- ys, fstt(y) == x]


addSaldo :: Int -> (a, b, Int) -> (a, b, Int)
addSaldo x (a, b, c) = (a, b, (c + x))


addSaldoId :: Int -> Int -> [(Int, String, Int)] -> (Int, String, Int)
addSaldoId x y [] = error "Error list is not appropriate"
addSaldoId x y xs = addSaldo y (findIdClient x xs)


removeCienteIdList :: Int -> [(Int, String, Int)] -> [(Int, String, Int)]
removeCienteIdList x [] = error "Error list is not appropriate"
removeCienteIdList i xs = smaller
                          where smaller = [ x | x <- xs, fstt x /= i]



getIdMaxList :: [(Int, String, Int)] -> Int
getIdMaxList [] = error "Error list is not appropriate"
getIdMaxList [x] = fstt x
getIdMaxList (x:xs) | (getIdMaxList xs) > fstt x = getIdMaxList xs
                    | otherwise                  = fstt x



getClienteMaxSaldo :: [(Int, String, Int)] -> (Int, String, Int)
getClienteMaxSaldo [] = error "Error list is not appropriate"
getClienteMaxSaldo [x] = x
getClienteMaxSaldo xs =  head (reverse (orderMaxSaldo xs))



main = do
       let dd = insertInto ("qwer", 500) clienti
       let pp = insertInto ("gianni", 500) dd
       print(pp)
       print(removeCienteIdList 6 pp)
       print(getClienteMaxSaldo pp)
      