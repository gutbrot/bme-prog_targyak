#ifndef USTRING_H
#define USTRING_H
#include <iostream>
#include <stdbool.h>
#include "string5.h"
#include "ustring.h"

using namespace std;

class UString: public String{
    private:
        static bool uCase;
    public:
        static void UCase(bool);
        static bool UCase();

        UString(): String() {};
        UString(char ch): String(ch) {};
        UString(const char *p): String(p) {};
        UString(const String& s1): String(s1) {};
};

void toUpperCase(string &s);
ostream& operator<<(ostream& os, const UString& s);


#endif // USTRING_H
