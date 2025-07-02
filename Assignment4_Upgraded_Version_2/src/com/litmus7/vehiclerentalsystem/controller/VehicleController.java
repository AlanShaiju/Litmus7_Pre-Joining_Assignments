package com.litmus7.vehiclerentalsystem.controller;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.exceptions.CannotAddBikeException;
import com.litmus7.vehiclerentalsystem.exceptions.CannotAddCarException;
import com.litmus7.vehiclerentalsystem.exceptions.InconsistentDataErrorException;
import com.litmus7.vehiclerentalsystem.exceptions.NoSourceFileException;
import com.litmus7.vehiclerentalsystem.exceptions.VehicleFileNotFoundException;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * We create an object of type "VehicleService" to simulate the different
 * functionalities of a vehicle rental system. It acts as the control layer to
 * perform basic set of validations before requesting data from the next layer.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-02
 */

public class VehicleController {
	/**
	 * It is used to simulate the function of the controller. It performs basic
	 * validations before proceeding further to retrieve or store data.
	 * 
	 * @param SUCCESS_CODE : It sets a definite value for a success scenario.
	 * @param FAILURE_CODE : It sets the definite value for a failure scenario.
	 * 
	 *                     This class details the different methods that can be used
	 *                     to access the data based on client requests.
	 * 
	 */

	private int SUCCESS_CODE = 200;
	private int FAILURE_CODE = 400;

	private VehicleService service = new VehicleService();

	public Response loadVehiclesFromFile(String string) {

		// This method is used to retrieve the data from a file.
		try {
			// If no file is provided then a custom exception "NoSourceFileException" is
			// thrown.
			if (string == "")
				throw new NoSourceFileException("No source file was given");
			return Response.success(SUCCESS_CODE, service.loadVehiclesFromFile(string));
		} catch (VehicleFileNotFoundException e) {
			// If the file name that was passed is incorrect or no such file exists in the
			// directory then a custom exception "VehicleFileNotFoundException" is thrown.
			return Response.failure(FAILURE_CODE, "File was not found", e);
		} catch (NoSourceFileException e) {
			// This catch block returns the response to the Exception generated if there is
			// no source file.
			return Response.failure(FAILURE_CODE, "No Source File", e);
		} catch (InconsistentDataErrorException e) {
			// Returns a response indicating the data read is incorrect and does not match
			// the required data type.
			return Response.failure(FAILURE_CODE, "Inconsistent data", e);
		}
	}

	public Response getListOfCars() {
		// This method returns the list of cars.
		return Response.success(SUCCESS_CODE, "Cars retireived", service.getListOfCars());
	}

	public Response getListOfBikes() {
		// This method returns the list of bikes.
		return Response.success(SUCCESS_CODE, "Bikes retrieved", service.getListOfBikes());
	}

	public Response getRentalPriceCar() {
		// This method returns the list of cars.
		return Response.success(SUCCESS_CODE, "Rental price of cars received", service.getRentalPriceCar());
	}

	public Response getRentalPriceBike() {
		// This method returns the rental price for all the bikes.
		return Response.success(SUCCESS_CODE, "Rental price of bikes received", service.getRentalPriceBike());
	}

	public Response getRentalPriceVehicles() {
		// This method returns the rental price for all the cars.
		return Response.success(SUCCESS_CODE, "Rental price of all vehicles received",
				service.getRentalPriceVehicles());
	}

	public Response addCar(String brand, String model, double rentalPricePerDay, int numberOfDoors,
			boolean isAutomatic) {
		// This method is used to add a car object to the existing list of cars.
		// Initial validation checks if any field is empty.
		// If no field is empty then the car is added to the list.
		// We also check if there exists a car of same model and brand.
		if (brand == "" || model == "" || rentalPricePerDay <= 0 || numberOfDoors <= 0) {
			return Response.failure(FAILURE_CODE, "Cannot add car | Incomplete Details",
					new CannotAddCarException("Incomplete Details"));
		} else {
			try {
				return Response.success(SUCCESS_CODE,
						service.addCar(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic));

			} catch (Exception e) {
				return Response.failure(FAILURE_CODE, e.getMessage(), e);
			}
		}

	}

	public Response addBike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		// This method is used to add a car object to the existing list of bikes.
		// Initial validation checks if any field is empty.
		// If no field is empty then the bike is added to the list.
		// We also check if there exists a bike of same model and car.
		if (brand == "" || model == "" | rentalPricePerDay <= 0 || engineCapacity < 0) {
			return Response.failure(FAILURE_CODE, "Cannot add bike | Incomplete Details",
					new CannotAddBikeException("Incomplete Details"));
		} else {
			try {
				return Response.success(SUCCESS_CODE,
						service.addBike(brand, model, rentalPricePerDay, hasGear, engineCapacity));
			} catch (Exception e) {
				return Response.failure(FAILURE_CODE, e.getMessage(), e);
			}

		}

	}

}
