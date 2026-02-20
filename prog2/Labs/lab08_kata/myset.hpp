#ifndef MYSET
#define MYSET

#include "point.h"

#define ELKESZULT 4

bool operator==(const Point& lhs, const Point& rhs) {
    return lhs.getX() == rhs.getX() && lhs.getY() == rhs.getY();
}

template<typename T>
bool equal(const T& a, const T& b) {
    return a == b;
}

bool equal(const Point& a, const Point& b) {
    return a.getX() == b.getX();
}

template<typename T, size_t cap = 10>
class Set {
    T arr[cap];
    size_t s;
public:
    Set() : s(0) {}
    size_t size() { return s; }
    bool isElement(T el) {
        for (size_t i = 0; i < s; i++)
            if (equal(arr[i], el))
                return true;
        return false;
    }
    void insert(T el) {
        if (s >= cap) throw "AJAJ";
        if (isElement(el)) return;
        arr[s++] = el;
    }
    ~Set() {}
};

#endif