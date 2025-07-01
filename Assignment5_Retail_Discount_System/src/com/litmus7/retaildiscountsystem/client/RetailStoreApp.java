package com.litmus7.retaildiscountsystem.client;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.dto.PremiumCustomer;
import com.litmus7.retaildiscountsystem.dto.RegularCustomer;
import com.litmus7.retaildiscountsystem.dto.WholesaleCustomer;

/**
 * In this file we define the client class "RetailApp" which allows us to apply
 * discounts to the different transacting customer classes and amounts. The
 * client side application allows us to select the customer class and provides
 * us with details such as purchase amount, discount applied, and payable
 * amount. We create objects of the 3 customer classes to apply the appropriate
 * discount based on the customer class.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-01
 */

public class RetailStoreApp {

	public static void main(String[] args) {
		int option = 0;
		double purchaseAmount, discountApplied, finalPayable;
		Scanner scanner = new Scanner(System.in);
		RegularCustomer regularCustomer = new RegularCustomer();
		PremiumCustomer premiumCustomer = new PremiumCustomer();
		WholesaleCustomer wholesaleCustomer = new WholesaleCustomer();
		while (option != 4) {
			System.out.print("Enter customer type (1-Regular, 2-Premium, 3-Wholesale, 4-Exit Application): ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.print("Enter total purchase amount: ");
				purchaseAmount = scanner.nextDouble();
				finalPayable = regularCustomer.applyDiscount(purchaseAmount);
				discountApplied = purchaseAmount - finalPayable;
				System.out.println("Customer Type: Regular Customer");
				System.out.println("Original Amount: " + purchaseAmount);
				System.out.println("Discount Applied: " + discountApplied);
				System.out.println("Final Payable Amount: " + finalPayable);
				break;
			case 2:
				System.out.print("Enter total purchase amount: ");
				purchaseAmount = scanner.nextDouble();
				finalPayable = premiumCustomer.applyDiscount(purchaseAmount);
				discountApplied = purchaseAmount - finalPayable;
				System.out.println("Customer Type: Premium Customer");
				System.out.println("Original Amount: " + purchaseAmount);
				System.out.println("Discount Applied: " + discountApplied);
				System.out.println("Final Payable Amount: " + finalPayable);
				break;
			case 3:
				System.out.print("Enter total purchase amount: ");
				purchaseAmount = scanner.nextDouble();
				finalPayable = wholesaleCustomer.applyDiscount(purchaseAmount);
				discountApplied = purchaseAmount - finalPayable;
				System.out.println("Customer Type: Wholesale Customer");
				System.out.println("Original Amount: " + purchaseAmount);
				System.out.println("Discount Applied: " + discountApplied);
				System.out.println("Final Payable Amount: " + finalPayable);
				break;
			case 4:
				System.out.println("Exiting the application");
				break;
			default:
				System.out.println("Please provide a valid entry.");
				break;
			}
		}
		scanner.close();
	}
}
