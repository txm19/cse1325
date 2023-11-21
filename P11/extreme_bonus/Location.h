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
    static std::string last_filename;  // Static field to remember the last printed filename
    Location(const std::string& filename, int line);
    bool operator==(const Location& location) const;
    bool operator!=(const Location& location) const;
    bool operator<(const Location& location) const;
    bool operator>(const Location& location) const;
    bool operator<=(const Location& location) const;
    bool operator>=(const Location& location) const;
    friend std::ostream& operator<<(std::ostream& os, const Location& location);
    static void next_word();  // Static method to reset last_filename for a new word
    static std::string to_lower(const std::string& str);  // Static method to convert a string to lowercase
};

#endif // LOCATION_H

