package library;
import java.util.ArrayList;

public class Library {
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>(); /
    }
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    public void checkOut(int publicationIndex, String patron) {
        publications.get(publicationIndex).checkOut(patron);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications; 
}

package library;

import java.util.ArrayList;

/**
 * Represents a library with a collection of publications.
 * This class allows you to add publications and manage checkouts.
 */
public class Library {
    /**
     * Initializes a new library with the given name.
     *
     * @param name The name of the library.
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    /**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to add.
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    // ... Other methods and JavaDoc comments ...

    @Override
    public String toString() {
        // ... JavaDoc comment ...
    }

    // ... Other fields and JavaDoc comments ...

    private String name;
    private ArrayList<Publication> publications;
}

