package com.litmus7.retaildiscountsystem.interfaces;

/**
 * In this file we list the methods that are present inside the interface
 * "Discountable" This interface is implemented to allow the system to provide
 * discounts based on user categories.
 * 
 * @author Alan Shaiju Kurian
 * @version 1.0
 * @since 2025-07-01
 */

public interface Discountable {
	double applyDiscount(double totalAmount);
}
