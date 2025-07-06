package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when no name is given by the
 * user.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class EmptyNameException extends Exception {
	public EmptyNameException(String string) {
		super(string);

	}

	public EmptyNameException(String string, Throwable cause) {
		super(string, cause);
	}
}
