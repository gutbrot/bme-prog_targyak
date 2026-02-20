/**
 * \file resistor.cpp
 *   (UTF-8 kodolasu fajl. Allitsa at a megjenetes kodolasat,
 *    ha a tovabbi kommentek nem olvashatok helyesen!)
 *
 * Ohmikus ellenállást modellező osztály megvalósítása
 */

/**
 * Itt kell megvalósítani a resistor.h-ban deklarált nem inline függvényeket.
 * A Jportára ezt a fájlt kell feltölteni.
 */

#include "resistor.h"

double Resistor::defR = 107;  // Statikus adattag inicializálása

Resistor::Resistor()
{
    this->R = defR;  // Az alapértelmezett érték a statikus defR-ből jön
    Pr("ctor0");
}

Resistor::Resistor(double r)
{
    this->R = r;
    Pr("ctor1");
}

#ifndef NO_STATIC
void Resistor::setDef(double r)
{
    defR = r;
}
#endif

Resistor Resistor::operator+(const Resistor& r) const
{
    return Resistor(this->R + r.R);
}

Resistor Resistor::operator%(const Resistor& r) const
{
    return Resistor(1 / ((1 / this->R) + (1 / r.R)));
}

//masolo konstruktor
Resistor::Resistor(const Resistor& rhs) :R(rhs.R)
{
    Pr("copy");
}

Resistor::~Resistor()
{
    Pr("dtor");
}

Resistor& Resistor::operator=(const Resistor& rhs)
{
    R = rhs.R;
    Pr("assign");
    return *this;
}

double Resistor::getI(double u) const
{
    return u/R;
}

double Resistor::getU(double i) const
{
    return i*R;
}

bool Resistor::operator==(const Resistor& r) const
{
    const double EPS = 1e-7;
    double abs = R - r.R;
    if (abs < 0)
        abs *= -1;
    if (abs < EPS)
        return true;
    return false;
}

Resistor operator*(int n, const Resistor& r)
{
    if (n <= 0)
        throw "JYSM53";
    return Resistor(r.getR() * n);
}

std::ostream& operator<<(std::ostream& os, const Resistor& rhs)
{
    os << rhs.getR();
    return os;
}
