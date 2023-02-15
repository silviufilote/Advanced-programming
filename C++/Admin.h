/*
 * Admin.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef ADMIN_H_
#define ADMIN_H_

#include <iostream>
#include <cstring>
#include <string>
#include "Persona.h"
#include "Cliente.h"
#include "Bancomat.h"
#include "Staff.h"

using namespace std;

class Cliente;
class Staff;


enum viewPersona {CLIENTE, STASFF, ADMIN};

class Admin: public Persona{
	private:
		static int count;
		char* idAdmin;

	protected:
		static vector<Admin*> listaAdmin;

	public:
		static vector<Cliente*> listaClienti;
		static vector<Staff*> listaStaff;

		Admin(char* nome, char* cognome, int eta);
		~Admin();

		void sbloccaAccCliente(Cliente * const c);
		void clientiAffidabili();
		void viewListaPersone(viewPersona item);
		void viewAccounts();
		void sbloccaBancomat(Bancomat * const b);
		void eliminaAdmin();
		void viewFinanziamentoCLiente(Cliente * const c);
		void makeFinanziamento(Cliente * const c, int capitale, int durata);
		void eliminazioneCliente(Cliente * c);
		void eliminazioneStaff(Staff* s);
		
		void visualizzaPersona() override;
};




#endif /* ADMIN_H_ */
