package com.litmus7.vehiclerentalsystem.exceptions;

/**
 * This class file defines an exception that occurs when a data does not match
 * the required data type.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-02
 */
public class InconsistentDataErrorException extends Exception {
	public InconsistentDataErrorException(String string) {
		super(string);
	}

	public InconsistentDataErrorException(String string, Throwable cause) {
		super(string, cause);
	}
}
