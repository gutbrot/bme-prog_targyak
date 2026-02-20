/**
 * \file: mystack.hpp
 *
 */
#include <vector>

template <class T, class Container = std::vector<T> >
class MyStack : protected Container {
public:
    MyStack() : Container() {}
    ~MyStack() = default;
    T& top() {
        if (empty()) 
            throw std::runtime_error("MyStack::top(): Ures stack!");
        return Container::at(Container::size() - 1);
    }
    void push(const T& t) {
        Container::push_back(t);
    }
    void pop() {
        if (empty()) 
            throw std::runtime_error("MyStack::top(): Ures stack!");
        Container::pop_back();
    }
    bool empty() {
        return Container::size() == 0;
    }
};