package com.litmus7.retail.service;

import java.util.List;

import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DataDeletionFailureException;
import com.litmus7.retail.exception.DataInsertionFailureException;
import com.litmus7.retail.exception.DataSearchFailureException;
import com.litmus7.retail.exception.DataUpdationFailureException;
import com.litmus7.retail.exception.DuplicateDataException;

/**
 * In this file we define the service class "RetailService" that is used to
 * store the business logic and it contacts the DAO class to load and send data
 * to the database.
 * 
 * 
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class RetailService {

	// dao object used to access the database
	private ProductDAOImpl retailDAO = new ProductDAOImpl();

	// Method used to add a product to the database
	public String addProduct(int productId, String name, String category, double price, int stockQuantity)
			throws DataInsertionFailureException, DuplicateDataException, DataSearchFailureException {
		if (retailDAO.getProductById(productId) == null) {
			Product product = new Product(productId, name, category, price, stockQuantity);
			return retailDAO.addProduct(product);
		} else {
			throw new DuplicateDataException("Data already exists");
		}
	}

	// Method used to retrieve a product given the productId
	public Product getProductById(int productId) throws DataSearchFailureException {
		return retailDAO.getProductById(productId);
	}

	// Method used to retrieve the list of products that are available in the
	// database
	public List<Product> getAllProducts() throws DataSearchFailureException {
		return retailDAO.getAllProducts();
	}

	// Method used to update an existing product in the database
	public String updateProduct(int productId, String name, String category, double price, int stockQuantity)
			throws DataUpdationFailureException {
		Product product = new Product(productId, name, category, price, stockQuantity);
		return retailDAO.updateProduct(product);
	}

	// Method used to delete an existing product from the database
	public String deleteProduct(int productId) throws DataDeletionFailureException {
		return retailDAO.deleteProduct(productId);
	}

}
