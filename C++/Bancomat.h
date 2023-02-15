/*
 * Bancomat.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef BANCOMAT_H_
#define BANCOMAT_H_

#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "Cliente.h"
#include "Account.h"
#include "Admin.h"

using namespace std;

enum opzioniPreleva { A = 50, B = 100, C = 150, D = 200, E = 250, F = 500, G = 600};

class Bancomat final{
    private:
        static const int maxContanti = 1500;
        int contantiPresenti;
        bool fuoriUso;
    protected:

    public:
        Bancomat();
        Bancomat(int contanti);
        ~Bancomat();
        void preleva(Cliente * const c, opzioniPreleva scelta);
        void aggiungiContati(Admin *a, int contanti);

        int getMaxContanti();
        int getContantiPresenti(Admin * const a);
        void setFuoriUso();
        void mettiInUso(Admin const * const a);
        static void viewOpzioniPrelevamento();
        void distruggiBancomat(Admin * const a);
};



#endif /* BANCOMAT_H_ */
