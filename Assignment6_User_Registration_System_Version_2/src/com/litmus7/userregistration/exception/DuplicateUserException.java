package com.litmus7.userregistration.exception;

/**
 * In this file we define the exception that occurs when we the user trying to
 * be added already exists.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */

public class DuplicateUserException extends Exception {

	public DuplicateUserException(String string) {
		super(string);

	}

	public DuplicateUserException(String string, Throwable cause) {
		super(string, cause);
	}
}
