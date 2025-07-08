package com.litmus7.retail.constant;

/**
 * In this file we define the constants that are used across the User
 * Registration application. It has the following parameters:
 * 
 * @param minProductId        : Holds the value for productId requirement.
 * @param minProductPrice     : Holds the value for product price requirement.
 * @param minProductQuantity  : Holds the value for product quantity
 *                            requirement.
 * @param addProductQuery     : Holds the query statement used to add a product
 *                            to the database.
 * @param getProductQuery     : Holds the query statement used to retrieve a
 *                            product from the database.
 * @param getAllProductsQuery : Holds the query statement used to retrieve all
 *                            products from the database.
 * @param updateProductQuery  : Holds the query statement used to update a
 *                            product in the database.
 * @param deleteProductQuery  : Holds the query statement used to delete a
 *                            product from the database.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-08
 */

public class Constant {
	public static int minProductId = 1;
	public static double minProductPrice = 0;
	public static int minProductQuantity = 0;
	public static String addProductQuery = "insert into Product (ProductId, Name, Category, Price, StockQuantity) values (?, ?, ?, ?, ?)";
	public static String getProductQuery = "select ProductId, Name, Category, Price, StockQuantity from Product where ProductId=?";
	public static String getAllProductsQuery = "select ProductId, Name, Category, Price, StockQuantity from Product";
	public static String updateProductQuery = "update Product set Name = ?, Category = ?, Price = ?, StockQuantity = ? where ProductId = ?";
	public static String deleteProductQuery = "delete from Product where ProductId = ?";
}
