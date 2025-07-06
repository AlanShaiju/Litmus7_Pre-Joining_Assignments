package com.litmus7.userregistration.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.CannotRetrieveUserException;

/**
 * In this file we define the DAO class "UserRegistrationDao", used to deal with
 * the storage and retrieval of data. It has the following parameters:
 * 
 * @param dbUser     : Holds the username for accessing the database.
 * @param dbPassword : Holds the password for accessing the database.
 * @param dbUrl      : Holds the url for accessing the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */

public class UserRegistrationDao {
	private static String dbUser = null;
	private static String dbPassword = null;
	private static String dbUrl = null;
	/*
	 * We define the static block to load the details for accessing the database. In
	 * the static block we define an object of class "Properties" called "props".
	 */
	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("demo.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dbUser = props.getProperty("user");
		dbPassword = props.getProperty("password");
		dbUrl = props.getProperty("dburl");
	}

	// We use this method to add the user to the database. We connect to the
	// database and build a prepared statement and load the details that are passed
	// as parameters in the method.

	public String addUser(String username, String password, String email, int age) {
		try (Connection myConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
			PreparedStatement ps = myConn
					.prepareStatement("INSERT INTO User (Username, Age, Email, Password) VALUES (?, ?, ?, ?)");
			ps.setString(1, username);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.executeUpdate();
			return "User has been registered";

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// We use this method to return the details of the user that is added latest.
	public User getUserData() throws CannotRetrieveUserException {
		try (Connection myConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
			String username = null, password = null, email = null;
			int age = -1;
			// Create a statement
			Statement myStmt = myConn.createStatement();
			// Execute a sql query
			ResultSet myRs = myStmt
					.executeQuery("select Username,Age,Email,Password from User order by UserID desc limit 1");
			// Process the result set
			while (myRs.next()) {
				username = myRs.getString("Username");
				password = myRs.getString("Password");
				email = myRs.getString("Email");
				age = myRs.getInt("Age");
			}
			if (username == null)
				throw new CannotRetrieveUserException("User cannot be found");
			return new User(username, password, email, age);

		} catch (Exception e) {
			throw new CannotRetrieveUserException("User cannot be found", e);
		}
	}

}
