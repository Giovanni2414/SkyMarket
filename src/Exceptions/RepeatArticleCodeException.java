package Exceptions;

public class RepeatArticleCodeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatArticleCodeException() {
		super("The code of article already exist");
	}

}
