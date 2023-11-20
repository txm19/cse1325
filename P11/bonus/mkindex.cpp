// mkindex.cpp
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>

#include "Index.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <filename1> <filename2> ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;

        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                // Clean up the word as described (convert to lowercase, remove punctuation)
                // Add the word to the index along with the current filename and line number
                index.add_word(word, argv[i], line_number);
            }

            line_number++;
        }

        file.close();
    }

    std::cout << "Index" << std::endl;
    std::cout << "===== " << std::endl;
    std::cout << index;

    return 0;
}

