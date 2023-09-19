package library;

import java.time.LocalDate;

class Publication {
    public static final int LOAN_PERIOD = 14; 
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + ", copyright " + copyright
            + ((loanedTo != null) ? "\n  : loaned to " + loanedTo + " until " + dueDate
                                  : "");
    }
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;
}

import java.time.LocalDate;

/**
 * Represents a publication in the library's collection.
 */
public class Publication {
    // ... Existing code ...

    /**
     * Initializes a new publication with the given title, author, and copyright year.
     *
     * @param title     The title of the publication.
     * @param author    The author of the publication.
     * @param copyright The copyright year of the publication.
     * @throws IllegalArgumentException If the copyright year is not within the valid range.
     */
    public Publication(String title, String author, int copyright) {
        // ... Existing constructor code ...
    }

    /**
     * Checks out the publication to a patron.
     *
     * @param patron The patron checking out the publication.
     */
    public void checkOut(String patron) {
        // ... Existing code ...
    }

    /**
     * Checks in the publication.
     */
    public void checkIn() {
        // ... Existing code ...
    }

    /**
     * Generates a string representation of the publication.
     *
     * @return A string containing publication information.
     */
    @Override
    public String toString() {
        // ... Existing code ...
    }

    // ... Existing fields ...
}

