package com.litmus7.vehiclerentalsystem.dto;

/**
 * This file contains the base class 'Bike', it defines the basic details
 * associated with any bike, and it extends the superclass 'Vehicle'.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-02
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

	public boolean isHasGear() {
		// This method returns the value if a bike object has gears or not
		return hasGear;
	}

	public void setHasGear(boolean hasGear) {
		// This method sets the boolean value for if a bike has gears or not
		this.hasGear = hasGear;
	}

	public int getEngineCapacity() {
		// This method returns the engine capacity of an associated bike
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		// This method sets the value for the parameter engine capacity for the bike
		// object
		this.engineCapacity = engineCapacity;
	}

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

	public boolean equals(Object obj) {
		//Checks if objects are equal
		if (this == obj)
			return true;
		Bike that = (Bike) obj;
		return this.getBrand().equalsIgnoreCase(that.getBrand()) && this.getModel().equalsIgnoreCase(that.getModel());
	}

	public String toString() {
		// This method returns the details associated with the bike object, when the
		// object is called.
		return "Brand:" + getBrand() + " | Model:" + getModel() + " | Rental Price Per Day:" + getRentalPricePerDay()
				+ " | Has Gear(true/false):" + hasGear + " | Engine Capacity(cc):" + engineCapacity;
	}
}