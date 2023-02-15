/*
 * Admin.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */



#include <iostream>
#include <cstring>
#include <string>
#include "Persona.h"
#include "Cliente.h"
#include "Staff.h"
#include "Admin.h"
#include "Account.h"
#include "Bancomat.h"


using namespace std;

int Admin::count = 1;
vector<Admin*> Admin::listaAdmin;
vector<Cliente*> Admin::listaClienti;
vector<Staff*> Admin::listaStaff;

Admin::Admin(char* nome, char* cognome, int eta) : Persona(nome, cognome, eta){
    try{
		this->idAdmin = new char();
		sprintf(this->idAdmin, "ID_ADMIN%i", Admin::count);
		Admin::count += 1;
	} catch (std::exception& e){ std::cerr << "Errore inseriemnto dati Admin: " << e.what() << std::endl; }

    Admin::listaAdmin.push_back(this);

	cout << "Crezione Admin avvenuta" << endl;
}

Admin::~Admin(){
    cout << "Distruzione admin avvenuta" << endl;
}


void Admin::eliminaAdmin(){
    for (vector<Admin*>::iterator it = Admin::listaAdmin.begin(); it !=  Admin::listaAdmin.end();) {
		if ((*it)->idAdmin == this->idAdmin) {
			it = Admin::listaAdmin.erase(it);
		}else{
             ++it;
        }
	}

	delete(this->idAdmin);
	delete(this);
}


void Admin::sbloccaAccCliente(Cliente * const c){
    for(auto item: Account::listaAcc){
        if(item->getCliente(this)->getIdCliente() == c->getIdCliente()){
            cout << "Account sbloccato" <<endl;
            item->resetTentativi(this);
        }
    }
}


void Admin::clientiAffidabili(){
    for (auto elem : Admin::listaClienti) {
            if(elem->getAffidabilita())
               elem->visualizzaPersona();
    }
}


void Admin::viewListaPersone(viewPersona item){
    if(static_cast<char>(item) == 'C' ){
        for (auto elem : Admin::listaClienti) {
            elem->visualizzaPersona();
         }
    } else if(static_cast<char>(item) == 'S' ){
        for (auto elem : Admin::listaStaff) {
            elem->visualizzaPersona();
         }
    } else{
        for (auto elem : Admin::listaAdmin) {
            elem->visualizzaPersona();
         }
    }
}


void Admin::viewAccounts(){
     for (vector<Account*>::iterator it = Account::listaAcc.begin(); it !=  Account::listaAcc.end(); ++it) {
        cout << (*it)->getCliente(this)->getIdCliente() << " " << (*it)->getCliente(this)->getNome() << endl;
     }
}


void Admin::sbloccaBancomat(Bancomat * const b){
     if(b != NULL){
        if(b->getContantiPresenti(this) != 0){
            b->mettiInUso(this);
        }
    }
}


void viewFinanziamentoCLiente(Cliente * const c){
    if(c != NULL){
        for(auto item: Admin::listaClienti){
            if(item->getIdCliente() == c->getIdCliente()){
                for (auto elem : item->listaFinanziamenti){
                    elem->viewFinanziamento();
                }
            }
        }
    }
}


void Admin::makeFinanziamento(Cliente * const c, int capitale, int durata){
    Finanziamento *f = new Finanziamento(c, capitale, durata);
}


void Admin::eliminazioneCliente(Cliente * c){
    if(c->listaFinanziamenti.size() == 0 ){

        for (vector<Account*>::iterator it = Account::listaAcc.begin(); it !=  Account::listaAcc.end(); ) {
			if (strcmp((*it)->getCliente(this)->getIdCliente(), c->getIdCliente()) == 0) {
                it = Account::listaAcc.erase(it);
                delete(*it);
			}else{
                ++it;
            }
		}


		for (vector<Cliente*>::iterator it = Admin::listaClienti.begin(); it !=  Admin::listaClienti.end();) {
			if ((*it)->getIdCliente()  == c->getIdCliente()) {
				it = Admin::listaClienti.erase(it);
			}else{
                 ++it;
            }
		}

		delete(c->getIdCliente());
		delete(c->getPhone());
		free(c->getMail());
		free(c->getIndrizzo());
		// c->getConto()->eliminazioneCBancario(); smart pointer fa da solo
		// delete(&c->getConto());
		delete(c);

		cout << "Cancellazione effettuata" << endl;
	} else{
		cout << "Impossibile effettaure cancellazione possiedi un finanziamento in corso" << endl;
	}

}


void Admin::eliminazioneStaff(Staff* s){
    for (vector<Staff*>::iterator it = Admin::listaStaff.begin(); it !=  Admin::listaStaff.end();) {
		if (strcmp((*it)->getIdStaff(), s->getIdStaff()) == 0) {
			it = Admin::listaStaff.erase(it);
		} else{
             ++it;
        }
	}

	// delete(s->getIdStaff());  ??
	delete(s);
}


void Admin::visualizzaPersona(){
    cout << this->idAdmin << " " << this->getNome() << " " << this->getCognome() << endl;
}



