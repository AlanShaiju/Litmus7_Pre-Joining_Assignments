package com.litmus7.userregistration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * In this file we define the utility class "DBUtil" that is used to load the
 * connection with the database. It has parameters:
 * 
 * @param url      : Stores the url of the database.
 * @param username : Stores the username to access the database.
 * @param password : Stores the password to access the database.
 * 
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-08
 */

@SuppressWarnings("unused")
public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	static {
		// We load the details from a properties file.
		try (InputStream input = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			if (input == null) {
				throw new RuntimeException("Unable to find db.properties");
			}
			props.load(input);
			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
		} catch (Exception e) {
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	// Method that connects to the database.
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
