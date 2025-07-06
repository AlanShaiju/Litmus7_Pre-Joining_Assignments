package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when we cannot retrieve the
 * details of the user.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class CannotRetrieveUserException extends Exception {
	public CannotRetrieveUserException(String string) {
		super(string);

	}

	public CannotRetrieveUserException(String string, Throwable cause) {
		super(string, cause);
	}
}
