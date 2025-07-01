package com.litmus7.retialdiscountsystem.dto;

import com.litmus7.retaildiscountsystem.interfaces.Discountable;

/**
 * In this file we define the customer class which is "Premium" This class
 * implements the interface "Discountable" and applies a discount of 10% for all
 * transactions above 5000, all other transactions have a discount of 7%.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-01
 */

public class PremiumCustomer implements Discountable {

	public double applyDiscount(double totalAmount) {
		if (totalAmount > 5000)
			return totalAmount * 0.9;
		else
			return totalAmount * 0.93;
	}

}
