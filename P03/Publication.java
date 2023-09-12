import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Publication
{
	private String title;
    	private String author;
    	private int copyright;
    	private String loanedTo;
    	private LocalDate dueDate;
    	
    	public Publication(String title, String author, int copyright) 
    	{
        if (copyright < 1900 || copyright > LocalDate.now().getYear()) 
        {
            throw new IllegalArgumentException("Invalid copyright year");
        }
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        this.loanedTo = null;
        this.dueDate = null;
    }

    public void checkout(String patron) 
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void checkIn() 
    {
        this.loanedTo = null;
        this.dueDate = null;
    }

    @Override
    public String toString()
    {
    	String publicationInfo = "\"" + title + "\" by " + author + ", copyright " + copyright;
        if (loanedTo != null) {
            publicationInfo += ": loaned to " + loanedTo + " until " + dueDate;
        }
        return publicationInfo;
    }
}
        
        


    
