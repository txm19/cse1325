package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;

/**
 * A library video that can be checked out by a patron.
 *
 * @author Tista Manandhar
 * @version 1.0
 * @since 1.0
 * @license.agreement Gnu General Public License 3.0
 */
public class Video {
    public class InvalidRuntimeException extends ArithmeticException {
        public InvalidRuntimeException() {
            super();
        }

        public InvalidRuntimeException(String message) {
            super(message);
        }

        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has an invalid runtime " + runtime + " minutes.");
        }
    }

    private Duration runtime;
    private String title;
    private String author;
    private int copyright;

    public Video(String title, String author, int copyright, int runtime) {
        if (runtime < 1) throw new InvalidRuntimeException(title, runtime);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        this.runtime = Duration.ofMinutes(runtime);
    }

    public Video(BufferedReader br) throws IOException {
        this.title = br.readLine();
        this.author = br.readLine();
        this.copyright = Integer.parseInt(br.readLine());
        int runtime = Integer.parseInt(br.readLine());
        if (runtime < 1) throw new InvalidRuntimeException(title, runtime);
        this.runtime = Duration.ofMinutes(runtime);
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(title);
        bw.newLine();
        bw.write(author);
        bw.newLine();
        bw.write(Integer.toString(copyright));
        bw.newLine();
        bw.write(Integer.toString((int) runtime.toMinutes()));
        bw.newLine();
    }

    @Override
    public String toString() {
        return "Video: " + title + ", runtime " + runtime.toMinutes() + " minutes";
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopyright() {
        return copyright;
    }
}

