/*
 * Staff.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef STAFF_H_
#define STAFF_H_

#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include "Persona.h"
#include "Cliente.h"

class Cliente;

using namespace std;

class Staff: public Persona{
	private:
		char* idStaff;
		static int count;
	protected:

	public:
		Staff(char* nome, char* cognome, int eta = 0);
		~Staff();

		void aggiungiSaldoCliente(Cliente* c, int saldo);
		void preleveSaldoCliente(Cliente* c, int saldo);
		void creazioneAccount(Cliente* c); // ?

		char* getIdStaff();

		void visualizzaPersona() override;
};



#endif /* STAFF_H_ */
