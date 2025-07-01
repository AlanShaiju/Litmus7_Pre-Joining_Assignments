package com.litmus7.retaildiscountsystem.dto;

import com.litmus7.retaildiscountsystem.interfaces.Discountable;

/**
 * In this file we define the customer class which is "Wholesale" This class
 * implements the interface "Discountable" and applies a discount of 15% for all
 * transactions above 10000, all other transactions have a discount of 10%.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-01
 */

public class WholesaleCustomer implements Discountable {

	public double applyDiscount(double totalAmount) {
		if (totalAmount > 10000)
			return totalAmount * 0.85;
		else
			return totalAmount * 0.9;
	}

}
