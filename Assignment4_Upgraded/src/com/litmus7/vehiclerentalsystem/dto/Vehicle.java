package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * This file contains the base class 'Vehicle', it defines the basic details
 * associated with any vehicle.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-24
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

	public String getBrand() {
		/**
		 * Returns the brand associated with the vehicle.
		 */
		return brand;
	}

	public void setBrand(String brand) {
		/**
		 * Set's the value for brand parameter associated with the vehicle.
		 */
		this.brand = brand;
	}

	public String getModel() {
		/**
		 * Returns the model associated with the vehicle.
		 */
		return model;
	}

	public void setModel(String model) {
		/**
		 * Set's the value for model parameter associated with the vehicle.
		 */
		this.model = model;
	}

	public double getRentalPricePerDay() {
		/**
		 * Returns the rental price per day associated with the vehicle.
		 */
		return rentalPricePerDay;
	}

	public void setRentalPricePerDay(double rentalPricePerDay) {
		/**
		 * Set's the value for rentalPricePerDay parameter associated with the vehicle.
		 */
		this.rentalPricePerDay = rentalPricePerDay;
	}

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
		System.out.print("Brand: " + brand);
		System.out.print(" | Model: " + model);
		System.out.print(" | Rental Price/Day: " + rentalPricePerDay);
	}
}
