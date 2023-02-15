/*
 * Bancomat.cpp
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
#include "Account.h"
#include "Bancomat.h"
#include "Admin.h"

const int maxContanti = 1500;

Bancomat::Bancomat(){
    this->contantiPresenti = Bancomat::maxContanti;
    this->fuoriUso = false;

    cout << "Creazione bancomat" <<endl;
}


Bancomat::Bancomat(int contanti){
    if(contanti < 0 || contanti > Bancomat::maxContanti )
        throw std::invalid_argument("Errore contati bancomat");

    this->contantiPresenti = contanti;
    this->fuoriUso = false;

    cout << "Creazione bancomat" <<endl;
}


Bancomat::~Bancomat(){
    cout << "Bancomat distrutto" << endl;
}


void Bancomat::preleva(Cliente * const c, opzioniPreleva scelta){
    if( static_cast<int>(scelta) < c->getSaldo() && this->contantiPresenti >= static_cast<int>(scelta) && this->fuoriUso == false){
        c->setSaldo(-scelta);
        this->contantiPresenti -= static_cast<int>(scelta);
        c->movimento.push_back(-static_cast<int>(scelta));
        cout << "Prelievo andato a buon fine" << endl;
        if(this->contantiPresenti == 0){
            this->fuoriUso = true;
        }
    }else{
        cout << "Impossibile prelevare" << endl;
    }
}


 void Bancomat::aggiungiContati(Admin * const a, int contanti){
    if(a != NULL){
        if(this->contantiPresenti + contanti <= Bancomat::maxContanti){
            this->fuoriUso = false;
            this->contantiPresenti += contanti;
            cout << "Contanti aggiunti" << endl;
        }else{
             cout << "Impossibile aggiungere contanti" << endl;
        }
    }
 }


 void Bancomat::mettiInUso(Admin const * const a){
    if(a != NULL){
        if(this->contantiPresenti != 0){
            this->fuoriUso = false;
        }
    }
 }


 void Bancomat::distruggiBancomat(Admin * const a){
    if(a != NULL){
        delete(this);
    }
 }


 int Bancomat::getMaxContanti() {
   return this -> maxContanti;
 }


 int Bancomat::getContantiPresenti(Admin * const a) {
   return this -> contantiPresenti;
 }

 void Bancomat::setFuoriUso() {
   this -> fuoriUso = true;
 }


 void Bancomat::viewOpzioniPrelevamento() {
   cout << opzioniPreleva::A << endl;
   cout << opzioniPreleva::B << endl;
   cout << opzioniPreleva::C << endl;
   cout << opzioniPreleva::D << endl;
   cout << opzioniPreleva::E << endl;
   cout << opzioniPreleva::F << endl;
   cout << opzioniPreleva::G << endl;
 }