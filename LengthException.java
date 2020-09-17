
/**
 * Exception for isValidLength.
 * Used if password is too short.
 * @author Justin Hixson
 *
 */
public class LengthException extends Exception {

	private static String message = "The password must be at least 6 characters long";

	public LengthException() {
		super(message);
	}

	public String getMessage() {
		return message;
		
	}
}
