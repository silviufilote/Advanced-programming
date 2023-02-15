/*
 * Account.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */


#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "Cliente.h"
#include "Staff.h"
#include "Account.h"

using namespace std;


int Account::count = 1;
vector<Account*> Account::listaAcc;
bool login(Cliente* c, char* psw);
void creaAccount(Cliente* c);
void saldo(Cliente* c, char* psw);
void speseMensile(Cliente* c, char* psw);

Account::Account(Cliente* cliente){
    this->cliente = cliente;
    this->tentativi = 0;

    // controllare se esistono finanziamenti in corso per utente e aggiungere a spesaMensile
    this->password = new char();
    sprintf(this->password, "psw-ogg-%i", Account::count);
    cout << "Creazione account avvenuta" << endl;
    cout << "psw: " << this->password << endl;
    Account::listaAcc.push_back(this);
}

Account::~Account(){
    cout << "Account distrutto" << endl;
}

bool Account::login(Cliente* c, char* psw){

    Account *flag;

     for (vector <Account*>::iterator i = Account::listaAcc.begin(); i != Account::listaAcc.end(); ++i){
        if((*i)->cliente->getIdCliente() == c->getIdCliente()){
            flag = *i;
        }
    }

    if(flag->tentativi < 3){
        for (vector <Account*>::iterator i = Account::listaAcc.begin(); i != Account::listaAcc.end(); ++i){
            if((*i)->cliente->getIdCliente() == c->getIdCliente() && strcmp((*i)->password, psw) == 0){
                (*i)->tentativi = 0;
                return true;
            }
            
        }
        cout << "psw sbagliata" << endl;
        flag->tentativi += 1;
        
    }

    if(flag->tentativi == 3)
        cout << "Account bloccato" << endl;

    return false;
}




void Account::movimenti(Cliente* c, char* psw){

    cout << "Lista movimenti:" << endl;

    if(Account::login(c, psw) == true){
        for(int mov : c->movimento){
            cout << mov << endl;
        }
    }
}


void Account::saldo(Cliente* c, char* psw){
    if(Account::login(c, psw) == true){
        cout << "Saldo totale: " << c->getSaldo() << endl;
    }
}


void Account::speseMensile(Cliente* c, char* psw){
    if(Account::login(c, psw) == true){
        cout << c->getSpesaMensile() << endl;
    }
}



Cliente* Account::getCliente(Admin * const a) {
  return this -> cliente;
}

int Account::getTentativi(Admin * const a) {
  return this -> tentativi;
}

void Account::resetTentativi(Admin *const a) {
  this -> tentativi = 0;
}
