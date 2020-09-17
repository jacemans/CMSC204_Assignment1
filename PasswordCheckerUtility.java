import java.util.ArrayList;
/**
 * Password checker utility for PasswordMain.
 * Uses exceptions for invalid passwords.
 * @author Justin Hixson
 *
 */
public class PasswordCheckerUtility {

	/**
	 * Checks if password is valid
	 * @param password the password being checked
	 * @return true if valid password
	 * @throws LengthException password is too short
	 * @throws NoDigitException password has no digit
	 * @throws NoUpperAlphaException password has no upper case letter
	 * @throws NoLowerAlphaException password has no lower case letter
	 * @throws InvalidSequenceException password has invalid sequence of characters
	 * @throws NoSpecialCharacterException password has no special character
	 */
	public static boolean isValidPassword (String password)
			throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {

		isValidLength(password);
		hasDigit(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasSameCharInSequence(password);
		hasSpecialChar(password);

		return true;
	}

	/**
	 * Checks if password is too weak
	 * @param password the password being checked
	 * @return true if password is weak
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword (String password) throws WeakPasswordException {
		if (hasBetweenSixAndNineChars (password)) return hasBetweenSixAndNineChars (password);
		throw new WeakPasswordException();

	}

	/**
	 * Adds  invalid passwords to array list
	 * @param passwords array list of passwords
	 * @return array list of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords (ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();

		for (int i = 0 ; i < passwords.size() ; i++)
			try {
				isValidPassword(passwords.get(i));
				
			} catch (LengthException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must be at least 6 characters long");
				
			} catch (NoDigitException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must contain at least one digit");
				
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must contain at least one uppercase alphabetic character");
				
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must contain at least one lower case alphabetic character");
				
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must contain at least one special character");
				
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " -> The password must contain at least one special character");
			}

		return invalidPasswords;
	}

	/**
	 * Compares equality of two passwords
	 * @param password the first password
	 * @param passwordConfirm the second password
	 * @throws UnmatchedException if passwords do not match
	 */
	public static void comparePasswords (String password, String passwordConfirm) throws UnmatchedException{
		if (!password.equals(passwordConfirm)) throw new UnmatchedException();
	}

	/**
	 * Compares equality of two passwords
	 * @param password the first password
	 * @param passwordConfirm the second password
	 * @return if passwords match
	 */
	public static boolean comparePasswordsWithReturn (String password, String passwordConfirm) {
		if (password.equals(passwordConfirm)) return true;
		else return false;
	}

	/**
	 * Checks length of password
	 * @param password the password being checked
	 * @return true if password is at least six characters long
	 * @throws LengthException if password is too short
	 */
	public static boolean isValidLength (String password) throws LengthException {
		if (password.length() >= 6) return true;
		else throw new LengthException();
	}

	/**
	 * Checks if password has a digit
	 * @param password the password being checked
	 * @return true if password has a digit
	 * @throws NoDigitException if password has no digit
	 */
	public static boolean hasDigit (String password) throws NoDigitException {
		boolean hasDigit = false;

		for (int i = 0 ; i < password.length() ; i++) {
			if (Character.isDigit(password.charAt(i))) hasDigit = true;
		}

		if (hasDigit) return hasDigit;
		else throw new NoDigitException();
	}

	/**
	 * Checks if password has upper case letter
	 * @param password the password being checked
	 * @return true if password has upper case letter
	 * @throws NoUpperAlphaException if password has no upper case letter
	 */
	public static boolean hasUpperAlpha (String password) throws NoUpperAlphaException {
		boolean hasUpperAlpha = false;

		for (int i = 0 ; i < password.length() ; i++)
			if (Character.isUpperCase(password.charAt(i))) hasUpperAlpha = true;

		if (hasUpperAlpha) return hasUpperAlpha;
		else throw new NoUpperAlphaException();
	}

	/**
	 * Checks if password has lower case letter
	 * @param password the password being checked
	 * @return true if password has lower case letter
	 * @throws NoLowerAlphaException if password has no lower case letter
	 */
	public static boolean hasLowerAlpha (String password) throws NoLowerAlphaException {
		boolean hasLowerAlpha = false;

		for (int i = 0 ; i < password.length() ; i++)
			if (Character.isLowerCase(password.charAt(i))) hasLowerAlpha = true;

		if (hasLowerAlpha) return hasLowerAlpha;
		else throw new NoLowerAlphaException();
	}

	/**
	 * Checks the password sequence requirement
	 * @param password the password being checked
	 * @return false if password does not meet sequence requirement
	 * @throws InvalidSequenceException if password does meet sequence requirement
	 */
	public static boolean hasSameCharInSequence (String password) throws InvalidSequenceException {
		for (int i = 0 ; i < password.length() - 2 ; i++)
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2))
				throw new InvalidSequenceException();

		return false;
	}

	/**
	 * Checks if the password has a special character
	 * @param password the password being checked
	 * @return true if the password has a special character
	 * @throws NoSpecialCharacterException  if the password has no special character
	 */
	public static boolean hasSpecialChar (String password) throws NoSpecialCharacterException {
		boolean hasSpecialChar = false;

		for (int i = 0 ; i < password.length() ; i++)
			if (!Character.isLetterOrDigit(password.charAt(i))) hasSpecialChar = true;

		if (hasSpecialChar) return hasSpecialChar;
		else throw new NoSpecialCharacterException();
	}

	/**
	 * Checks if password has between six and nine characters
	 * @param password the password being checked
	 * @return if password has between six and nine characters
	 */
	public static boolean hasBetweenSixAndNineChars (String password) {
		if (password.length() >= 6 && password.length() <= 9) return true;
		else return false;
	}
}
