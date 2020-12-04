package Exceptions;

public class IdentificationRepeatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentificationRepeatException() {
		super("The identification already exist in the program");
	}

}
