/**
 * This custom exception is for in-valid mail
 * if enter mail id is in-valid
 * then this exception class will call
 */
package com.skillenza.exception;

/**
 * @author Mayank
 *
 */
public class ValidMailException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ValidMailException() {
	}
	
	public ValidMailException(String exception) {
		super(exception);
	}
	
	public ValidMailException(Exception exp) {
		super(exp);
	}
}
