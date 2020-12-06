package Exceptions;

public class CartQuantityException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartQuantityException(){
		super("Quantity over available");
	}
}
