/*
 * Finanziamento.cpp
 *
 *  Created on: 15 feb 2023
 *      Author: fsilv
 */


#include <iostream>
#include <cstring>
#include <string>
#include <memory>
#include <vector>
#include "Persona.h"
#include "Cliente.h"
#include "Finanziamento.h"

using namespace std;


Finanziamento::Finanziamento(Cliente *c, int capitale, int durataFinanziamento ){

    if(c == NULL || capitale < 0 || durataFinanziamento < 0)
        throw std::invalid_argument("Errore inseriemento dati finanziamento");

    this->cliente = c;
    this->capitale = capitale;

    if(c->getAgevolazione())
        this->capitaleFinanziato = capitale + (capitale * 0.10);
    else
        this->capitaleFinanziato = capitale + (capitale * 0.20);

    this->durataFinanziamento = durataFinanziamento;

    float spesaMensile =  this->capitaleFinanziato / durataFinanziamento;

    c->setSpesaMensile(spesaMensile);
    c->listaFinanziamenti.push_back(this);
}

Finanziamento::~Finanziamento(){
    cout<< "Cancellazione finanziamento" <<endl;
}


void Finanziamento::viewFinanziamento(){
    cout << this->cliente->getIdCliente() << " " << this->capitaleFinanziato << endl;
}

