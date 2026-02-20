/**
 *  \file haromszog.h
 *  Haromszog osztály deklarációja
 */
#ifndef HAROMSZOG_H
#define HAROMSZOG_H

#include "alakzat.h"
#include "pont.h"

class Haromszog : public Alakzat {
	Pont pont1;
	Pont pont2;
public:
	Haromszog(const Pont& p0, const Pont& p1, const Pont& p2, Szin s) 
		: Alakzat(p0, s), pont1(p1-p0), pont2(p2-p0) { }
	void rajzol() const;
	Pont getp1() const { return getp0() + pont1; }
	Pont getp2() const { return getp0() + pont2; }
};

std::ostream& operator<<(std::ostream& os, const Haromszog& sz);

#endif // KOR_H

