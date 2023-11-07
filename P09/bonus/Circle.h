#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double r);

    std::string name() const override;
    double area() const override;
    std::string to_string() const override;
};

#endif // CIRCLE_H

