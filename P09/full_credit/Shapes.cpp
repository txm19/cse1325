#include <iostream>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"

int main() {
    std::vector<Shape*> shapes;
    shapes.push_back(new Rectangle(5, 6));
    shapes.push_back(new Circle(4.5));

    for (const auto& shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    // Clean up the dynamically allocated objects
    for (const auto& shape : shapes) {
        delete shape;
    }

    return 0;
}
