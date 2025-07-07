package com.litmus7.retail.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
 * @version 1.0
 * @since 2025-07-07
 */

public class ProductDAOImpl implements ProductDAO {

	DBUtil util = new DBUtil();

	@Override
	public String addProduct(Product product) throws DataInsertionFailureException {
		try (Connection myConn = util.getConnection()) {
			// Prepared statement that is used to set the product details when executing.
			PreparedStatement myStmt = myConn.prepareStatement(
					"insert into Product (ProductId, Name, Category, Price, StockQuantity) values (?, ?, ?, ?, ?)");
			myStmt.setInt(1, product.getProductId());
			myStmt.setString(2, product.getName());
			myStmt.setString(3, product.getCategory());
			myStmt.setDouble(4, product.getPrice());
			myStmt.setInt(5, product.getStockQuantity());
			// Execute a sql query
			myStmt.executeUpdate();
			return "Success in adding data to database.";

		} catch (Exception e) {
			throw new DataInsertionFailureException("Adding data to database failed:" + e.getMessage());
		}
	}

	@Override
	public Product getProductById(int productId) throws DataSearchFailureException {
		Product product = new Product();
		try (Connection myConn = util.getConnection()) {
			// Prepared statement that is used to set the product id when executing.
			PreparedStatement myStmt = myConn.prepareStatement(
					"select ProductId, Name, Category, Price, StockQuantity from Product where ProductId=?");
			myStmt.setInt(1, productId);
			// Execute a sql query
			ResultSet myRs = myStmt.executeQuery();
			myRs.next();
			product.setProductId(myRs.getInt("ProductId"));
			product.setName(myRs.getString("Name"));
			product.setCategory(myRs.getString("Category"));
			product.setPrice(myRs.getDouble("Price"));
			product.setStockQuantity(myRs.getInt("StockQuantity"));
			return product;

		} catch (Exception e) {
			throw new DataSearchFailureException(
					"Requested data not found | Product does not exist in database | :" + e.getMessage());
		}
	}

	@Override
	public List<Product> getAllProducts() throws DataSearchFailureException {

		List<Product> productList = new ArrayList<>();

		try (Connection myConn = util.getConnection()) {

			Statement myStmt = myConn.createStatement();

			// Execute a sql query
			String sql = "select ProductId, Name, Category, Price, StockQuantity from Product";
			ResultSet myRs = myStmt.executeQuery(sql);
			// Get all product details
			while (myRs.next()) {
				Product product = new Product();
				product.setProductId(myRs.getInt("ProductId"));
				product.setName(myRs.getString("Name"));
				product.setCategory(myRs.getString("Category"));
				product.setPrice(myRs.getDouble("Price"));
				product.setStockQuantity(myRs.getInt("StockQuantity"));
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
		try (Connection myConn = util.getConnection()) {
			// Prepared statement that is used to set the product details when executing.
			PreparedStatement myStmt = myConn.prepareStatement(
					"update Product set Name = ?, Category = ?, Price = ?, StockQuantity = ? where ProductId = ?");
			myStmt.setString(1, product.getName());
			myStmt.setString(2, product.getCategory());
			myStmt.setDouble(3, product.getPrice());
			myStmt.setInt(4, product.getStockQuantity());
			myStmt.setInt(5, product.getProductId());
			// Execute a sql query
			myStmt.executeUpdate();
			return "Success in updating data in database.";

		} catch (Exception e) {
			throw new DataUpdationFailureException("Updating data in database failed:" + e.getMessage());
		}
	}

	@Override
	public String deleteProduct(int productId) throws DataDeletionFailureException {
		try (Connection myConn = util.getConnection()) {
			// Prepared statement that is used to set the product id when executing.
			PreparedStatement myStmt = myConn.prepareStatement("delete from Product where ProductId = ?");
			myStmt.setInt(1, productId);
			// Execute a sql query
			myStmt.executeUpdate();
			return "Data has been deleted";

		} catch (Exception e) {
			throw new DataDeletionFailureException("Could not delete data | :" + e.getMessage());
		}
	}

}
