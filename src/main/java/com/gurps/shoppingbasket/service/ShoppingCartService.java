package com.gurps.shoppingbasket.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gurps.shoppingbasket.commerce.domain.Cart;
import com.gurps.shoppingbasket.commerce.domain.CartEntry;
import com.gurps.shoppingbasket.commerce.domain.ShoppingCart;

public class ShoppingCartService {
	
	//Only one copy of pendingOrders to be shared
	private static Map<String, Cart> shoppingCarts;
	private static ShoppingCartService instance;
	
	private ShoppingCartService(){
		shoppingCarts = new HashMap<String, Cart>();
	}
	
	public static ShoppingCartService getInstance(){
		if(instance == null){
			instance = new ShoppingCartService();
		}
		return instance;
	}
	
	
	public Cart getShoppingCart(String customerId){
		Cart cart =  shoppingCarts.get(customerId);
		if (cart == null){
			cart = this.createCart(customerId);
		}
		return cart;
		
	}
	
	public Cart createCart(String customerId){
		Cart cart = new ShoppingCart();
		shoppingCarts.put(customerId, cart);
		return cart;
	}
	
	public void addProduct(String customerId, CartEntry item) {
		Cart cart = getShoppingCart(customerId);		
		cart.getItems().add(item);
	}
	
	public void removeEntry(String customerId, int entryId) {
		removeEntries(customerId, new int[]{entryId});
	}
	
	public void removeEntries(String customerId, int... entryIds){
		Cart cart = getShoppingCart(customerId);
		List<CartEntry> entries = cart.getItems();
		
		Iterator<CartEntry> it = entries.iterator();
		
		while(it.hasNext()){
			CartEntry entry = it.next();
			for(int entryId : entryIds){
				if (entry.getEntryId() == entryId){
					it.remove();
				}
			}
		}
		
	}
}
