package com.litmus7.retail.dto;

/**
 * In this file we define the DTO class "Product" that stores the details of a
 * product object. The file lists the different methods to retrieve and fix the
 * values for a product object. These are the following parameters:
 * 
 * @param productId     : Stores the product id for a product.
 * @param name          : Stores the product name for a product.
 * @param category      : Stores the category for a product.
 * @param price         : Stores the price for a product.
 * @param stockQuantity : Stores the quantity of the product that is available.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class Product {
	private int productId;
	private String name;
	private String category;
	private double price;
	private int stockQuantity;

	// Default constructor
	public Product() {

	}

	// Parameterized constructor
	public Product(int productId, String name, String category, double price, int stockQuantity) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	// Method used to print the details of the product that is available.
	public String toString() {
		return "ProductId:" + productId + " | Name:" + name + " | Category:" + category + " | Price" + price
				+ " | Stock Quantity:" + stockQuantity;
	}

	// Retrieve productId.
	public int getProductId() {
		return productId;
	}

	// Set the value for productId
	public void setProductId(int productId) {
		this.productId = productId;
	}

	// Retrieve the value for name.
	public String getName() {
		return name;
	}

	// Set the value for name.
	public void setName(String name) {
		this.name = name;
	}

	// Retrieve the value for category.
	public String getCategory() {
		return category;
	}

	// Set the value for category.
	public void setCategory(String category) {
		this.category = category;
	}

	// Retrieve the value for price.
	public double getPrice() {
		return price;
	}

	// Set the value for price.
	public void setPrice(double price) {
		this.price = price;
	}

	// Retrieve the value for stockQuantity
	public int getStockQuantity() {
		return stockQuantity;
	}

	// Set the value for stockQuantity
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}
