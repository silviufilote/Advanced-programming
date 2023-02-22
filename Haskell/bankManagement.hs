import Data.Function (on)
import Data.List (sortBy)



-----------------------------------------------------------------------------------------
-- -----------------------  Bank management system  ---------------------------------- --
-----------------------------------------------------------------------------------------




-- Lista di clienti (ID, nome, saldo)
clienti = [(1, "Marcello", 1000), (2, "Martina", 500), (3, "Leonardo", 1500), (4, "Giovanni", 2000)]


-- Inserimento di un cliente in testa a una lista di clienti
-- funzione base
insertInto :: (String, Int) -> [(Int, String, Int)] -> [(Int, String, Int)]
insertInto (a,b) xs =  (getIdMaxList xs + 1, a, b) : xs


-- inserimento di clienti all'interno della lista clienti dichiarata a inizio file
-- funzione base
insertClienti :: [(Int, String, Int)] -> [(Int, String, Int)]
insertClienti xs = xs ++ clienti


-- Data un funzione matematica definita come input viene applicata al saldo del cliente 
-- funzione di supporto
makeRandom :: (Int -> Int) -> (Int, String, Int) -> (Int, String, Int)
makeRandom f (a, b, c) = (a, b, (f c))


-- Modifica a tutti i clienti il saldo 
-- funzione base
makeListRandom :: (Int -> Int) -> [(Int, String, Int)] -> [(Int, String, Int)]
makeListRandom f xs =  [makeRandom f x | x <- xs ]


-- data una tupla restitusce il saldo di un cliente
-- funzione di supporto
thrd :: (a, b, c) -> c
thrd (_, _, c) = c


-- data una tupla restitusce l'ID di un cliente
-- funzione di supporto
fstt :: (a, b, c) -> a
fstt (a, _, _) = a


-- Ordinamento in base al saldo
-- funzione base
orderMaxSaldo :: [(Int, String, Int)] -> [(Int, String, Int)]
orderMaxSaldo [] = []
orderMaxSaldo xs = sortBy (compare `on` thrd) xs


-- Restitusce i clienti uno alla volta data una lista di clienti
-- funzione di supporto
getTuple :: [(a)] -> (a)
getTuple [] = error "Error list is not appropriate"
getTuple (x:xs) = x


-- Fornito un ID restituisce il cliente con tale ID
-- funzione base
findIdClient :: Int -> [(Int, String, Int)] -> (Int, String, Int)
findIdClient x [] = error "Error list is not appropriate"
findIdClient x (y:ys) = getTuple [y | y <- ys, fstt(y) == x]


-- Aggiunge/toglie saldo a un cliente
-- funzione di supporto
addSaldo :: Int -> (a, b, Int) -> (a, b, Int)
addSaldo x (a, b, c) = (a, b, (c + x))


-- Dato un ID aggiunge/toglie un determinato saldo al cliente con tale ID
-- funzione base
addSaldoId :: Int -> Int -> [(Int, String, Int)] -> (Int, String, Int)
addSaldoId x y [] = error "Error list is not appropriate"
addSaldoId x y xs = addSaldo y (findIdClient x xs)


-- Dato un ID rimuove un determinato cliente dalla lista
-- funzione base
removeCienteIdList :: Int -> [(Int, String, Int)] -> [(Int, String, Int)]
removeCienteIdList x [] = error "Error list is not appropriate"
removeCienteIdList i xs = smaller
                          where smaller = [ x | x <- xs, fstt x /= i]


-- Calcolo ID max di una lista di clienti
-- funzione di supporto
getIdMaxList :: [(Int, String, Int)] -> Int
getIdMaxList [] = error "Error list is not appropriate"
getIdMaxList [x] = fstt x
getIdMaxList (x:xs) | (getIdMaxList xs) > fstt x = getIdMaxList xs
                    | otherwise                  = fstt x


-- Restituisce il cliente con il saldo piu alto
-- funzione base
getClienteMaxSaldo :: [(Int, String, Int)] -> (Int, String, Int)
getClienteMaxSaldo [] = error "Error list is not appropriate"
getClienteMaxSaldo [x] = x
getClienteMaxSaldo xs =  head (reverse (orderMaxSaldo xs))



-- Main I/O functions
main = do
       let xc = [(10, "Jonny", 1000), (12, "Ronzo", 500), (13, "Niccolo", 1500)]
       let ds = insertInto ("Mattia", 1000) xc
       let ks = makeListRandom (+99) ds
       -- print(ks)
       print(addSaldoId 10 (-900) ds)
       print(removeCienteIdList 10 ks)
       print(getClienteMaxSaldo ks)      