package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * This file contains the base class 'Car', it defines the basic details
 * associated with any car, and it extends the superclass 'Vehicle'.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-20
 */

public class Car extends Vehicle {
	/**
	 * The class defines basic details associated with a car. It has parameters
	 * numberOfDoors and isAutomatic.
	 * 
	 * @param numberOfDoors : defines the number of doors in the car
	 * @param isAutomatic   : defines if the car is an automatic or not
	 */

	private int numberOfDoors;
	private boolean isAutomatic;

	public Car() {
		/**
		 * The constructor calls the super class constructor to set the brand, model,
		 * and rentalPricePerDay to default values. Sets the parameters associated with
		 * the class Car to default values.
		 */
		super();
		numberOfDoors = 4;
		isAutomatic = true;
	}

	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		/**
		 * The constructor calls the super class constructor to set the brand, model,
		 * and rentalPricePerDay values. The constructor also sets the value of the
		 * numberOfDoors and isAutomatic to values that are passed into the constructor.
		 */
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	public void inputDetails() {
		/**
		 * Calls the super class method to retrieve the basic details from the user.
		 * Initializes the scanner class to retrieve the details from the user. Stores
		 * the values into the parameters associated with the object.
		 */
		System.out.println("--- Enter Car Details ---");
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of doors: ");
		numberOfDoors = scanner.nextInt();
		System.out.print("Is it automatic (true/false)?: ");
		isAutomatic = scanner.nextBoolean();
	}

	public void displayDetails() {
		/**
		 * Displays the basic details associated with the vehicle by calling the method
		 * in the super class. Displays the remaining details associated with the Car
		 * class.
		 */
		super.displayDetails();
		System.out.print(" | Number of doors: " + numberOfDoors);
		System.out.print(" | Automatic: " + isAutomatic);
	}
}