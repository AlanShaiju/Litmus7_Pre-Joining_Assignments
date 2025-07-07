package com.litmus7.retail.exception;

/**
 * In this file we define the exception that occurs when the product details
 * supplied is invalid.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class InvalidProductDetailException extends Exception {
	public InvalidProductDetailException(String string) {
		super(string);

	}

	public InvalidProductDetailException(String string, Throwable cause) {
		super(string, cause);
	}
}
