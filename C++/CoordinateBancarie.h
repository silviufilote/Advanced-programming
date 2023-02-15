/*
 * CoordinateBancarie.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef COORDINATEBANCARIE_H_
#define COORDINATEBANCARIE_H_

#include <iostream>
#include <cstring>
#include <string>

using namespace std;

class CoordinateBancarie final{
	private:
		char* IBAN;
		char* codicePaese;
		char* nConto;

	protected:

	public:
		CoordinateBancarie();
		CoordinateBancarie(char* IBAN, char* codicePaese, char* nConto);
		~CoordinateBancarie();
		void eliminazioneCBancario();
};



#endif /* COORDINATEBANCARIE_H_ */
