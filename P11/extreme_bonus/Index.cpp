#include "Index.h"
#include <algorithm> // for std::transform

void Index::add_word(const Word& word, const std::string& filename, int line) {
    // Convert word to lowercase and remove punctuation as described
    // (Implement the necessary code to clean up the word)

    // Convert word to lowercase
    Word lowercaseWord = word;
    std::transform(lowercaseWord.begin(), lowercaseWord.end(), lowercaseWord.begin(), ::tolower);

    // Insert a std::pair directly into the multimap
    _index.emplace(lowercaseWord, Location(filename, line));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (auto it = index._index.begin(); it != index._index.end(); /* no increment */) {
        // Print the word
        os << it->first << ": ";

        // Print locations for the current word
        auto range = index._index.equal_range(it->first);
        auto duplicateCheck = it->second;

        for (auto locIt = range.first; locIt != range.second; ++locIt) {
            // Check for duplicate entries on the same line
            if (duplicateCheck != locIt->second) {
                os << locIt->second << ", ";
                duplicateCheck = locIt->second;
            }
        }

        os << std::endl;

        // Move to the next word
        it = range.second;
    }
    return os;
}

