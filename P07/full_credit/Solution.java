import java.util.Comparator;
import java.util.TreeSet;
import java.util.Scanner;


public class Solution implements Comparable<Solution> {
    private String name;
    private String word;
    private int x;
    private int y;
    private Direction direction;

    public Solution(String name, String word, int x, int y, Direction direction) {
        this.name = name;
        this.word = word;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

  
    @Override
    public int compareTo(Solution other) {
        // Compare by 'name' field first
        int nameComparison = this.name.compareTo(other.name);

        if (nameComparison == 0) {
            // If 'name' fields are the same, compare by 'word' field
            int wordComparison = this.word.compareTo(other.word);

            if (wordComparison == 0) {
                // If 'word' fields are also the same, consider them equal
                return 0;
            } else {
                return wordComparison;
            }
        } else {
            return nameComparison;
        }
    }

    @Override
    public String toString() {
        return String.format("In %s: %s found at (%d,%d,%s)", name, word, x, y, direction);
    }
}

