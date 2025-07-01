package com.litmus7.retialdiscountsystem.dto;

import com.litmus7.retaildiscountsystem.interfaces.Discountable;

/**
 * In this file we define the base customer class which is "Regular" This class
 * implements the interface "Discountable" and applies a discount of 5% for all
 * transactions.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-01
 */

public class RegularCustomer implements Discountable {

	public double applyDiscount(double totalAmount) {
		return totalAmount * 0.95;
	}

}
