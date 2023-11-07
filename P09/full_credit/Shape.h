#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape {
public:
    Shape() {}
    virtual ~Shape() {}

    virtual std::string name() const {
        return "Shape";
    }

    virtual double area() const = 0; // Declaring area() as abstract

    virtual std::string to_string() const {
        return name() + ": Area = " + std::to_string(area());
    }
};

#endif // SHAPE_H
