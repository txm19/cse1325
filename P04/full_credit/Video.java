package library;

import java.time.Duration;

public class Video extends Publication{
	private Duration runtime; 

	public Video(String title, String author, int copyright, int runtime) 
	{
		super(title, author, copyright); 
		 this.runtime = Duration.ofMinutes(runtime);
		 
		 if (runtime <= 0) 
		 {
            		throw new InvalidRunTimeException(title, runtime);
        	}
    }
    @Override
    public String toString() 
    {
    	String superToString = super.toString();
    	return superToString + "\nRuntime: " + runtime.toMinutes() + " minutes";
    }
    public static class InvalidRunTimeException extends ArithmeticException 
    {
        public InvalidRunTimeException() 
        {
            super();
        }

        public InvalidRunTimeException(String message) 
        {
            super(message);
        }

        public InvalidRunTimeException(String title, int runtime) 
        {
            super(title + " has an invalid runtime: " + runtime + " minutes");
        }
    }
}

package library;

import java.time.Duration;

/**
 * Represents a video publication in the library's collection.
 */
public class Video extends Publication {
    private Duration runtime;

    /**
     * Initializes a new video publication with the given title, copyright year, and runtime.
     *
     * @param title     The title of the video.
     * @param author    The author of the video (empty for videos).
     * @param copyright The copyright year of the video.
     * @param runtime   The runtime of the video in minutes.
     * @throws InvalidRunTimeException If the runtime is invalid (less than or equal to zero).
     */
    public Video(String title, String author, int copyright, int runtime) {
        // ... Existing constructor code ...
    }

    /**
     * Generates a string representation of the video.
     *
     * @return A string containing video information.
     */
    @Override
    public String toString() {
        // ... Existing code ...
    }

    /**
     * Custom exception class for handling invalid runtime values.
     */
    public static class InvalidRunTimeException extends ArithmeticException {
        // ... Existing code ...
    }
}

	
