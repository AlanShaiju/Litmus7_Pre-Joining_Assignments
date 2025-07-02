package com.litmus7.vehiclerentalsystem.exceptions;

/**
 * This class file defines an exception that occurs when an object of type "Car"
 * cannot be added to the list of cars.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class CannotAddCarException extends Exception {
	public CannotAddCarException(String string) {
		super(string);
	}

	public CannotAddCarException(String string, Throwable cause) {
		super(string, cause);
	}
}
