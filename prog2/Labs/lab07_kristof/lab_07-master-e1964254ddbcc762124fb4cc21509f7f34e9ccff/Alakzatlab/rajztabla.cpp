/**
 *  \file rajztabla.cpp
 *   Ebben a fájlban valósítsa meg a Rajztábla osztály nem inline tagfüggvényeit
 */


#include "rajztabla.h"
#include <iostream>

/// Alakzatot tesz a rajztáblára
/// @param ap - pointer az alakzatra
void Rajztabla::felrak(Alakzat *ap) {
    if (db < MAXDB) {
        tabla[db++] = ap;
    } else {
        std::cerr << "Hiba: A rajztábla megtelt, nem lehet több alakzatot hozzáadni!" << std::endl;
    }
}

/// Kirajzolja az összes alakzatot
void Rajztabla::rajzol() const {
    for (size_t i = 0; i < db; i++) {
        tabla[i]->rajzol();
    }
}

/// Az összes alakzatot elmozdítja
/// @param d - eltolás vektora
void Rajztabla::mozgat(const Pont& d) const {
    for (size_t i = 0; i < db; i++) {
        tabla[i]->mozgat(d);
    }
}

Rajztabla::~Rajztabla() {
    for (size_t i = 0; i < db; i++) {
        delete tabla[i];
    }
}

void Rajztabla::torol() {
    for (size_t i = 0; i < db; i++) {
        delete tabla[i];
    }
    db = 0;
}

std::ostream& operator<<(std::ostream& os, const Rajztabla& rt) {
    os << "Rajztáblán levő alakzatok száma: " << rt.size();
    return os;
}
