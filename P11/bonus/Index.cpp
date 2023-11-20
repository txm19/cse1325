#include "Index.h"
#include <algorithm> // for std::transform

void Index::add_word(const Word& word, const std::string& filename, int line) {
    // Convert word to lowercase and remove punctuation as described
    // (Implement the necessary code to clean up the word)

    // Convert word to lowercase
    Word lowercaseWord = word;
    std::transform(lowercaseWord.begin(), lowercaseWord.end(), lowercaseWord.begin(), ::tolower);

    Locations& locations = _index[lowercaseWord];
    locations.emplace(filename, line);
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (const auto& entry : index._index) {
        os << entry.first << ": ";
        for (const auto& location : entry.second) {
            os << location << ", ";
        }
        os << std::endl;
    }
    return os;
}

