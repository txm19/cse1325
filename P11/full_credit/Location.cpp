#include "Location.h"
#include <algorithm> // for std::transform

Location::Location(const std::string& filename, int line) : _filename(filename), _line(line) {}

bool Location::operator==(const Location& location) const {
    return (_filename == location._filename) && (_line == location._line);
}

bool Location::operator!=(const Location& location) const {
    return !(*this == location);
}

bool Location::operator<(const Location& location) const {
    // Convert filenames to lowercase for comparison
    std::string lowercaseFilename1 = _filename;
    std::string lowercaseFilename2 = location._filename;
    std::transform(lowercaseFilename1.begin(), lowercaseFilename1.end(), lowercaseFilename1.begin(), ::tolower);
    std::transform(lowercaseFilename2.begin(), lowercaseFilename2.end(), lowercaseFilename2.begin(), ::tolower);

    // Compare the lowercase filenames and then line numbers
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
    os << location._filename << " line " << location._line;
    return os;
}
