/*
 * Persona.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef PERSONA_H_
#define PERSONA_H_

#include <iostream>
#include <cstring>
#include <string>

using namespace std;


class Persona{
	private:
		char *nome;
		char *cognome;
		int eta;
		int const max_char = 10;


	protected:


	public:
		static int totalePersone;
		Persona(char* n, char* c, int e = 0);
		virtual ~Persona();

		char* getNome();
		char* getCognome();
		int getEta();

		void setNome(char* nome);
		void setCognome(char* cognome);
		void setEta(int &eta);

		virtual void visualizzaPersona();
		void eliminazionePersona();
		static void viewTotalePersone();
};



#endif /* PERSONA_H_ */
