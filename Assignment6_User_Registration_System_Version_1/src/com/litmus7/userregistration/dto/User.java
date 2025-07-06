package com.litmus7.userregistration.dto;

/**
 * In this file we define the DTO class "User", that is used to hold the basic
 * details corresponding to a user when registering a user to the database. It
 * holds a method "displayDetails" that is used to return the details
 * corresponding to a user. It has a super constructor that is used to hold the
 * data corresponding to a user. It has the following parameters:
 * 
 * @param username : Holds the username of a user.
 * @param password : Holds the password of a user.
 * @param email    : Holds the email of a user.
 * @param age      : Holds the age corresponding to a user.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */
public class User {
	private String username;
	private String password;
	private String email;
	private int age;

	// Defines the super constructor to set the values for the user object that is
	// made.
	public User(String username, String password, String email, int age) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public String displayDetails() {
		// Returns the details corresponding to a user.
		return "Username:" + username + " | Password:" + password + " | Email:" + email + " | Age:" + age;
	}
}
