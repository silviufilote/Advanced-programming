/*
 * CoordinateBancarie.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#include <iostream>
#include <cstring>
#include <string>
#include "CoordinateBancarie.h"

using namespace std;

CoordinateBancarie::CoordinateBancarie(){}

CoordinateBancarie::CoordinateBancarie(char* IBAN, char* codicePaese, char* nConto): IBAN(IBAN), codicePaese(codicePaese), nConto(nConto) {}

void CoordinateBancarie::eliminazioneCBancario(){
	delete(this);
}

CoordinateBancarie::~CoordinateBancarie(){
	cout << "Eliminazione conto bancario avvenuta" << endl;
}
