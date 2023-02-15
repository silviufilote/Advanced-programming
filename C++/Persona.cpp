/*
 * Persona.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */


#include <iostream>
#include <cstring>
#include <string>
using namespace std;
#include "Persona.h"

int Persona::totalePersone = 0;


Persona::Persona(char* n, char* c, int e) : nome(n), cognome(c), eta(e){
	cout << "Crezione persona avvenuta" << endl;
	Persona::totalePersone += 1;
}


Persona::~Persona(){
	cout<< "Distruzione persona avvenuta" << endl;
}


char* Persona::getNome(){
	return this->nome;
}


char* Persona::getCognome(){
	return this->cognome;
}


int Persona::getEta(){
	return this->eta;
}


void Persona::setNome(char* nome){
	strncpy(this->nome, nome, this->max_char);
}


void Persona::setCognome(char* cognome){
	strncpy(this->cognome, cognome, this->max_char);
}


void Persona::setEta(int &eta){
	this->eta = eta;
}


void Persona::visualizzaPersona(){
	cout << this->nome << " " << this->cognome << " " << this->eta << endl;
}


// void Persona::eliminazionePersona(){
// 	delete(this);
// }


void Persona::viewTotalePersone(){
	cout << "Persone totali registrate sono: " << Persona::totalePersone << endl;
}



