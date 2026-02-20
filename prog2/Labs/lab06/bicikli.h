#pragma once
#include <iostream>

using std::cout;
using std::endl;

class Kerek {
private:
	int atmero;
public:
	Kerek(int p) : atmero(p) { cout << "\tKerek ctor\n"; };
	Kerek(const Kerek& k) : atmero(k.atmero) { cout << "\tKerek copy\n"; }
	void kiir() const { cout << "atmero=" << atmero << std::endl; }
	virtual ~Kerek() { cout << "\tKerek dtor\n"; };
};

/*
class Monocikli {
	Kerek k;
public:
	Monocikli() :k(16) { cout << "\tMonocikli ctor\n"; };
	Monocikli(const Monocikli& m):k(m.k) { cout << "\tMonocikli copy\n"; }
	void kiir() { cout << "\tk."; k.kiir(); }
};
*/
class Jarmu {
private:
	double vMax;
public:
	Jarmu(double v) : vMax(v) { cout << "\tJarmu ctor vMax=" << vMax << endl; }
	Jarmu(const Jarmu& j) : vMax(j.vMax) { cout << "\tJarmu copy vMax=" << vMax << endl; }
	virtual ~Jarmu() { cout << "\tJarmu dtor vMax=" << vMax << endl; }
};

class Szan : public Jarmu {
private:
	int kutyakSzama;
public:
	Szan(double v = 0, int n = 0) : Jarmu(v), kutyakSzama(n) { cout << "\tSzan ctor kutyakSzama=" << kutyakSzama << endl; }
	Szan(const Szan& s) : Jarmu(s), kutyakSzama(s.kutyakSzama) { cout << "\tSzan copy kutyakSzama=" << kutyakSzama << endl; }
	~Szan() { cout << "\tSzan dtor kutyakSzama=" << kutyakSzama << endl; }
};

class Bicikli : public Jarmu {
private:
	Kerek elso;
	Kerek hatso;
public:
	Bicikli(const double v = 0, const int d = 0) : Jarmu(v), elso(Kerek(d)), hatso(Kerek(d)) { cout << "\tBicikli ctor "; elso.kiir(); }
	Bicikli(const Bicikli& b): Jarmu(b), elso(Kerek(b.elso)), hatso(Kerek(b.hatso)) { cout << "\tBicikli copy "; elso.kiir(); };
	~Bicikli() { cout << "\tBicikli dtor "; elso.kiir(); }
};