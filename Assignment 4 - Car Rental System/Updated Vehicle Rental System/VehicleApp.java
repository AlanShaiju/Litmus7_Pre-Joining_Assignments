package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;

/**
 * In this file we create objects of type Vehicle,Car,Bike. We use methods
 * present of the class to read and display the details. We create different
 * objects and test if the methods that are inherited execute successfully.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-06-20
 */
public class VehicleApp {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle("Ford", "Raptor", 1000);
		Car car1 = new Car();
		Car car2 = new Car("Audi", "R8", 3750, 2, true);
		Bike bike1 = new Bike();
		Bike bike2 = new Bike("Honda", "CB300R", 450, true, 300);
		vehicle1.displayDetails();
		vehicle2.displayDetails();
		System.out.println();
		car1.displayDetails();
		car2.displayDetails();
		bike1.displayDetails();
		bike2.displayDetails();
		System.out.println();
		car1.inputDetails();
		bike1.inputDetails();
		System.out.println();
		car1.displayDetails();
		car2.displayDetails();
		bike1.displayDetails();
		bike2.displayDetails();
	}

}
