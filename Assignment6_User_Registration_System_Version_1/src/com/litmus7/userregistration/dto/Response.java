package com.litmus7.userregistration.dto;

/**
 * In this file we define the DTO class "Response", it is used to send different
 * responses that occur incase of a success or failure. It has the following
 * parameters:
 * 
 * @param statusCode : Defines the status of an operation.
 * @param message    : Holds the message that is passed from the operation that
 *                   is performed.
 * @param data       : Holds the data that is retrieved after the operation is
 *                   performed.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-06
 */

public class Response<T> {

	private int statusCode;
	private String message;
	private T data;

	public int getStatusCode() {
		// Returns the status code associated with an object of type "Response".
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		// Sets the status code value for an object of type "Response".
		this.statusCode = statusCode;
	}

	public String getMessage() {
		// Returns the message from the operation from the "Response" object.
		return message;
	}

	public void setMessage(String message) {
		// Sets the message for an object of type "Response".
		this.message = message;
	}

	public T getData() {
		// Returns the data from the operation from the "Response" object.
		return data;
	}

	public void setData(T data) {
		// Sets the data for an object of type "Response".
		this.data = data;
	}

	// Default constructor
	public Response() {

	}

	// Parameterized constructor used to create a response object.
	public Response(int statusCode, String message, T data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	// Method used in the case of a success.
	public static <T> Response success(int statusCode, String message, T data) {
		return new Response(statusCode, message, data);
	}

//Method used in case of a failure.
	public static <T> Response failure(int statusCode, String message, T data) {
		return new Response(statusCode, message, data);
	}

}
