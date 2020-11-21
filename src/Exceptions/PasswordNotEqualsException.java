package Exceptions;

public class PasswordNotEqualsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotEqualsException() {
		super("the password entered are not the same");
	}

}
