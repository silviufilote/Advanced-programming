/*
 * Staff.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */


#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include "Persona.h"
#include "Staff.h"
#include "Cliente.h"
#include "Admin.h"
#include "Account.h"

using namespace std;


int Staff::count = 1;


Staff::Staff(char* nome, char* cognome, int eta) : Persona(nome, cognome, eta){
	try{
		this->idStaff = new char();
		sprintf(this->idStaff, "ID-STAFF%i", Staff::count);
		Staff::count += 1;
	} catch (std::exception& e){ std::cerr << "Errore inseriemnto dati staff: " << e.what() << std::endl; }

	Admin::listaStaff.push_back(this);

	cout << "Crezione staff avvenuta" << endl;
}



Staff::~Staff(){
	cout << "Distruzione Staff avvenuta" << endl;
}



void Staff::aggiungiSaldoCliente(Cliente* c, int saldo){
	c->setSaldo(saldo);
	c->movimento.push_back(saldo);
}



void Staff::preleveSaldoCliente(Cliente* c, int saldo){
	c->setSaldo(-saldo);
	c->movimento.push_back(-saldo);
}



void Staff::creazioneAccount(Cliente* cliente){
	Account *a = new Account(cliente);
	cliente->setSpesaMensile(10);
}



char* Staff::getIdStaff(){
	this->idStaff;
}


void Staff::visualizzaPersona(){
    cout << this->idStaff << " " << this->getNome() << " " << this->getCognome() << endl;
}