#include "ustring.h"
#include "string5.h"
#include <iostream>
#include <stdbool.h>
#include <string>

using namespace std;
bool UString::uCase = false;

void UString::UCase(bool state){
    uCase = state;
}

bool UString::UCase(){
    return uCase;
}

void toUpperCase(string &s){
    int strlen = s.size();
    for (int i = 0; i < strlen; i++)
        s[i] = toupper(s[i]);
}

ostream& operator<<(ostream& os, const UString& s){
    string tmps = s.c_str();
    if (s.UCase()){
        toUpperCase(tmps);
    }
    os << tmps;
    return os;
}

