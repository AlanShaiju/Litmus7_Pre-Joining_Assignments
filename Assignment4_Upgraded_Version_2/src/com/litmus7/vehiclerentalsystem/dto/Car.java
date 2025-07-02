package com.litmus7.vehiclerentalsystem.dto;

/**
 * This file contains the base class 'Car', it defines the basic details
 * associated with any car, and it extends the superclass 'Vehicle'.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-02
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

	public int getNumberOfDoors() {
		// Returns the number of doors associated with the car object
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		// sets the value for the {@param numberOfDoors} associated with a car object
		this.numberOfDoors = numberOfDoors;
	}

	public boolean isAutomatic() {
		// returns the boolean value for is the car object is an automatic or not
		return isAutomatic;
	}

	public void setAutomatic(boolean isAutomatic) {
		// sets the boolean value for if the car object is an automatic or not
		this.isAutomatic = isAutomatic;
	}

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

	public boolean equals(Object obj) {
		// checks if objects are equal
		if (this == obj)
			return true;
		Car that = (Car) obj;
		return this.getBrand().equalsIgnoreCase(that.getBrand()) && this.getModel().equalsIgnoreCase(that.getModel());
	}

	public String toString() {
		// This method returns the corresponding details associated with a car object.
		return "Brand:" + getBrand() + " | Model:" + getModel() + " | Rental Price Per Day:" + getRentalPricePerDay()
				+ " | Number of Doors:" + numberOfDoors + " | isAutomatic(true/false):" + isAutomatic;
	}
}