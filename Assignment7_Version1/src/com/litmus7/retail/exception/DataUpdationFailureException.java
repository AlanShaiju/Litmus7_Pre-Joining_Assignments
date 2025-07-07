package com.litmus7.retail.exception;

/**
 * In this file we define the exception that occurs when a updation operation
 * fails in the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class DataUpdationFailureException extends Exception {
	public DataUpdationFailureException(String string) {
		super(string);

	}

	public DataUpdationFailureException(String string, Throwable cause) {
		super(string, cause);
	}
}
