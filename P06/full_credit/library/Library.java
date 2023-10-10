package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Models a library containing various publications.
 *
 * @author Tista Manandhar
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */
public class Library {
    private String name;
    private ArrayList<Publication> publications;

    /**
     * Creates a Library instance.
     *
     * @param name the name of the library
     * @since 1.0
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    /**
     * Creates a Library instance from a BufferedReader.
     *
     * @param br BufferedReader containing library data
     * @throws IOException if there is an error reading the data
     * @since 1.0
     */
    public Library(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.publications = new ArrayList<>();
        int numPublications = Integer.parseInt(br.readLine());

        for (int i = 0; i < numPublications; i++) {
            String type = br.readLine();
            if ("Book".equals(type)) {
                this.addPublication(new Publication(br));
            } else if ("Video".equals(type)) {
                this.addPublication(new Video(br));
            }
        }
    }

    /**
     * Saves the library data to a BufferedWriter.
     *
     * @param bw BufferedWriter to save data to
     * @throws IOException if there is an error writing the data
     * @since 1.0
     */
    public void save(BufferedWriter bw) throws IOException {
        bw.write(this.name);
        bw.newLine();
        bw.write(Integer.toString(this.publications.size()));
        bw.newLine();

        for (Publication publication : this.publications) {
            if (publication instanceof Video) {
                bw.write("Video");
            } else if (publication instanceof Publication) {
                bw.write("Book");
            }
            bw.newLine();
            publication.save(bw);
        }
    }

    /**
     * Adds a publication to this library instance.
     *
     * @param publication the publication to add to the library
     * @since 1.0
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    /**
     * Checks out a publication from this library instance.
     *
     * The due date will be set to 2 weeks from the current date.
     *
     * @param publicationIndex the index as shown by toString()
     * @param patron identification of the borrower
     * @since 1.0
     */
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch (Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex
                    + ": " + e.getMessage() + "\n");
        }
    }

    /**
     * Checks in a publication from this library instance.
     *
     * @param publicationIndex the index as shown by toString()
     * @since 1.1
     */
    public void checkIn(int publicationIndex) {
        try {
            publications.get(publicationIndex).checkIn();
        } catch (Exception e) {
            System.err.println("\nUnable to check in publication #" + publicationIndex
                    + ": " + e.getMessage() + "\n");
        }
    }

    /**
     * Lists all publications in this library instance.
     *
     * The index shown in the resulting String may be used
     * to check out a publication using the checkOut() method.
     *
     * @returns the string representation of all library publications
     * @since 1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for (int i = 0; i < publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
}

