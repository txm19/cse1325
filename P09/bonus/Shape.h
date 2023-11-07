#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape {
public:
    virtual ~Shape() {}

    virtual std::string name() const = 0;  // Pure virtual method
    virtual double area() const = 0;       // Pure virtual method

    virtual std::string to_string() const {
        return name() + " with area " + std::to_string(area());
    }
};

#endif // SHAPE_H

