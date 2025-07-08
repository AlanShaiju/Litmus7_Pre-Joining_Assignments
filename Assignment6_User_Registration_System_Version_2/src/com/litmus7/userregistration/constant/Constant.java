package com.litmus7.userregistration.constant;

/**
 * In this file we define the constants that are used across the User
 * Registration application. It has the following parameters:
 * 
 * @param minUserAgeForRegistration        : Holds the value for the minimum age
 *                                         requirement for a user to be
 *                                         registered.
 * @param maxUserAgeForRegistration        : Holds the value for the maximum age
 *                                         requirement for a user to be
 *                                         registered.
 * @param minPasswordLengthForRegistration : Holds the value for the minimum
 *                                         password length requirement for a
 *                                         user to be registered.
 * @param registerUser                     : Holds the query statement used to
 *                                         add a user to the database.
 * @param retrieveUser                     : Holds the query statement used to
 *                                         retrieve a user from the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-08
 */

public class Constant {
	public static int minUserAgeForRegistration = 18;
	public static int maxUserAgeForRegistration = 60;
	public static int minPasswordLengthForRegistration = 6;
	public static String registerUser = "insert into User (Username, Age, Email, Password) VALUES (?, ?, ?, ?)";
	public static String retrieveUser = "select Username,Age,Email,Password from User where Username = ?";
}
