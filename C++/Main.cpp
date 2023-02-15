/*
 * Main.cpp
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
#include "CoordinateBancarie.h"
#include "Bancomat.h"
#include "Account.h"

using namespace std;

void spaziatura(){
	cout << endl;
	cout << "---------------------------------" << endl;
	cout << endl;
}

template <class T>
void stampa(T a, char* before_text = ""){
	cout << before_text << " " << a << endl;
}


int WinMain() {
	Admin* a1 = new Admin("Giacomo", "Marini", 45);
	a1->visualizzaPersona();

	spaziatura();

	Staff* s1 = new Staff("Martina", "Bellini", 32);
	s1->visualizzaPersona();
	spaziatura();

	shared_ptr<CoordinateBancarie> bProva = make_shared<CoordinateBancarie>();
	Cliente* c1 = new Cliente("Cristiano", "Seghini", "3339998819", "c.seghini@gmail.com", "Via papa 30 Bg Azzano", bProva ,600);
	c1->visualizzaPersona();



	spaziatura();
	
	Bancomat* b1 = new Bancomat();
	b1->preleva(c1, opzioniPreleva::B);

	spaziatura();

	s1->aggiungiSaldoCliente(c1, 900);
	stampa(c1->getSaldo(), "Saldo utente"); // 1500
	s1->preleveSaldoCliente(c1, 1000);
	stampa(c1->getSaldo(), "Saldo utente"); // 500
	stampa(c1->getSpesaMensile(), "Spesa mensile"); // 500

	
	s1->creazioneAccount(c1);
	stampa(c1->getSpesaMensile(), "Spesa mensile"); // 500

	spaziatura();
	a1->clientiAffidabili();
	a1->eliminazioneStaff(s1);
	// a1->eliminazioneCliente(c1);
	a1->viewAccounts();
	a1->viewListaPersone(viewPersona::ADMIN);
	a1->makeFinanziamento(c1, 10000, 20);
	a1->eliminazioneCliente(c1);

	spaziatura();

	Account::movimenti(c1, "psw-g-1");
	Account::movimenti(c1, "psw-g-1");
	Account::movimenti(c1, "psw-g-1");

	a1->sbloccaAccCliente(c1);

	Account::movimenti(c1, "psw-ogg-1");
	Account::saldo(c1, "psw-ogg-1");
	Account::speseMensile(c1, "psw-ogg-1");



	// Bancomat* b1 = new Bancomat();
	// b1->setFuoriUso();
	// b1->mettiInUso(a1);
	// b1->preleva(c1, opzioniPreleva::B);
	// stampa(b1->getContantiPresenti(a1));
	// c1->viewInfoCliente();
	// b1->aggiungiContati(a1, 100);
	// stampa(b1->getContantiPresenti(a1));
	// b1->distruggiBancomat(a1);
	// stampa(b1->getContantiPresenti(a1));

	// Bancomat::viewOpzioniPrelevamento();
	// b1->preleva(c1, opzioniPreleva::B);



	printf("\nPress ENTER key to Continue \n");
	getchar();

	return 0;
}


