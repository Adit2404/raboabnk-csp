/**
 * 
 */
package com.rabobank.csp.exception;

/**
 * Exception for Invalid File given in the program.
 * @author adityabhargava
 *
 */
public class InvalidFileTypeException extends RuntimeException {


	private static final long serialVersionUID = 1458857567630614758L;

	public InvalidFileTypeException(String message) {
		super(message);
	}
}
