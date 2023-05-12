/**
 * 
 */
package com.rabobank.csp.exception;

/**
 * Class for Invalid CSV File Content
 * @author adityabhargava
 *
 */
public class InvalidCSVException extends RuntimeException {


	private static final long serialVersionUID = 1458857567630614758L;

	public InvalidCSVException(String message) {
		super(message);
	}
}
