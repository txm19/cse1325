#ifndef TIME_H
#define TIME_H

#include <iostream>

class Time {
private:
    int _hour;
    int _minute;
    int _second;

public:
    Time(int hour, int minute, int second);
    Time();

    // Rationalize the time (private method)
    void rationalize();

    // Overloaded operators
    Time operator+(const Time& other) const;
    Time& operator++();    // Pre-increment
    Time operator++(int);  // Post-increment
    bool operator==(const Time& other) const;
    bool operator!=(const Time& other) const;
    bool operator<(const Time& other) const;
    bool operator>(const Time& other) const;
    bool operator<=(const Time& other) const;
    bool operator>=(const Time& other) const;

    // Friend functions for streaming in and out
    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
};

#endif // TIME_H

