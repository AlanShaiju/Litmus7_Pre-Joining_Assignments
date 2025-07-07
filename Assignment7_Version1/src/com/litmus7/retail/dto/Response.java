package com.litmus7.retail.dto;

/**
 * In this file we define the DTO class "Response" that stores the details
 * corresponding to an operation that is performed. These are the following
 * parameters:
 * 
 * @param statusCode : Stores the status code returned from an operation.
 * @param message    : Stores the message returned from an operation.
 * @param data       : Stores the data returned from an operation.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class Response<T> {

	private int statusCode;
	private String message;
	private T data;

	// Default constructor
	public Response() {

	}

	// Parameterized constructor
	public Response(int statusCode, String message, T data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	// Success method that returns a response object in-case of a success.
	public static <T> Response success(int statusCode, String message, T data) {
		return new Response(statusCode, message, data);
	}

	// Failure method that returns a response object in-case of a failure.
	public static <T> Response failure(int statusCode, String message, T data) {
		return new Response(statusCode, message, data);
	}

	// Retrieves the statusCode
	public int getStatusCode() {
		return statusCode;
	}

	// Sets the value for statusCode
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	// Retrieves the message
	public String getMessage() {
		return message;
	}

	// Sets the value for message
	public void setMessage(String message) {
		this.message = message;
	}

	// Retrieves the data
	public T getData() {
		return data;
	}

	// Sets the value for data
	public void setData(T data) {
		this.data = data;
	}

}
