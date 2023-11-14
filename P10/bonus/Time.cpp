#include "Time.h"
#include <iomanip>

Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second) {
    rationalize();
}

Time::Time() : _hour(0), _minute(0), _second(0) {}

void Time::rationalize() {
    _minute += _second / 60;
    _second = (_second % 60 + 60) % 60;

    _hour += _minute / 60;
    _minute = (_minute % 60 + 60) % 60;

    while (_hour < 0) {
        _hour += 24;
    }

    _hour %= 24;
}

Time Time::operator+(const Time& other) const {
    Time result(*this);
    result._hour += other._hour;
    result._minute += other._minute;
    result._second += other._second;
    result.rationalize();
    return result;
}

Time& Time::operator++() {
    ++_second;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time temp(*this);
    ++(*this);
    return temp;
}

bool Time::operator==(const Time& other) const {
    return _hour == other._hour && _minute == other._minute && _second == other._second;
}

bool Time::operator!=(const Time& other) const {
    return !(*this == other);
}

bool Time::operator<(const Time& other) const {
    if (_hour != other._hour) return _hour < other._hour;
    if (_minute != other._minute) return _minute < other._minute;
    return _second < other._second;
}

bool Time::operator>(const Time& other) const {
    return other < *this;
}

bool Time::operator<=(const Time& other) const {
    return !(*this > other);
}

bool Time::operator>=(const Time& other) const {
    return !(*this < other);
}

Time Time::operator+(int seconds) const {
    Time result(*this);
    result._second += seconds;
    result.rationalize();
    return result;
}

Time operator+(int seconds, const Time& time) {
    return time + seconds;
}

std::ostream& operator<<(std::ostream& os, const Time& time) {
    os << std::setfill('0') << std::setw(2) << time._hour << ":"
       << std::setfill('0') << std::setw(2) << time._minute << ":"
       << std::setfill('0') << std::setw(2) << time._second;
    return os;
}

std::istream& operator>>(std::istream& is, Time& time) {
    char colon1, colon2;
    is >> std::setw(2) >> time._hour >> colon1 >> std::setw(2) >> time._minute >> colon2 >> std::setw(2) >> time._second;

    if (is.fail() || colon1 != ':' || colon2 != ':') {
        is.setstate(std::ios::failbit);
        return is;
    }

    time.rationalize();

    return is;
}

