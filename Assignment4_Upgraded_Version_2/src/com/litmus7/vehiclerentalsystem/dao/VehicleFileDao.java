package com.litmus7.vehiclerentalsystem.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.exceptions.VehicleFileNotFoundException;

/**
 * This file detail the different methods through which data is accessed. Data
 * is read from the file and stored onto objects of type "ArrayList<Car>" and
 * "ArrayList<Bike>". The lists that are created are used to store data. The
 * created lists hold the data and the data is sent from the base layer
 * (VehicleFileDao) to the upper layers in the application.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class VehicleFileDao {

	/**
	 * This class is used to create a data access object, which can be used to deal
	 * with manipulation of data. It lists two parameters:
	 * 
	 * @param listOfCars  : it stores the objects of type "Car" that is read from
	 *                    the file. Further data of type "Car" is also added onto
	 *                    this parameter.
	 * @param listOfBikes : it stores the object of type "Bike" that is read from
	 *                    the file. Further data of type "Bike" is added onto this
	 *                    parameter.
	 */

	List<Car> listOfCars = new ArrayList<Car>();
	List<Bike> listOfBikes = new ArrayList<Bike>();

	public String loadVehiclesFromFile(String filePath) throws VehicleFileNotFoundException {
		/**
		 * This method reads the data from a file and stores the data into the
		 * parameters listOfCars and listOfBikes. Data is read and stored accordingly.
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].trim().contentEquals("Car")) {
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
						listOfCars.add(car);
					} else {
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
						listOfBikes.add(bike);
					}
				}
			}
			// If the file is read then the message "File Read Successfully" is passed onto
			// the upper layers.
			return "File Read Successfully";
		} catch (IOException e) {
			// If the file was not found then we throw the custom exception
			// "VehicleNotFoundException".
			throw new VehicleFileNotFoundException("File Was Not Found" + e);
		}
	}

	public List<Car> getListOfCars() {
		// This method returns the parameter "listOfCars"
		return listOfCars;
	}

	public List<Bike> getListOfBikes() {
		// This method returns the parameter "listOfBikes"
		return listOfBikes;
	}

	public String addBike(Bike bike) {
		// This method adds a new bike object to the existing list.
		listOfBikes.add(bike);
		return "Bike Added";

	}

	public String addCar(Car car) {
		// This method adds a new car object into the existing list.
		listOfCars.add(car);
		return "Car Added";
	}
}
