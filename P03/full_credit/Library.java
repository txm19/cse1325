import java.util.ArrayList;
	public class Library 
	{
		private String name;
		private ArrayList<Publication> publications;
		
		public Library(String name) 
		{
        		this.name = name;
        		this.publications = new ArrayList<>();
    		}
    		
    		public void addPublication(Publication publication) 
    		{
        		publications.add(publication);
    		}
    		
  
    		public void checkout(int publicationIndex, String patron) 
    		{
        		if (publicationIndex < 0 || publicationIndex >= publications.size()) 
        		{
            			throw new IndexOutOfBoundsException("Invalid publication index");
        		}
        		Publication publication = publications.get(publicationIndex);
        		publication.checkout(patron);
    		}

    		@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("\n\n");
        for (int i = 0; i < publications.size(); i++) {
            builder.append(publications.get(i)).append("\n"); // Add a new line after each publication
        }
        return builder.toString();
    }
}
