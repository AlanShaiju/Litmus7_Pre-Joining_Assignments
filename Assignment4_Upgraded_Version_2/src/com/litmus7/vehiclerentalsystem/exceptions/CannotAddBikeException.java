package com.litmus7.vehiclerentalsystem.exceptions;

/**
 * This class file defines an exception that occurs when an object of type
 * "Bike" cannot be added to the list of bikes.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class CannotAddBikeException extends Exception {
	public CannotAddBikeException(String string) {
		super(string);
	}
}
