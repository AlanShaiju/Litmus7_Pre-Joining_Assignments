package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when the password does not
 * match the basic requirements.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class WeakPasswordException extends Exception {
	public WeakPasswordException(String string) {
		super(string);

	}

	public WeakPasswordException(String string, Throwable cause) {
		super(string, cause);
	}
}
