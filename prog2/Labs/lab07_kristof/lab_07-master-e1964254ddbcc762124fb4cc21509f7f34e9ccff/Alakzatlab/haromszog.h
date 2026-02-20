/**
 *  \file haromszog.h
 *  Haromszog osztály deklarációja
 */
#ifndef HAROMSZOG_H
#define HAROMSZOG_H

#include "alakzat.h"
/// Haromszog osztály
class Haromszog : public Alakzat {
    Pont p1;  //második csúcspont
    Pont p2;  //harmadik csúcspont
public:
    //p0=kezdőpont
    //p1=második csúcspont
    //p2=harmadik csúcspont
    //sz=szín és átlátszóság
    Haromszog(const Pont& p0, const Pont& p1, const Pont &p2, Szin sz)
                    :Alakzat(p0, sz), p1(p1-p0), p2(p2-p0)
                    {}
    Pont getp1() const { return getp0()+p1; }
    Pont getp2() const { return getp0()+p2; }
    void rajzol() const;
};
std::ostream& operator<<(std::ostream& os, const Haromszog& t);
#endif // HAROMSZOG_H
