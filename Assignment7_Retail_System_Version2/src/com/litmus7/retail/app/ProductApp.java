package com.litmus7.retail.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.controller.RetailController;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;

/**
 * In this file we define the client "ProductApp", that is used by the client to
 * communicate with the database. It has the following parameters:
 * 
 * @param name             : Holds the name of a product.
 * @param category         : Holds the category of a product.
 * @param productId        : Holds the product id of a product.
 * @param stockQuantity    : Holds the stock quantity of a product.
 * @param serverResponse   : Object used to hold the data corresponding to a
 *                         "Response" class.
 * @param productList      : Stores the list of products.
 * @param product          : Stores the detail corresponding to a object of type
 *                         'Product".
 * @param retailController : Variable used to communicate with the controller
 *                         class.
 * @param flag             : Used to control the loop of execution.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-07
 */

public class ProductApp {
	private static int SUCCESS_CODE = 200;
	@SuppressWarnings("unused")
	private static int FAILURE_CODE = 400;

	@SuppressWarnings({ "unchecked", "resource", "rawtypes" })
	public static void main(String[] args) {
		String name, category;
		int productId, stockQuantity;
		double price;
		System.out.println("---  Retail Product Catalog Manager  ---");
		List<Product> productList = new ArrayList<>();
		Product product = new Product();
		Scanner scanner = new Scanner(System.in);
		Response serverResponse = new Response();
		RetailController retailController = new RetailController();
		int flag = 0;
		while (flag != 6) {
			System.out.println("---  Options  ---");
			System.out.println("1. Add Product");
			System.out.println("2. View Product by ID");
			System.out.println("3. View all products");
			System.out.println("4. Update Product");
			System.out.println("5. Delete Product");
			System.out.println("6. Exit Application");
			System.out.print("Enter Choice:");
			System.out.println();
			flag = scanner.nextInt();
			scanner.nextLine();

			switch (flag) {
			case 1:
				System.out.println("Enter product details:");
				System.out.print("Enter Product ID:");
				productId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Product Name:");
				name = scanner.nextLine();
				System.out.print("Enter Category:");
				category = scanner.nextLine();
				System.out.print("Enter Price:");
				price = scanner.nextDouble();
				System.out.print("Enter Stock Quantity:");
				stockQuantity = scanner.nextInt();
				scanner.nextLine();
				serverResponse = retailController.addProduct(productId, name, category, price, stockQuantity);
				// Checks if the operation is a success.
				if (serverResponse.getStatusCode() == SUCCESS_CODE) {
					System.out.println(serverResponse.getMessage());
				} else {
					System.out.println(serverResponse.getMessage());
				}

				break;
			case 2:
				System.out.print("Enter the productId to search:");
				productId = scanner.nextInt();
				scanner.nextLine();
				serverResponse = retailController.getProductById(productId);
				// Checks if the operation is a success.
				if (serverResponse.getStatusCode() == SUCCESS_CODE) {
					product = (Product) serverResponse.getData();
					System.out.println("---  Product Details  ---");
					System.out.println("ID:" + product.getProductId());
					System.out.println("Name:" + product.getName());
					System.out.println("Category:" + product.getCategory());
					System.out.println("Price:" + product.getPrice());
					System.out.println("Stock:" + product.getStockQuantity());
				} else {
					System.out.println(serverResponse.getMessage());
				}
				break;
			case 3:
				serverResponse = retailController.getAllProducts();
				// Checks if the operation is a success.
				if (serverResponse.getStatusCode() == SUCCESS_CODE) {
					System.out.println("---  All products in catalog  ---");
					productList = (List<Product>) serverResponse.getData();
					for (Product item : productList) {
						System.out.println(item);
					}
				} else {
					System.out.println(serverResponse.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter product ID to update:");
				productId = scanner.nextInt();
				scanner.nextLine();
				// Checks if the operation is a success.
				serverResponse = retailController.getProductById(productId);
				if (serverResponse.getStatusCode() == SUCCESS_CODE) {
					product = (Product) serverResponse.getData();
					System.out.print("Enter new name(Current name:" + product.getName() + "):");
					name = scanner.nextLine();
					System.out.print("Enter new category(Current category:" + product.getCategory() + "):");
					category = scanner.nextLine();
					System.out.print("Enter new price(Current price:" + product.getPrice() + "):");
					price = scanner.nextDouble();
					System.out.print("Enter new stock(Current stockQuantity:" + product.getStockQuantity() + "):");
					stockQuantity = scanner.nextInt();
					serverResponse = retailController.updateProduct(productId, name, category, price, stockQuantity);
					// Checks if the operation is a success.
					if (serverResponse.getStatusCode() == SUCCESS_CODE) {
						System.out.println(serverResponse.getMessage());
					} else {
						System.out.println(serverResponse.getMessage());
					}

				} else {
					System.out.println(serverResponse.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter product ID to delete:");
				productId = scanner.nextInt();
				scanner.nextLine();
				serverResponse = retailController.getProductById(productId);
				// Checks if the operation is a success.
				if (serverResponse.getStatusCode() == SUCCESS_CODE) {
					serverResponse = retailController.deleteProduct(productId);
					// Checks if the operation is a success.
					if (serverResponse.getStatusCode() == SUCCESS_CODE) {
						System.out.println(serverResponse.getMessage());
					} else {
						System.out.println(serverResponse.getMessage());
					}

				} else {
					System.out.println(serverResponse.getMessage());
				}
				break;
			case 6:
				System.out.println("Exiting application");
				System.out.println("Thank you for using RetailMart Product Catalog Manager.\r\n" + "Goodbye!");
				break;
			default:
				System.out.println("Enter a valid number");
				break;

			}

		}
		scanner.close();

	}

}
