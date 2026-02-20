/*
 * \file sablonok.hpp
 */
#include <iostream>

#ifndef SABLONOK_HPP
#define SABLONOK_HPP
template <typename Iter>
void printEach(Iter first, Iter last, std::ostream& os = std::cout, const char* sep = ", ") {
    if (first == last) {
        os << std::endl;
        return;
    }
    while (first != last){
        os << *first;
        if (++first == last) 
            os << std::endl;
        else os << sep;
    }
}

template<typename T>
int szamol_ha_negativ(T first, T last) {
    int count = 0;
    for (; first != last; ++first)
        if (*first < 0)
            count++;
    return count;
}

template<typename T>
class nagyobb_mint {
    T val;
public:
    nagyobb_mint(T val) : val(val) {}
    bool operator()(T v) { return v > val; }
};

template<typename T, typename P>
int szamol_ha(T begin, T end, P pred) {
    int count = 0;

    for (; begin != end; ++begin)
        if (pred(*begin))
            count++;

    return count;
}

#endif
