
/**
 * Exception for hasSpecialChar.
 * Used if password has no special character.
 * @author Justin Hixson
 *
 */
public class NoSpecialCharacterException extends Exception {

	private static String message = "The password must contain at least one special character";

	public NoSpecialCharacterException() {
		super(message);
	}

	public String getMessage() {
		return message;

	}
}