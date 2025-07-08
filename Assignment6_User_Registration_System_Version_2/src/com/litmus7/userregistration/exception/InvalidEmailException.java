package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when the email that is
 * entered is of the wrong format.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class InvalidEmailException extends Exception {
	public InvalidEmailException(String string) {
		super(string);

	}

	public InvalidEmailException(String string, Throwable cause) {
		super(string, cause);
	}
}
