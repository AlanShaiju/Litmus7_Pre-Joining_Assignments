package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserRegistrationDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.CannotRetrieveUserException;

/**
 * In this file we define the service class "UserRegistrationService", it
 * defines two methods "addUser" and "getUserData".
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */

public class UserRegistrationService {

	// Defines the data access object to store and retrieve the data from the
	// database.
	private UserRegistrationDao dao = new UserRegistrationDao();

	public String addUser(String username, String password, String email, int age) {
		// Method used to add the user to the database.
		return dao.addUser(username, password, email, age);
	}

	public User getUserData() throws CannotRetrieveUserException {
		// Method used to retrieve the data from the database.
		// Data is returned in the form of a user object.
		return dao.getUserData();
	}
}
