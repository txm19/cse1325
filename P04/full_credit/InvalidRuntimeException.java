package library;

public class InvalidRuntimeException extends ArithmeticException 
{
    public InvalidRuntimeException() 
    {
        super();
    }

    public InvalidRuntimeException(String message) 
    {
        super(message);
    }

    public InvalidRuntimeException(String title, int runtime) 
    {
        super(title + " has an invalid runtime: " + runtime + " minutes");
    }
}

package library;

/**
 * Custom exception class for handling invalid runtime values in videos.
 */
public class InvalidRunTimeException extends ArithmeticException {
    /**
     * Constructs a new InvalidRunTimeException with no detail message.
     */
    public InvalidRunTimeException() {
        super();
    }

    /**
     * Constructs a new InvalidRunTimeException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidRunTimeException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidRunTimeException with a message indicating the invalid runtime value.
     *
     * @param title   The title of the video.
     * @param runtime The invalid runtime value.
     */
    public InvalidRunTimeException(String title, int runtime) {
        super(title + " has an invalid runtime: " + runtime + " minutes");
    }
}

