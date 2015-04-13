package com.gurps.shoppingbasket.commerce.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Cart {

	private List<CartEntry> items;
	private String customerId;

	public ShoppingCart() {	
		items = new ArrayList<CartEntry>();
	}
	
	
	
	public BigDecimal getTotalCartValue(){
		BigDecimal total = BigDecimal.ZERO;
		for(CartEntry entry : items){
			total = total.add(entry.getQuantity().multiply(entry.getPrice()));
		}
		return total.setScale(2);
	}

	@Override
	public int getNextCartEntryId() {
		if(items.size() == 0){
			return 0;
		}
		return items.size() - 1;
	}


	public List<CartEntry> getItems() {
		return items;
	}
	
	
	
	public String getCustomerId() {
		return customerId;
	}
}
