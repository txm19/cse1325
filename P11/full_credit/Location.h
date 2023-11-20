// Location.h
#ifndef LOCATION_H
#define LOCATION_H

#include <string>
#include <ostream>

class Location {
private:
    std::string _filename;
    int _line;

public:
    Location(const std::string& filename, int line);
    bool operator==(const Location& location) const;
    bool operator!=(const Location& location) const;
    bool operator<(const Location& location) const;
    bool operator>(const Location& location) const;
    bool operator<=(const Location& location) const;
    bool operator>=(const Location& location) const;
    friend std::ostream& operator<<(std::ostream& os, const Location& location);
};

#endif // LOCATION_H

