package com.gurps.shoppingbasket.commerce.domain;

import java.math.BigDecimal;
import java.util.List;

public interface Cart {
	
	List<CartEntry> getItems();
	
	BigDecimal getTotalCartValue();
	
	String getCustomerId();
	
	int getNextCartEntryId();
}
