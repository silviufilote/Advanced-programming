/*
 * Account.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef ACCOUNT_H_
#define ACCOUNT_H_


#ifndef ACOOUNT_H_
#define ACOOUNT_H_

#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "Cliente.h"
#include "Staff.h"

using namespace std;

class Admin;
class Cliente;

class Account{
    private:
        char* password;
        Cliente* cliente;
        int tentativi;
        static int count;

        friend class Staff;
        Account(Cliente* cliente);

        static bool login(Cliente* c, char* psw);

    protected:


    public:
        vector<int> movimento;
        static vector<Account*> listaAcc;

        ~Account();
       
        static void movimenti(Cliente* c, char* psw);
        static void saldo(Cliente* c, char* psw);
        static void speseMensile(Cliente* c, char* psw);


        Cliente* getCliente(Admin * const a);
        int getTentativi(Admin * const a);
        void resetTentativi(Admin * const a);
};


#endif /* ACOOUNT_H_ */


#endif /* ACCOUNT_H_ */
