package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class LibraryManager {
    public LibraryManager(Library library) {
        this.library = library;
    }
    public void listPublications() {
        System.out.println("=================\nLibrary Catalogue\n=================\n");
        System.out.println(library);
    }
    public void addPublication() {
        String title = console.readLine("Title: ");   if(title.isEmpty()) return;
        String author = console.readLine("Author: "); if(author.isEmpty()) return;
        int copyright = Integer.parseInt(console.readLine("Copyright: "));
        String runtime = console.readLine("Runtime (Enter if not video): ");
        Publication p = null;
        if(runtime.isEmpty()) {
            p = new Publication(title, author, copyright);
        } else {
            p = new Video(title, author, copyright, Integer.parseInt(runtime));
        }
        library.addPublication(p);
    }
    public void openLibrary(String filename) {
        try {
        	 BufferedReader br = new BufferedReader(new FileReader(filename));
        	 library.clear();
        	 String line;
        	 while ((line = br.readLine()) != null)
        	 {
        	 	String[] parts = line.split(", ");
        	 	  if (parts.length == 4) 
        	 	  {
        	 	  String title = parts[0];
                    	  String author = parts[1];
                   	  int copyright = Integer.parseInt(parts[2]);
                    	  library.addPublication(new Publication(title, author, copyright));
                	} else if (parts.length == 5) 
                	{
                		String title = parts[0];
                    String author = parts[1];
                    int copyright = Integer.parseInt(parts[2]);
                    int runtime = Integer.parseInt(parts[3]);
                     library.addPublication(new Video(title, author, copyright, runtime));
                }
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error opening the library file: " + e.getMessage());
        }
    }

    public void saveLibrary(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            List<Publication> publications = library.getPublications();
            for (Publication publication : publications) {
                String publicationData = publication.toString();
                fw.write(publicationData);
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            System.err.println("Error saving the library file: " + e.getMessage());
        }
    }

    public void checkOutPublication() {
        System.out.println(library);
        int index = Integer.parseInt(console.readLine("Selection: "));
        String patron = console.readLine("Patron: ");
        library.checkOut(index, patron);
    }
    public void checkInPublication() {
        System.out.println(library);
        int index = Integer.parseInt(console.readLine("Selection: "));
        library.checkIn(index);
    }

    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager(new Library(name));
        while(true) {
            try {
                System.out.println(menu);
                int selection = Integer.parseInt(console.readLine("Selection: "));
                System.out.println();
                switch(selection) {
                    case -1 -> lm.testData();
                    case  0 -> System.exit(0);
                    case  1 -> lm.listPublications();
                    case  2 -> lm.addPublication();
                    case  3 -> lm.checkOutPublication();
                    case  4 -> lm.checkInPublication();
                    default -> throw new RuntimeException("Invalid: " + selection);
                }
            } catch (Exception e) {
                System.err.println("#### Error - " + e.getMessage());
            }
        }
    }

    private static Console console = System.console();
    private static final String name = "The Library at Alexandria (Texas)";
    private static final String menu = "\n\n=========\nMain Menu\n=========\n\n" + name + "\n\n"
        + "0) Exit\n1) List\n2) Add\n3) Check out\n4) Check in\n\n";

    private Library library;
    
    public void testData() {
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));
    }
}
