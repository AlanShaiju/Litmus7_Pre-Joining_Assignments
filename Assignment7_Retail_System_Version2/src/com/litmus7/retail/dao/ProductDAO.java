package com.litmus7.retail.dao;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DataDeletionFailureException;
import com.litmus7.retail.exception.DataInsertionFailureException;
import com.litmus7.retail.exception.DataSearchFailureException;
import com.litmus7.retail.exception.DataUpdationFailureException;

/**
 * In this file we define the interface and the methods that is present for a
 * retail system. The defined methods include methods for adding data,
 * retrieving a specific data, retrieving all data, updating a data, deleting a
 * product.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public interface ProductDAO {
	String addProduct(Product product) throws DataInsertionFailureException;

	Product getProductById(int productId) throws DataSearchFailureException;

	List<Product> getAllProducts() throws DataSearchFailureException;

	String updateProduct(Product product) throws DataUpdationFailureException;

	String deleteProduct(int productId) throws DataDeletionFailureException;
}
