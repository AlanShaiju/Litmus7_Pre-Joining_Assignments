package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserRegistrationDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DaoException;
import com.litmus7.userregistration.exception.DuplicateUserException;

/**
 * In this file we define the service class "UserRegistrationService", it
 * defines two methods "addUser" and "getUserData".
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class UserRegistrationService {

	// Defines the data access object to store and retrieve the data from the
	// database.
	private UserRegistrationDao userRegistrationDAO = new UserRegistrationDao();

	public String addUser(String username, String password, String email, int age) throws DaoException, DuplicateUserException {
		// Method used to add the user to the database.
		User user = userRegistrationDAO.getUserData(username);
		if(user==null)
			return userRegistrationDAO.addUser(username, password, email, age);
		else
			throw new DuplicateUserException("This user already exists | Try a different username");
	}

	public User getUserData(String username) throws DaoException {
		// Method used to retrieve the data from the database.
		// Data is returned in the form of a user object.
		return userRegistrationDAO.getUserData(username);
	}
}
