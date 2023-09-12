import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager 
{
	public static void main(String[] args) 
	{
        	Scanner scanner = new Scanner(System.in);

        	Library library = new Library("The Library at Alexandria (Texas)");
        
        	library.addPublication(new Publication("The Cat in the Hat", "Dr. Seuss", 1957));
        	library.addPublication(new Publication("The Firm", "John Grisham", 1992));
       		library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));

		System.out.println(library);
	
		System.out.print("Which book to check out? ");
        	int publicationIndex = scanner.nextInt();
        	scanner.nextLine();
        
        	System.out.print("Who are you? ");
        	String patronName = scanner.nextLine();
        	
        	library.checkout(publicationIndex, patronName);
        	
        	System.out.println(library);
        }
}

        
        
        
      
