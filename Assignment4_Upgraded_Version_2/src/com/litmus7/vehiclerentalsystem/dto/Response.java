package com.litmus7.vehiclerentalsystem.dto;

import java.util.List;

/**
 * This class is used as a dto that can generate responses based on different
 * scenarios of success and failures. All the methods are static so that we can
 * generate them directly without creating an object. It also lists different
 * constructors that can be used based on the different scenarios.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-06-29
 */

public class Response<T> {
	/**
	 * It is a class used to generate responses for communication between the
	 * different layers.
	 * 
	 * @param status_code      : stores a status code based on a scenario
	 * @param message          : stores the message that needs to be communicated
	 *                         across the layers
	 * @param data             : stores the data that needs to be sent across the
	 *                         layers.
	 * @param totalRentalPrice : stores the rental price data that needs to be
	 *                         communicated across the layers.
	 * @param model            : Stores the model associated with the vehicle.
	 * @param brand            : Stores the brand associated with the vehicle.
	 * @param e                : Stores the exception that is generated and passed
	 *                         on using the methods of the Response class.
	 */
	private int status_code;
	private String message;
	private List<T> data;
	private double totalRentalPrice;
	private String model;
	private String brand;
	private Exception e;

	// Its a default constructor.
	public Response() {

	}

	// Its a constructor used when the object made has only parameters "status_code"
	// and "message".
	public Response(int status_code, String message) {
		// Constructor to set simple messages
		this.status_code = status_code;
		this.message = message;
	}

	// Its a constructor used when the object made has only parameters
	// "status_code", "message", and "data"(ArrayList of objects).
	public Response(int status_code, String message, List<T> data) {
		// constructor to get data such as car list, bike list
		this.status_code = status_code;
		this.message = message;
		this.data = data;
	}

	// Its a constructor used when the object made has only parameters
	// "status_code", "message", and "totalRentalPrice".
	public Response(int status_code, String message, double totalRentalPrice) {
		// constructor to get data of type int.
		this.status_code = status_code;
		this.message = message;
		this.totalRentalPrice = totalRentalPrice;
	}

	// Its a constructor used when the object made has only parameters
	// "status_code", "message", and "e"(exception).
	public Response(int status_code, String message, Exception e) {
		this.status_code = status_code;
		this.message = message;
		this.e = e;
	}

	// Method used to generate an object of type Response when the object made has
	// only parameters "status_code" and "message".
	public static Response success(int status_code, String message) {
		return new Response(status_code, message);
	}

	// Method used to generate an object of type Response when the object made has
	// only parameters "status_code", "message", and "totalRentalPrice".
	public static Response success(int status_code, String message, double totalRentalPrice) {
		return new Response(status_code, message, totalRentalPrice);
	}

	// Method used to generate an object of type Response when the object made has
	// only parameters "status_code", "message", and "data"(ArrayList of objects).
	public static <T> Response<T> success(int status_code, String message, List<T> data) {
		return new Response<>(status_code, message, data);
	}

	// Method used to generate an object of type Response when the object made has
	// only parameters "status_code", "message", and "e"(exception).
	public static Response failure(int status_code, String message, Exception e) {
		return new Response(status_code, message, e);
	}

	// Method used to retrieve the value for "message".
	public String getMessage() {
		return message;
	}

	// Method used to set the value for "message".
	public void setMessage(String message) {
		this.message = message;
	}

	// Method used to retrieve the value for "data".
	public List<T> getData() {
		return data;
	}

	// Method used to set the value for "data".
	public void setData(List<T> data) {
		this.data = data;
	}

	// Method used to retrieve the value for "totalRentalPrice".
	public double getTotalRentalPrice() {
		return totalRentalPrice;
	}

	// Method used to set the value for "totalRentalPrice".
	public void setTotalRentalPrice(int totalRentalPrice) {
		this.totalRentalPrice = totalRentalPrice;
	}

	// Method used to retrieve the value for "model".
	public String getModel() {
		return model;
	}

	// Method used to set the value for "model".
	public void setModel(String model) {
		this.model = model;
	}

	// Method used to retrieve the value for "brand".
	public String getBrand() {
		return brand;
	}

	// Method used to set the value for "brand".
	public void setBrand(String brand) {
		this.brand = brand;
	}

	// Method used to retrieve the value for "e".
	public Exception getE() {
		return e;
	}

	// Method used to set the value for "exception".
	public void setE(Exception e) {
		this.e = e;
	}

	// Method used to retrieve the value for "status_code".
	public int getStatus_code() {
		return status_code;
	}

	// Method used to set the value for "status_code".
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

}
