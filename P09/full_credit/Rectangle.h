#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {
private:
    double width;
    double height;

public:
    Rectangle(double w, double h);

    std::string name() const override;
    double area() const override;
    std::string to_string() const override; // Declare to_string in the header
};

#endif // RECTANGLE_H

