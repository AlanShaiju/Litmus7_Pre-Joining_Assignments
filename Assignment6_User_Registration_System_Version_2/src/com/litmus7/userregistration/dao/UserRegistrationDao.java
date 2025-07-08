package com.litmus7.userregistration.dao;

import java.sql.*;

import com.litmus7.userregistration.constant.Constant;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DaoException;
import com.litmus7.userregistration.util.DBUtil;

/**
 * In this file we define the DAO class "UserRegistrationDao", used to deal with
 * the storage and retrieval of data. It has the following parameters:
 * 
 * @param dbUser     : Holds the username for accessing the database.
 * @param dbPassword : Holds the password for accessing the database.
 * @param dbUrl      : Holds the url for accessing the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class UserRegistrationDao {
	// We use this method to add the user to the database. We connect to the
	// database and build a prepared statement and load the details that are passed
	// as parameters in the method.

	public String addUser(String username, String password, String email, int age) throws DaoException {
		try (Connection connection = DBUtil.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(Constant.registerUser);
			preparedStatement.setString(1, username);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.executeUpdate();
			return "User has been registered";

		} catch (SQLException e) {
			throw new DaoException("Could not connect to database." + e.getMessage(), e);
		}
	}

	// We use this method to return the details of the user that is added latest.
	public User getUserData(String username) throws DaoException {
		try (Connection connection = DBUtil.getConnection()) {
			String password = null, email = null;
			int age = -1;
			// Create a statement
			PreparedStatement statement = connection.prepareStatement(Constant.retrieveUser);
			statement.setString(1, username);
			// Execute a sql query
			ResultSet result = statement.executeQuery();
			// Process the result set
			while (result.next()) {
				username = result.getString("Username");
				password = result.getString("Password");
				email = result.getString("Email");
				age = result.getInt("Age");
			}
			if (password == null)
				return null;
			return new User(username, password, email, age);

		} catch (SQLException e) {
			throw new DaoException("Could not connect to database.", e);
		}
	}

}
