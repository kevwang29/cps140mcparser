package exceptions;

/**
 * Exception for parsing invalid token
 * 
 * @author Kevin Wang
 *
 */
public class InvalidTokenException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenException(String message){
		super(message);
	}
}
