// Fájl: fuggvenyeim.cpp
// Ebben találhatók a függvények prototípusai,
// típusok, konstansok, egyéb deklarációk

#ifndef FUGGVENYEIM_H
#define FUGGVENYEIM_H
/*
 * csere
 * Két int adat felcserélése
 * @param a - egyik adat
 * @param b - másik adat
 */
void csere(int& a, int& b);

/*
 * max
 * Két int adat közül a nagyobb
 * @param a - egyik adat
 * @param b - másik adat
 */
// Ez egy inline függvény, amit minden fordítási
// egységben definiálni kell.
inline int max(int a, int b) { return a > b ? a : b; }


/// Segédfüggvény double pontosságú számok összehasonlításához
bool almostEQ(double a, double  b);

/* n-ed fokú valós polinom helyettesítési értékét számolja ki
 * @param x - behelyettesítési érték, erre az értékre oldódik meg a feladat
 * @param egyutthatok - a polinom együtthatói
 * @param fok - a polinom legnagyobb fokszáma
*/
double polinom(double x, double egyutthatok[], int fok);

/* n-ed fokú valós polinom helyettesítési értékét számolja ki a Horner elrendezéssel
 * @param x - behelyettesítési érték, erre az értékre oldódik meg a feladat
 * @param egyutthatok - a polinom együtthatói
 * @param fok - a polinom legnagyobb fokszáma
*/
double horner(double x, double egyutthatok[], int fok);

#endif // FUGGVENYEIM_H
