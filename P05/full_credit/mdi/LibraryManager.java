import library.Library;
import library.Publication;
import library.Video;
import java.util.Scanner;

public class LibraryManager {
    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void listPublications() {
        System.out.println("------------------");
        System.out.println("Library Catalogue");
        System.out.println("------------------");
        System.out.println(library);
    }

    public void addPublication() {
        Scanner scanner = new Scanner(System.in);
    
    System.out.println("Adding a Publication");
    
    System.out.print("Title: ");
    String title = scanner.nextLine();
    
    System.out.print("Author: ");
    String author = scanner.nextLine();
    
    System.out.print("Year of Publication: ");
    int year = Integer.parseInt(scanner.nextLine());
    
    Publication publication = new Publication(title, author, year);
    library.addPublication(publication);
    
    System.out.println("Publication added successfully.");
    }

    public void addVideo() {
        Scanner scanner = new Scanner(System.in);
    
    System.out.println("Adding a Video");
    
    System.out.print("Title: ");
    String title = scanner.nextLine();
    
    System.out.print("Director: ");
    String director = scanner.nextLine();
    
    System.out.print("Year of Publication: ");
    int year = Integer.parseInt(scanner.nextLine());
    
    System.out.print("Runtime (minutes): ");
    int runtime = Integer.parseInt(scanner.nextLine());
    
    Video video = new Video(title, director, year, runtime);
    library.addPublication(video);
    
    System.out.println("Video added successfully.");
    }

    public void checkOutPublication() 
    {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Selection: ");
    int selection = Integer.parseInt(scanner.nextLine());
    
    System.out.print("Patron: ");
    String patron = scanner.nextLine();
    
    library.checkOut(selection, patron);
   }


    public void checkInPublication() 
    {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Selection: ");
    int selection = Integer.parseInt(scanner.nextLine());
    
    library.checkIn(selection);
    }


    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Library library = new Library("The Library at Alexandria (Texas)");
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));

        LibraryManager manager = new LibraryManager(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------");
            System.out.println("Main Menu");
            System.out.println("------------------");
            System.out.println(library);

            System.out.println("0) Exit");
            System.out.println("1) List");
            System.out.println("2) Add");
            System.out.println("3) Check out");
            System.out.println("4) Check in");

            int selection = Integer.parseInt(manager.getInput("Selection: "));

            switch (selection) {
                case 0:
                    System.exit(0);
                case 1:
                    manager.listPublications();
                    break;
                case 2:
                    // Add logic for adding a publication or video
                    break;
                case 3:
                    manager.checkOutPublication();
                    break;
                case 4:
                    manager.checkInPublication();
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}

