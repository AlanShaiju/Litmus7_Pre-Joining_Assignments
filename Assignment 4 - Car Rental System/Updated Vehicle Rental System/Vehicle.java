package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * This file contains the base class 'Vehicle', it defines the basic details
 * associated with any vehicle.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-06-20
 */

public class Vehicle {
	/**
	 * The class defines basic details associated with a vehicle. It has parameters
	 * brand, model, rental price for a day.
	 * 
	 * @param brand             : defines the brand of the vehicle
	 * @param model             : defines the model associated with the brand of
	 *                          vehicle
	 * @param rentalPricePerDay : defines the price for the vehicle for a day
	 */
	private String brand;
	private String model;
	private double rentalPricePerDay;

	public Vehicle() {
		/**
		 * The constructor sets the brand, model, and rentalPricePerDay to default
		 * values.
		 */
		brand = "Default Brand";
		model = "Default Model";
		rentalPricePerDay = 0;
	}

	public Vehicle(String brand, String model, double rentalPricePerDay) {
		/**
		 * The constructor sets the brand, model, and rentalPricePerDay to values that
		 * are passed on by the constructor.
		 */
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	public void inputDetails() {
		/**
		 * Initializes the scanner class to retrieve the details from the user. Stores
		 * the values into the parameters associated with the object.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the brand: ");
		brand = scanner.nextLine();
		System.out.print("Enter the model: ");
		model = scanner.nextLine();
		System.out.print("Enter the rental price per day: ");
		rentalPricePerDay = scanner.nextDouble();
	}

	public void displayDetails() {
		/**
		 * Displays the basic details associated with the vehicle.
		 */
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price/Day: " + rentalPricePerDay);
	}
}
