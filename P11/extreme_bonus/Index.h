// Index.h
#ifndef INDEX_H
#define INDEX_H

#include <map>
#include <string>
#include <ostream>

#include "Location.h"

class Index {
private:
    using Word = std::string;
    std::multimap<Word, Location> _index;  // Change here

public:
    void add_word(const Word& word, const std::string& filename, int line);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);
};

#endif // INDEX_H

