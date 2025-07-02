package com.litmus7.vehiclerentalsystem.client;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Response;

import java.util.List;
import java.util.Scanner;

/**
 * We create an object of type "VehicleController" to simulate the different
 * functionalities of a vehicle rental system. We create an object of type
 * "Response" to store the different type of responses that we get based on the
 * client request being executed successfully or it being a failure.
 * 
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-02
 */
public class Client {
	// We set the value for SUCCESS_CODE so that we can compare it later when we
	// execute certain functionalities to check if the execution resulted in a
	// success or failure.
	private static int SUCCESS_CODE = 200;

	public static void main(String args[]) {
		/**
		 * We create parameters listOfCars and listOfBikes to store data that is
		 * retrieved from the file. The data corresponding to cars is stored in
		 * listOfCars and the data corresponding to bikes is stored in the listOfBikes.
		 * We create an object of type "Response" to deal with the different scenarios
		 * corresponding to a success or failure.
		 */
		Scanner scanner = new Scanner(System.in);
		List<Car> listOfCars;
		List<Bike> listOfBikes;
		VehicleController controller = new VehicleController();
		Response status = new Response();
		// We check if we can access the file.
		status = controller.loadVehiclesFromFile("vehicles.txt");
		// If we access the file then we perform the next set of processes else we
		// display the error.
		if (status.getStatus_code() == SUCCESS_CODE) {
			status = controller.getListOfCars();
			listOfCars = (List<Car>) status.getData();
			status = controller.getListOfBikes();
			listOfBikes = (List<Bike>) status.getData();

			System.out.println("--- Car List ---");
			for (Car car : listOfCars)
				System.out.println(car.getBrand() + " | " + car.getModel());
			System.out.println();
			System.out.println("--- Bike List ---");
			for (Bike bike : listOfBikes)
				System.out.println(bike.getBrand() + " | " + bike.getModel());
			System.out.println();
			System.out.println("--- Vehicle List ---");
			for (Car car : listOfCars)
				System.out.println(car.getBrand() + " | " + car.getModel());
			for (Bike bike : listOfBikes)
				System.out.println(bike.getBrand() + " | " + bike.getModel());
			System.out.println();
			status = controller.getRentalPriceCar();
			System.out.println("Rental Price for cars:" + status.getData());
			status = controller.getRentalPriceBike();
			System.out.println("Rental Price for bikes:" + status.getData());
			status = controller.getRentalPriceVehicles();
			System.out.println("Rental Price for all vehicles:" + status.getData());
			System.out.println();
			// Adding Car
			System.out.print("Enter car brand:");
			String brand = scanner.nextLine();
			System.out.print("Enter car model:");
			String model = scanner.nextLine();
			System.out.print("Enter rental price per day for car:");
			double rentalPricePerDay = scanner.nextDouble();
			System.out.print("Enter number of doors for car:");
			int numberOfDoors = scanner.nextInt();
			System.out.print("Enterif the car is an automatic (true/false):");
			boolean isAutomatic = scanner.nextBoolean();
			scanner.nextLine();
			// We try to add the car into the list of cars present in the service dao layer.
			status = controller.addCar(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
			// If its a success then we proceed to add the bike object.
			if (status.getStatus_code() == SUCCESS_CODE) {
				System.out.println(status.getMessage());
				// Adding Bike
				System.out.print("Enter bike brand:");
				brand = scanner.nextLine();
				System.out.print("Enter bike model:");
				model = scanner.nextLine();
				System.out.print("Enter rental price per day for bike:");
				rentalPricePerDay = scanner.nextDouble();
				System.out.print("Enter if the bike has gears (true/false):");
				boolean hasGears = scanner.nextBoolean();
				System.out.print("Enter engine capacity for bike (cc):");
				int engineCapacity = scanner.nextInt();
				status = controller.addBike(brand, model, rentalPricePerDay, hasGears, engineCapacity);
				// We try to add the bike object, if its a success then we add the bike else we
				// display the failure.
				if (status.getStatus_code() == SUCCESS_CODE) {
					System.out.println(status.getMessage());

					status = controller.getListOfCars();
					listOfCars = (List<Car>) status.getData();
					status = controller.getListOfBikes();
					listOfBikes = (List<Bike>) status.getData();

					System.out.println("--- Car List ---");
					for (Car car : listOfCars)
						System.out.println(car.getBrand() + " | " + car.getModel());
					System.out.println();
					System.out.println("--- Bike List ---");
					for (Bike bike : listOfBikes)
						System.out.println(bike.getBrand() + " | " + bike.getModel());
					System.out.println();
					System.out.println("--- Vehicle List ---");
					for (Car car : listOfCars)
						System.out.println(car.getBrand() + " | " + car.getModel());
					for (Bike bike : listOfBikes)
						System.out.println(bike.getBrand() + " | " + bike.getModel());
					System.out.println();
					status = controller.getRentalPriceCar();
					System.out.println("Rental Price for cars:" + status.getData());
					status = controller.getRentalPriceBike();
					System.out.println("Rental Price for bikes:" + status.getData());
					status = controller.getRentalPriceVehicles();
					System.out.println("Rental Price for all vehicles:" + status.getData());
					System.out.println();
				} else {
					System.out.println(status.getE() + " | " + status.getMessage());
				}
			} else {
				System.out.println(status.getE() + " | " + status.getMessage());
			}
		} else {
			System.out.println(status.getE() + " | " + status.getMessage());
		}

		scanner.close();
	}
}
