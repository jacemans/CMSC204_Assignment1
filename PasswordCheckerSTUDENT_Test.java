
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Justin Hixson
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String noLength = "&uwU5";
	String noUpper = "fa1lur#";
	String noLower = "4WFU|S";
	String noSequence = "WWWd0T@";
	String noDigit = "numBER^S";
	String weak = "1!Qwe";
	String successful = "Succ3$Sful";
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		passwords.add(noLength);
		passwords.add(noUpper);
		passwords.add(noLower);
		passwords.add(noSequence);
		passwords.add(noDigit);
		passwords.add(weak);
		passwords.add(successful);
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws LengthException {
				PasswordCheckerUtility.isValidLength(noLength);
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		Throwable exception = Assertions.assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws NoUpperAlphaException {
				PasswordCheckerUtility.hasUpperAlpha(noUpper);
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		Throwable exception = Assertions.assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws NoLowerAlphaException {
				PasswordCheckerUtility.hasLowerAlpha(noLower);
			}			
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws WeakPasswordException 
	 */
	@Test
	public void testIsWeakPassword()
	{
		Throwable exception = Assertions.assertThrows(WeakPasswordException.class, new Executable() {
			@Override
			public void execute() throws WeakPasswordException {
				PasswordCheckerUtility.isWeakPassword(weak);
			}			
		});
		assertEquals(null, exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		Throwable exception = Assertions.assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws InvalidSequenceException {
				PasswordCheckerUtility.hasSameCharInSequence(noSequence);
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		Throwable exception = Assertions.assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws NoDigitException {
				PasswordCheckerUtility.hasDigit(noDigit);
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * @throws NoSpecialCharacterException 
	 * @throws InvalidSequenceException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws NoDigitException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordSuccessful() throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException
	{
		assertTrue(PasswordCheckerUtility.isValidPassword(successful));
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalids;
		invalids = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(invalids.get(0), "&uwU5 -> The password must be at least 6 characters long");
		assertEquals(invalids.get(1), "fa1lur# -> The password must contain at least one uppercase alphabetic character");
		assertEquals(invalids.get(2), "4WFU|S -> The password must contain at least one lower case alphabetic character");
		assertEquals(invalids.get(3), "WWWd0T@ -> The password must contain at least one special character");
		assertEquals(invalids.get(4), "numBER^S -> The password must contain at least one digit"); 
	}
	
}