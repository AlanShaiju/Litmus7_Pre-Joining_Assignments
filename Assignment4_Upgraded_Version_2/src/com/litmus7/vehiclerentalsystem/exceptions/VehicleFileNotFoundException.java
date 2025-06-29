package com.litmus7.vehiclerentalsystem.exceptions;

import java.io.IOException;

/**
 * This class file defines an exception that occurs when the file associated
 * with vehicle details is not found
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class VehicleFileNotFoundException extends IOException {

	public VehicleFileNotFoundException(String string) {
		super(string);
	}
}
