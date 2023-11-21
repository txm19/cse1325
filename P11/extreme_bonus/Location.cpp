// Location.cpp
#include "Location.h"
#include <algorithm> // for std::transform

std::string Location::last_filename = "";  // Initialize static field

Location::Location(const std::string& filename, int line) : _filename(filename), _line(line) {}

bool Location::operator==(const Location& location) const {
    // Compare the lowercase filenames and then line numbers
    return (to_lower(_filename) == to_lower(location._filename)) && (_line == location._line);
}

bool Location::operator!=(const Location& location) const {
    return !(*this == location);
}

bool Location::operator<(const Location& location) const {
    // Compare the lowercase filenames and then line numbers
    std::string lowercaseFilename1 = to_lower(_filename);
    std::string lowercaseFilename2 = to_lower(location._filename);

    if (lowercaseFilename1 == lowercaseFilename2) {
        return _line < location._line;
    } else {
        return lowercaseFilename1 < lowercaseFilename2;
    }
}

bool Location::operator>(const Location& location) const {
    return location < *this;
}

bool Location::operator<=(const Location& location) const {
    return !(*this > location);
}

bool Location::operator>=(const Location& location) const {
    return !(*this < location);
}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    // Output filename only if it differs from the last printed filename
    if (location._filename != Location::last_filename) {
        os << location._filename << " line ";
        Location::last_filename = location._filename;
    }
    os << location._line;
    return os;
}

void Location::next_word() {
    Location::last_filename = "";  // Reset last_filename for a new word
}

// Helper function to convert a string to lowercase
std::string Location::to_lower(const std::string& str) {
    std::string result = str;
    std::transform(result.begin(), result.end(), result.begin(), ::tolower);
    return result;
}

