#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double r);

    std::string to_string() const override;

    double area() const override;
};

#endif // CIRCLE_H

