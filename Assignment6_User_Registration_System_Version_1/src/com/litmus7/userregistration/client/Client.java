package com.litmus7.userregistration.client;

import java.util.Scanner;

import com.litmus7.userregistration.controller.UserRegistrationController;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dto.User;

/**
 * In this file we define the client class "Client", that is used by the client
 * to communicate with the database. It has the following parameters:
 * 
 * @param username       : Holds the username of a user.
 * @param password       : Holds the password of a user.
 * @param email          : Holds the email of a user.
 * @param age            : Holds the age corresponding to a user.
 * @param serverResponse : Object used to hold the data corresponding to a
 *                       "Response" class.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */

public class Client {

	public static void main(String[] args) {
		Response serverResponse = new Response();
		UserRegistrationController controller = new UserRegistrationController();
		String username, password, email;
		int age;
		Scanner scanner = new Scanner(System.in);
		// Read user data.
		System.out.print("Enter username:");
		username = scanner.nextLine();
		System.out.print("Enter password:");
		password = scanner.nextLine();
		System.out.print("Enter email:");
		email = scanner.nextLine();
		System.out.print("Enter age:");
		age = scanner.nextInt();
		scanner.close();
		// Tries to add a user to the database.
		serverResponse = controller.addUser(username, password, email, age);
		// Checks if the operation is successful.
		if (serverResponse.getStatusCode() == 200) {
			System.out.println(serverResponse.getMessage());
			// Tries to retrieve the user data for the data that has been added.
			serverResponse = controller.getUserData();
			// Checks if the operation is successful.
			if (serverResponse.getStatusCode() == 200) {
				User userData = (User) serverResponse.getData();
				System.out.println(serverResponse.getMessage());
				System.out.println(userData.displayDetails());

			} else {
				// Prints error message if user data access is a failure.
				System.out.println("Error occured: " + serverResponse.getMessage());
			}

		} else {
			// Prints error message if we cannot add the user to the database.
			System.out.println("Error has occured: " + serverResponse.getMessage());
		}

	}

}
