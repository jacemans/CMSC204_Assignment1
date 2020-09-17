
/**
 * Exception for hasLowerAlpha.
 * Used if password has no lower case character.
 * @author Justin Hixson
 *
 */
public class NoLowerAlphaException extends Exception {

	private static String message = "The password must contain at least one lower case alphabetic character";

	public NoLowerAlphaException() {
		super(message);
	}

	public String getMessage() {
		return message;

	}
}