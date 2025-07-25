package com.litmus7.retail.controller;

import com.litmus7.retail.constant.Constant;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.exception.InvalidProductDetailException;
import com.litmus7.retail.service.RetailService;

/**
 * In this file we define the controller "RetailController". It is used for
 * basic validation of data before insertion into the database. It returns the
 * response as a response object of class "Response". We can add products, get
 * product details, get all the products, update product details, delete product
 * from inventory. It has the following parameters:
 * 
 * @param SUCCESS_CODE : Holds the value for a success operation.
 * @param FAILURE_CODE : Holds the value for a failure operation.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class RetailController {
	private static int SUCCESS_CODE = 200;
	private static int FAILURE_CODE = 400;
	private RetailService retailService = new RetailService();

	public Response addProduct(int productId, String name, String category, double price, int stockQuantity) {
		try {

			if (isInvalidProductId(productId)) {
				// Check if product id is valid.
				throw new InvalidProductDetailException("Product Id should be greater than 1");
			} else if (name == "") {
				// Check if product name is not empty.
				throw new InvalidProductDetailException("Product name should not be blank");
			} else if (category == "") {
				// Check if product category is not empty.
				throw new InvalidProductDetailException("Product category should not be blank");
			} else if (price <= Constant.minProductPrice) {
				// Check if product price is valid.
				throw new InvalidProductDetailException("Product price should be greater than 0");
			} else if (stockQuantity < Constant.minProductQuantity) {
				// Check if product quantity is valid.
				throw new InvalidProductDetailException("Product stock showuld be greater than or equal to 0");
			} else
				return Response.success(SUCCESS_CODE,
						retailService.addProduct(productId, name, category, price, stockQuantity), null);

		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}

	public Response getProductById(int productId) {
		try {
			if (isInvalidProductId(productId)) {
				// Check if product id is valid.
				throw new InvalidProductDetailException("Product Id should be greater than 1");
			} else
				return Response.success(SUCCESS_CODE, "Product Details Retrieved",
						retailService.getProductById(productId));

		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}

	public Response getAllProducts() {
		try {
			return Response.success(SUCCESS_CODE, "All Product Details Retrieved", retailService.getAllProducts());

		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}

	public Response updateProduct(int productId, String name, String category, double price, int stockQuantity) {
		try {
			if (isInvalidProductId(productId)) {
				// Check if product id is valid.
				throw new InvalidProductDetailException("Product Id should be greater than 1");
			} else
				return Response.success(SUCCESS_CODE,
						retailService.updateProduct(productId, name, category, price, stockQuantity), null);

		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}

	public Response deleteProduct(int productId) {
		try {
			if (isInvalidProductId(productId)) {
				// Check if product id is valid.
				throw new InvalidProductDetailException("Product Id should be greater than 1");
			} else
				return Response.success(SUCCESS_CODE, retailService.deleteProduct(productId), null);

		} catch (Exception e) {
			return Response.failure(FAILURE_CODE, e.getMessage(), null);
		}
	}

	// Checks if productId is less than 1.
	private boolean isInvalidProductId(int productId) {
		return (productId < Constant.minProductId);

	}

}
