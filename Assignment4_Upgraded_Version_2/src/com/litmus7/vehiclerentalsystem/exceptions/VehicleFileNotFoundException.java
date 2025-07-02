package com.litmus7.vehiclerentalsystem.exceptions;


/**
 * This class file defines an exception that occurs when the file associated
 * with vehicle details is not found
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class VehicleFileNotFoundException extends Exception {
	public VehicleFileNotFoundException(String string) {
		super(string);
	}

	public VehicleFileNotFoundException(String string, Throwable cause) {
		super(string, cause);
	}
}
