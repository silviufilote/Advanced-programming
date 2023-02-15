/*
 * Finanziamento.h
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */

#ifndef FINANZIAMENTO_H_
#define FINANZIAMENTO_H_

#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "Cliente.h"
#include "Admin.h"

using namespace std;

class Cliente;

class Finanziamento final{
    private:
        Cliente *cliente;
        int capitale;
        int capitaleFinanziato;
        int durataFinanziamento;

        friend class Admin;

        Finanziamento(Cliente *cliente, int capitale, int durataFinanziamento);
    protected:

    public:

        ~Finanziamento();
        void mancatoPagamento();
        void viewFinanziamento();

};



#endif /* FINANZIAMENTO_H_ */
