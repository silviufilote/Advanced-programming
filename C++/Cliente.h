/*
 * Cliente.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef CLIENTE_H_
#define CLIENTE_H_


#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "CoordinateBancarie.h"
#include "Finanziamento.h"

using namespace std;


class Cliente: public Persona{
	private:
		char* idCliente;
		char* phone;
		char* mail;
		bool affidabile;
		int saldo;
		char* indirizzo;
		shared_ptr <CoordinateBancarie> cbank;
		bool agevolazioneEta;
		static int count;
		float spesaMensile;
	protected:

	public:
		Cliente(char* nome, char* cognome, char* phone, char* mail, char* indirizzo, shared_ptr <CoordinateBancarie> cbank, int capitale, int eta = 0);
		~Cliente();

		vector<Finanziamento*> listaFinanziamenti;
		vector<int> movimento;


		char* getIdCliente();
		char* getPhone();
		char* getMail();
		bool getAffidabilita();
		int getSaldo();
		char* getIndrizzo();
		shared_ptr<CoordinateBancarie> getConto();
		bool getAgevolazione();
		void viewInfoCliente();
		float getSpesaMensile();

		void setAffidabile(bool affidabile);
		void setSaldo(int saldo);
		void setSpesaMensile(int spesa);

		void visualizzaPersona() override;
};





#endif /* CLIENTE_H_ */
