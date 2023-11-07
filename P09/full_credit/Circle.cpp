#include "Circle.h"
#include <cmath>

// Constructor implementation
Circle::Circle(double r) : radius(r) {}

// Define the area function
double Circle::area() const {
    return M_PI * radius * radius;
}

// Define the to_string function
std::string Circle::to_string() const {
    return "Circle of radius " + std::to_string(radius) + " with the area " + std::to_string(area());
}

