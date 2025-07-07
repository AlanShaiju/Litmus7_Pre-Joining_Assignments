package com.litmus7.retail.exception;

/**
 * In this file we define the exception that occurs when the data is already
 * present in the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class DuplicateDataException extends Exception {
	public DuplicateDataException(String string) {
		super(string);

	}

	public DuplicateDataException(String string, Throwable cause) {
		super(string, cause);
	}
}
