#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>

// Custom comparison function for sorting no_caps
bool compareNoCaps(const std::string& a, const std::string& b) {
    // First, compare by length
    if (a.length() < b.length()) {
        return true;
    } else if (a.length() > b.length()) {
        return false;
    }
    // If lengths are equal, use natural sort order
    return a < b;
}

int main(int argc, char* argv[]) {
    std::vector<std::string> caps;    // Vector for capitalized words
    std::vector<std::string> no_caps; // Vector for lowercase words

    // Start from the first argument (argv[0] is the program name)
    for (int i = 1; i < argc; ++i) {
        std::string word = argv[i];
        
        if (!word.empty()) {
            // Check if the first character of the word is uppercase
            if (std::isupper(word[0])) {
                caps.push_back(word);
            } else {
                no_caps.push_back(word);
            }
        }
    }

    // Sort the caps vector by natural sort order
    std::sort(caps.begin(), caps.end());

    // Sort the no_caps vector based on length and then natural sort order
    std::sort(no_caps.begin(), no_caps.end(), compareNoCaps);

    // Print capitalized words
    std::cout << "Capitalized:" << std::endl;
    for (const std::string& word : caps) {
        std::cout << word << std::endl;
    }

    // Print lowercase words
    std::cout << "Lower Case:" << std::endl;
    for (const std::string& word : no_caps) {
        std::cout << word << std::endl;
    }

    return 0;
}

