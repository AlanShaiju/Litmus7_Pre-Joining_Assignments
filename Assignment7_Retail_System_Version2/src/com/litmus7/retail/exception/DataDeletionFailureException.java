package com.litmus7.retail.exception;

/**
 * In this file we define the exception that occurs when a deletion operation
 * fails in the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class DataDeletionFailureException extends Exception {
	public DataDeletionFailureException(String string) {
		super(string);

	}

	public DataDeletionFailureException(String string, Throwable cause) {
		super(string, cause);
	}
}
