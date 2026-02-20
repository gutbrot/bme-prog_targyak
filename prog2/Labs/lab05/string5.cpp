/**
 *
 * \file string5.cpp
 *
 * Itt kell megvalósítania a hiányzó tagfüggvényeket.
 * Segítségül megadtuk a C++ nem OO eszközeinek felhasználásával készített String-kezelő
 * függvényke neveit.
 *
 * Ha valamit INLINE-ként valósít meg, akkor annak a string5.h-ba kell kerülnie,
 * akár kívül akár osztályon belül definiálja. (Az inline függvényeknek minden
 * fordítási egységben elérhetőknek kell lenniük)
 * *
 * A teszteléskor ne felejtse el beállítani a string5.h állományban az ELKESZULT makrót.
 *
 */

#ifdef _MSC_VER
// MSC ne adjon figyelmeztető üzenetet a C sztringkezelő függvényeire
  #define _CRT_SECURE_NO_WARNINGS
#endif

#include <iostream>             // Kiíratáshoz
#include <cstring>              // Sztringműveletekhez

#include "memtrace.h"           // a standard headerek után kell lennie
#include "string5.h"


/// Konstruktorok: egy char karakterből (createString)
///                egy nullával lezárt char sorozatból (createString)
String::String(const char c)
{
	len = 1;
	pData = new char[2];
	pData[0] = c; pData[1] = '\0';
}

String::String(const char* s)
{
	len = strlen(s);
	pData = new char[len + 1];
	strcpy(pData, s);
}

/// destruktor
String::~String()
{
	delete[] pData;
}

/// Másoló konstruktor: String-ből készít (createString)
String::String(const String& s)
{
	
	if (s.pData != nullptr)
	{
		len = s.len;
		pData = new char[len + 1];
		strcpy(pData, s.pData);
	}
	else
	{
		len = 0;
		pData = nullptr;
	}
}

/// operator=
String& String::operator=(const String& s)
{
	if (!(this == &s)) {
		delete[] pData;  
		if(s.pData != nullptr)
		{
			len = s.len;
			pData = new char[len + 1];
			strcpy(pData, s.pData);
		}
		else 
		{
			len = 0;
			pData = nullptr;
		}
	}
	return *this;
}

/// [] operátorok: egy megadott indexű elem REFERENCIÁJÁVAL térnek vissza (charAtString)
/// indexhiba esetén const char * kivételt dob!
char& String::operator[](size_t idx)
{
	if (idx >= len || len < 0)
		throw "JYSM53";
	return pData[idx];
}

/// + operátorok:
///                 String-hez jobbról karaktert ad (addString)
String String::operator+(const char c) const
{
	String uj;
	uj.len = len + 1;
	uj.pData = new char[uj.len + 1]; 
	strcpy(uj.pData, pData); 
	uj.pData[len] = c; 
	uj.pData[len + 1] = '\0';
	return uj;
}

/// String-hez String-et ad (addString)
String String::operator+(const String& s) const
{
	String uj;
	uj.len = this->len + s.len;
	uj.pData = new char[uj.len + 1]; // Új memóriafoglalás

	strcpy(uj.pData, this->pData); // Első string másolása
	strcat(uj.pData, s.pData); // Második string hozzáfűzése

	return uj;
}

String operator+(const char c, const String& s) // const
{
	String temp(c);
	String uj = temp + s; // fel kell szabaditani a tempet?
	return uj;
}

/// << operator, ami kiír az ostream-re
std::ostream& operator<<(std::ostream& os, String& s)
{
	os << s.c_str();
	return os;
}

/// >> operátor, ami beolvas az istream-ről egy szót

