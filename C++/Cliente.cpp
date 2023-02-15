/*
 * Cliente.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */


#include <iostream>
#include <cstring>
#include <string>
#include "Persona.h"
#include "Admin.h"
#include "Cliente.h"
#include "CoordinateBancarie.h"

using namespace std;

int Cliente::count = 1;

Cliente::Cliente(char* nome, char* cognome, char* phone, char* mail, char* indirizzo, shared_ptr <CoordinateBancarie> cbank, int capitale, int eta) : Persona(nome, cognome, eta){ // @suppress("Class members should be properly initialized")

	if(strlen(phone) == 0 ||  strlen(mail) == 0 || strlen(indirizzo) == 0 || cbank == NULL || capitale < 0)
		throw std::invalid_argument("Errore inseriemento dati cliente");

	if(eta < 26)
		this->agevolazioneEta = true;
	else
		this->agevolazioneEta = false;

	try{
		//this->phone = new char();
		this->phone = new char();
		this->idCliente = new char();
		this->mail = (char*)malloc(sizeof(char) * 10);
		this->indirizzo = (char*)malloc(sizeof(char) * 10);
		this->spesaMensile = 0;

		sprintf(this->idCliente, "ID-CLIENTE%i", Cliente::count);
		strcpy(this->phone, phone);
		strcpy(this->mail, mail);
		this->affidabile = true;
		strcpy(this->indirizzo, indirizzo);
		this->cbank = cbank;
		this->saldo = capitale;

		Admin::listaClienti.push_back(this);
		Cliente::count++;
	} catch (std::exception& e){ std::cerr << "Errore inseriemnto dati finali: " << e.what() << std::endl; }

	cout << "Crezione cliente avvenuta" << endl;
}


Cliente::~Cliente(){
	cout << "Distruzione Cliente avvenuta" << endl;
}


char* Cliente::getIdCliente(){
	return this->idCliente;
}

char* Cliente::getPhone(){
	return this->phone;
}

char* Cliente::getMail(){
	return this->mail;
}

bool Cliente::getAffidabilita(){
	return this->affidabile;
}

int Cliente::getSaldo(){
	return this->saldo;
}

char* Cliente::getIndrizzo(){
	return this->indirizzo;
}

shared_ptr<CoordinateBancarie> Cliente::getConto(){
	return this->cbank;
}

bool Cliente::getAgevolazione(){
	return this->agevolazioneEta;
}

void Cliente::viewInfoCliente(){
	cout << "-- Id cliente: " << this->idCliente << endl;
	cout << "-- Numero telefono: " << this->phone << endl;
	cout << "-- Mail: " << this->mail << endl;
	cout << "-- Affidabile: " << this->affidabile << endl;
	cout << "-- Saldo totale: " << this->getSaldo() << endl;
	cout << "-- Indirizzo: " << this->indirizzo << endl;
}

float Cliente::getSpesaMensile(){
	return this->spesaMensile;
}



void Cliente::setSpesaMensile(int spesa){
	this->spesaMensile += spesa;
}


void Cliente::setSaldo(int saldo){
	this->saldo += saldo;
}


void Cliente::setAffidabile(bool affidabile){
	this->affidabile = affidabile;
}


void Cliente::visualizzaPersona(){
    cout << this->idCliente << " " << this->getNome() << " " << this->getCognome() << endl;
}


