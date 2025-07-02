package com.litmus7.vehiclerentalsystem.service;

import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.exceptions.CannotAddBikeException;
import com.litmus7.vehiclerentalsystem.exceptions.CannotAddCarException;
import com.litmus7.vehiclerentalsystem.exceptions.InconsistentDataErrorException;
import com.litmus7.vehiclerentalsystem.exceptions.VehicleFileNotFoundException;
import com.litmus7.vehiclerentalsystem.dao.VehicleFileDao;
import com.litmus7.vehiclerentalsystem.dto.Bike;
import java.util.List;

/**
 * This file contains the base class 'VehicleService', it details all the
 * business logic that can be associated with a vehicle rental service. It
 * contains methods to manage the vehicle rental system and provides access to
 * the different details via the "VehicleFileDao" object.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-02
 */

public class VehicleService {

	/**
	 * This class contains the different methods that contain the logic for the
	 * vehicle rental system.
	 * 
	 */

	private VehicleFileDao dao = new VehicleFileDao();

	public String loadVehiclesFromFile(String filePath)
			throws VehicleFileNotFoundException, InconsistentDataErrorException {
		/**
		 * This method calls the method "loadVehiclesFromFile" of the "VehicleFileDao"
		 * object.
		 */
		return dao.loadVehiclesFromFile(filePath);

	}

	public List<Car> getListOfCars() {
		/**
		 * This method calls the method "getListOfCars" of the "VehicleFileDao" object.
		 */
		return dao.getListOfCars();
	}

	public List<Bike> getListOfBikes() {
		/**
		 * This method calls the method "getListOfBikes" of the "VehicleFileDao" object.
		 */
		return dao.getListOfBikes();
	}

	public String addCar(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic)
			throws CannotAddCarException {
		/**
		 * This method creates a new car object based on the values received and calls
		 * the method "addCar" of the "VehicleFileDao" object after the initial check is
		 * complete.
		 */
		Car car = new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
		if (dao.getListOfCars().contains(car)) {
			throw new CannotAddCarException("Car already exists");
		}
		return dao.addCar(car);

	}

	public String addBike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity)
			throws CannotAddBikeException {
		/**
		 * This method creates a new bike object based on the values received and calls
		 * the method "addBike" of the "VehicleFileDao" object after the initial check
		 * is complete.
		 */
		Bike bike = new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity);
		if (dao.getListOfBikes().contains(bike)) {
			throw new CannotAddBikeException("Bike already exists");
		}
		return dao.addBike(bike);

	}

	public double getRentalPriceCar() {
		/**
		 * This method calls the existing method "getListOfCars" and computes the rental
		 * price for all the cars using the getter method "getRentalPricePerDay" for the
		 * car object.
		 */
		double price = 0.0;
		for (Car car : getListOfCars()) {
			price += car.getRentalPricePerDay();

		}
		return price;
	}

	public double getRentalPriceBike() {
		/**
		 * This method calls the existing method "getListOfBikes" and computes the
		 * rental price for all the bikes using the getter method "getRentalPricePerDay"
		 * for the bike object.
		 */
		double price = 0.0;
		for (Bike bike : getListOfBikes()) {
			price += bike.getRentalPricePerDay();
		}
		return price;
	}

	public double getRentalPriceVehicles() {
		/**
		 * This method calls the existing method "getRentalPriceCar" and
		 * "getRentalPriceBike", and computes the rental price for all the vehicles.
		 */
		return getRentalPriceCar() + getRentalPriceBike();
	}

}
