package com.litmus7.vehiclerentalsystem.servicelayer;

import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Bike;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This file contains the base class 'VehicleService', it details all the
 * actions/services that can be associated with a vehicle rental service. It
 * contains methods to manage the vehicle rental system and provides different
 * details associated with the vehicle rental system.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-24
 */

public class VehicleService {

	/**
	 * This class contains the different methods for the vehicle rental system.
	 * 
	 * @param carList  : is of type ArrayList containing objects of type "Car".
	 * @param bikeList : is of type ArrayList containing objects of type "Bike".
	 */
	List<Car> carList = new ArrayList<Car>();
	List<Bike> bikeList = new ArrayList<Bike>();

	public void loadVehiclesFromFile(String filePath) {
		/**
		 * This method reads the data from a file and stores the data into the
		 * parameters carList and bikeList. Data is read and stored accordingly.
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].trim().contentEquals("Car")) {
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
						carList.add(car);
					} else {
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
						bikeList.add(bike);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading course file: " + e.getMessage());
		}
	}

	public void getAllCarDetails() {
		/**
		 * Displays all the details associated with the objects of type "Car" stored in
		 * "carList".
		 */
		for (Car car : carList) {
			car.displayDetails();
			System.out.println();
		}
	}

	public void getAllBikeDetails() {
		/**
		 * Displays all the details associated with the objects of type "Bike" stored in
		 * "bikeList".
		 */
		for (Bike bike : bikeList) {
			bike.displayDetails();
			System.out.println();
		}
	}

	public void getAllVehicleDetails() {
		/**
		 * Displays all the details associated with the objects of type "Car" and "Bike"
		 * stored in "carList" and "bikeList" respectively.
		 */
		System.out.println("--- All Vehicle Details ---");
		getAllCarDetails();
		getAllBikeDetails();
	}

	public void getCarList() {
		/**
		 * Displays all the car brand and model associated with the objects of type
		 * "Car" stored in "carList".
		 */
		for (Car car : carList) {
			System.out.println(car.getBrand() + " : " + car.getModel());
		}
	}

	public void getBikeList() {
		/**
		 * Displays all the bike brand and model associated with the objects of type
		 * "Bike" stored in "bikeList".
		 */
		for (Bike bike : bikeList) {
			System.out.println(bike.getBrand() + " : " + bike.getModel());
		}
	}

	public void getVehicleList() {
		/**
		 * Displays all the car brand and model associated with the objects of type
		 * "Car" and "Bike" stored in "carList" and "bikeList" respectively.
		 */
		getCarList();
		getBikeList();
	}

	public void addCar() {
		/**
		 * Adds an additional car object into the carList.
		 */
		Scanner scanner = new Scanner(System.in);
		Car car = new Car();
		car.inputDetails();
		carList.add(car);

	}

	public void addBike() {
		/**
		 * Adds an additional bike object into the bikeList.
		 */
		Scanner scanner = new Scanner(System.in);
		Bike bike = new Bike();
		bike.inputDetails();
		bikeList.add(bike);

	}

	public double getRentalPriceCar() {
		/**
		 * Retrieves the rental price per day for all the available cars.
		 */
		double price = 0.0;
		for (Car car : carList) {
			price += car.getRentalPricePerDay();

		}
		return price;
	}

	public double getRentalPriceBike() {
		/**
		 * Retrieves the rental price per day for all the available bikes.
		 */
		double price = 0.0;
		for (Bike bike : bikeList) {
			price += bike.getRentalPricePerDay();
		}
		return price;
	}

	public double getRentalPriceVehicles() {
		/**
		 * Retrieves the rental price per day for all the available vehicles.
		 */
		return getRentalPriceCar() + getRentalPriceBike();
	}

}
