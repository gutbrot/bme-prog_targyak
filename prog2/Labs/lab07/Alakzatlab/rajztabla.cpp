/**
 *  \file rajztabla.cpp
 *   Ebben a fájlban valósítsa meg a Rajztábla osztály nem inline tagfüggvényeit
 */


#include "rajztabla.h"


void Rajztabla::felrak(Alakzat* ap)
{
	if (db < MAXDB)
		tabla[db++] = ap;
	else
		throw "Error";
}

void Rajztabla::rajzol() const
{
	for (size_t i = db; i < db; i++)
	{
		tabla[i]->rajzol();
	}
}

void Rajztabla::mozgat(const Pont& d) const
{
	for (size_t i = db; i < db; i++)
	{
		tabla[i]->mozgat(d);
	}
}

void Rajztabla::torol() {
	for (size_t i = 0; i < db; ++i) {
		delete tabla[i];
	}
	db = 0;
}

Rajztabla::~Rajztabla() {
	for (size_t i = 0; i < db; i++) {
		delete tabla[i];
	}
}