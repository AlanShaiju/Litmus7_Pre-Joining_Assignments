package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.constant.Constant;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.exception.DaoException;
import com.litmus7.userregistration.exception.DuplicateUserException;
import com.litmus7.userregistration.exception.EmptyNameException;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.service.UserRegistrationService;

/**
 * In this file we define the controller class "UserRegistrationController",
 * that is used to perform initial validation on data. It holds a method
 * "getUserData" that is used to return the details corresponding to a user, it
 * also has a "addUser" method used to add details of a user to the database. It
 * has the following parameters:
 * 
 * @param SUCCESS_CODE : Holds the value that is returned in case of a success.
 * @param FAILURE_CODE : Holds the value that is returned in case of a failure.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class UserRegistrationController {

	private int SUCCESS_CODE = 200;
	private int FAILURE_CODE = 400;
	private UserRegistrationService userRegistrationService = new UserRegistrationService();

	// This method performs the initial validation before adding the user to the
	// database.
	// It checks if the name field is filled or not, if not it throws an exception.
	// It checks if the age meets the user registration requirements of being
	// between 18 and 60.
	// It checks if the password meets the basic requirements of being atleast 6
	// characters in length..
	// It checks if the email meets the satisfactory requirements of having "2" and
	// ".".
	public Response addUser(String username, String password, String email, int age) {
		try {
			if (username == "")
				throw new EmptyNameException(" | Name field was empty ");
			else if (age < Constant.minUserAgeForRegistration || age > Constant.maxUserAgeForRegistration)
				throw new InvalidAgeException(" | User does not meet age requirements ");
			else if (password.length() < Constant.minPasswordLengthForRegistration)
				throw new WeakPasswordException(" | Weak Password ");
			else if (!email.contains("@") || !email.contains("."))
				throw new InvalidEmailException(" | Invalid Email ");
			else
				return Response.success(SUCCESS_CODE, userRegistrationService.addUser(username, password, email, age),
						null);

		} catch (EmptyNameException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);

		} catch (InvalidAgeException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (WeakPasswordException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (InvalidEmailException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (DuplicateUserException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (DaoException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}

	}

	// This method aims at retrieving the user data for the user that has been added
	// the latest.
	public Response getUserData(String username) {
		try {
			return Response.success(SUCCESS_CODE, "User data retrieved", userRegistrationService.getUserData(username));
		} catch (DaoException e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}
}
