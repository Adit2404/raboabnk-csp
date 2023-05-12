/**
 * 
 */
package com.rabobank.csp.exception;

/**
 * Class for Validation Exception
 * @author adityabhargava
 *
 */
public class ValidationException extends RuntimeException {


	private static final long serialVersionUID = 1458857567630614758L;

	public ValidationException(String message) {
		super(message);
	}
}
