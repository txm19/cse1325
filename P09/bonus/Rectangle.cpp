#include "Rectangle.h"

Rectangle::Rectangle(double w, double h) : width(w), height(h) {}

std::string Rectangle::name() const {
    return "Rectangle";
}

double Rectangle::area() const {
    return width * height;
}

std::string Rectangle::to_string() const {
    return std::to_string(width) + " X " + std::to_string(height) + " Rectangle with area " + std::to_string(area());
}

