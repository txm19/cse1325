// Index.h
#ifndef INDEX_H
#define INDEX_H

#include <map>
#include <set>
#include <string>
#include <ostream>

#include "Location.h"

class Index {
private:
    using Locations = std::set<Location>;
    using Word = std::string;
    std::map<Word, Locations> _index;

public:
    void add_word(const Word& word, const std::string& filename, int line);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);
};

#endif // INDEX_H

