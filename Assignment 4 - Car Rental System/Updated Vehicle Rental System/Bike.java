package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * This file contains the base class 'Bike', it defines the basic details
 * associated with any bike, and it extends the superclass 'Vehicle'.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-20
 */

public class Bike extends Vehicle {
	/**
	 * The class defines basic details associated with a bike. It has parameters
	 * hasGear and engineCapacity.
	 * 
	 * @param hasGear        : defines if the bike has gears or not
	 * @param engineCapacity : defines the engine capacity for the bike
	 */
	private boolean hasGear;
	private int engineCapacity;

	public Bike() {
		/**
		 * The constructor sets the brand, model, and rentalPricePerDay to default
		 * values. Sets the parameters associated with the class Bike to default values.
		 */
		super();
		hasGear = true;
		engineCapacity = 100;
	}

	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		/**
		 * The constructor calls the super class constructor to set the brand, model,
		 * and rentalPricePerDay values. The constructor also sets the value of the
		 * hasGear and engineCapacity to values that are passed into the constructor.
		 */
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	public void inputDetails() {
		/**
		 * Calls the super class method to retrieve the basic details from the user.
		 * Initializes the scanner class to retrieve the details from the user. Stores
		 * the values into the parameters associated with the object.
		 */
		System.out.println("--- Enter Bike Details ---");
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Does it have gears (true/false)?: ");
		hasGear = scanner.nextBoolean();
		System.out.print("Enter engine capacity (cc): ");
		engineCapacity = scanner.nextInt();
	}

	public void displayDetails() {
		/**
		 * Displays the basic details associated with the vehicle by calling the method
		 * in the super class. Displays the remaining details associated with the Bike
		 * class.
		 */
		System.out.println("--- Displaying Bike Details ---");
		super.displayDetails();
		System.out.println("Has Gear: " + hasGear);
		System.out.println("Engine Capacity: " + engineCapacity + " cc");
	}

}
