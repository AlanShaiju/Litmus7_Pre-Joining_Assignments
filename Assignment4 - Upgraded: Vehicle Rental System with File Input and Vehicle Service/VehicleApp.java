package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.servicelayer.VehicleService;

/**
 * We create an object of type "VehicleService" to simulate the different
 * functionalities of a vehicle rental system. The different cars and bikes are
 * listed along with the total rental price associated with all cars, all bikes
 * , and both bikes and cars together.
 * 
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-24
 */

public class VehicleApp {
	public static void main(String args[]) {
		VehicleService service = new VehicleService();
		service.loadVehiclesFromFile("vehicles.txt");
		System.out.println("--- Car List ---");
		service.getCarList();
		System.out.println();
		System.out.println("--- Bike List ---");
		service.getBikeList();
		System.out.println();
		System.out.println("--- Vehicle List ---");
		service.getVehicleList();
		System.out.println();
		System.out.println("Rental Price for cars:" + service.getRentalPriceCar());
		System.out.println("Rental Price for bikes:" + service.getRentalPriceBike());
		System.out.println("Rental Pricce for all vehicles:" + service.getRentalPriceVehicles());
		System.out.println();
		System.out.println("--- All Car Details ---");
		service.getAllCarDetails();
		System.out.println();
		System.out.println("--- All Bike Details ---");
		service.getAllBikeDetails();
		System.out.println();
		service.getAllVehicleDetails();
		service.addCar();
		service.addBike();
		System.out.println("--- Car List ---");
		service.getCarList();
		System.out.println();
		System.out.println("--- Bike List ---");
		service.getBikeList();
		System.out.println();
		System.out.println("--- Vehicle List ---");
		service.getVehicleList();
		System.out.println();
		System.out.println("Rental Price for cars:" + service.getRentalPriceCar());
		System.out.println("Rental Price for bikes:" + service.getRentalPriceBike());
		System.out.println("Rental Pricce for all vehicles:" + service.getRentalPriceVehicles());
		System.out.println();

	}
}
