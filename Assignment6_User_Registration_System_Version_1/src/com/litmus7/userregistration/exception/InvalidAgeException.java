package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when the age entered does
 * not satisfy the age requirements.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class InvalidAgeException extends Exception {
	public InvalidAgeException(String string) {
		super(string);

	}

	public InvalidAgeException(String string, Throwable cause) {
		super(string, cause);
	}
}
