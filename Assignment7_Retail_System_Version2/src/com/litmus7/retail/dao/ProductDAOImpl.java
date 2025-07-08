package com.litmus7.retail.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.constant.Constant;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DataDeletionFailureException;
import com.litmus7.retail.exception.DataInsertionFailureException;
import com.litmus7.retail.exception.DataSearchFailureException;
import com.litmus7.retail.exception.DataUpdationFailureException;
import com.litmus7.retail.util.DBUtil;

/**
 * In this file we define the class that implements the methods defined in the
 * implementation class for the retail system. The file shows the logic behind
 * how the implementation works.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-07-08
 */

public class ProductDAOImpl implements ProductDAO {

	DBUtil util = new DBUtil();

	@Override
	public String addProduct(Product product) throws DataInsertionFailureException {
		try (Connection connection = util.getConnection()) {
			// Prepared statement that is used to set the product details when executing.
			PreparedStatement statement = connection.prepareStatement(Constant.addProductQuery);
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getCategory());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, product.getStockQuantity());
			// Execute a sql query
			statement.executeUpdate();
			return "Success in adding data to database.";

		} catch (Exception e) {
			throw new DataInsertionFailureException("Adding data to database failed:" + e.getMessage());
		}
	}

	@Override
	public Product getProductById(int productId) throws DataSearchFailureException {

		try (Connection connection = util.getConnection()) {
			// Prepared statement that is used to set the product id when executing.
			PreparedStatement statement = connection.prepareStatement(Constant.getProductQuery);
			statement.setInt(1, productId);
			// Execute a sql query
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Product product = new Product();
				product.setProductId(result.getInt("ProductId"));
				product.setName(result.getString("Name"));
				product.setCategory(result.getString("Category"));
				product.setPrice(result.getDouble("Price"));
				product.setStockQuantity(result.getInt("StockQuantity"));
				return product;
			} else
				return null;

		} catch (Exception e) {
			throw new DataSearchFailureException(
					"Requested data not found | Product does not exist in database | :" + e.getMessage());
		}
	}

	@Override
	public List<Product> getAllProducts() throws DataSearchFailureException {

		List<Product> productList = new ArrayList<>();

		try (Connection connection = util.getConnection()) {

			Statement statement = connection.createStatement();

			// Execute a sql query
			ResultSet result = statement.executeQuery(Constant.getAllProductsQuery);
			// Get all product details
			while (result.next()) {
				Product product = new Product();
				product.setProductId(result.getInt("ProductId"));
				product.setName(result.getString("Name"));
				product.setCategory(result.getString("Category"));
				product.setPrice(result.getDouble("Price"));
				product.setStockQuantity(result.getInt("StockQuantity"));
				// Add the product into the product list
				productList.add(product);
			}
			if (productList.isEmpty()) {
				throw new DataSearchFailureException("No data is present in database.");
			}
			return productList;

		} catch (Exception e) {
			throw new DataSearchFailureException("Could not retrieve the product details:" + e.getMessage());
		}
	}

	@Override
	public String updateProduct(Product product) throws DataUpdationFailureException {
		try (Connection connection = util.getConnection()) {
			// Prepared statement that is used to set the product details when executing.
			PreparedStatement statement = connection.prepareStatement(Constant.updateProductQuery);
			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setDouble(3, product.getPrice());
			statement.setInt(4, product.getStockQuantity());
			statement.setInt(5, product.getProductId());
			// Execute a sql query
			statement.executeUpdate();
			return "Success in updating data in database.";

		} catch (Exception e) {
			throw new DataUpdationFailureException("Updating data in database failed:" + e.getMessage());
		}
	}

	@Override
	public String deleteProduct(int productId) throws DataDeletionFailureException {
		try (Connection connection = util.getConnection()) {
			// Prepared statement that is used to set the product id when executing.
			PreparedStatement statement = connection.prepareStatement(Constant.deleteProductQuery);
			statement.setInt(1, productId);
			// Execute a sql query
			statement.executeUpdate();
			return "Data has been deleted";

		} catch (Exception e) {
			throw new DataDeletionFailureException("Could not delete data | :" + e.getMessage());
		}
	}

}
