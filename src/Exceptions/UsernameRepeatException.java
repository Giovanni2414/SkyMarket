package Exceptions;

public class UsernameRepeatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameRepeatException() {
		super("The username already exist in the program");
	}

}
