package com.litmus7.rentalsystem;

import java.util.Scanner;

/**
 * This file contains the base class 'Vehicle', it defines the basic details
 * associated with any vehicle. There are subclasses 'Car', 'Bike' that inherit
 * the 'Vehicle' class.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-19
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

class Car extends Vehicle {
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
		System.out.println("--- Displaying Car Details ---");
		super.displayDetails();
		System.out.println("Number of doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic);
	}

}

class Bike extends Vehicle {
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
