package com.gurps.shoppingbasket.commerce.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.gurps.shoppingbasket.commerce.domain.Cart;
import com.gurps.shoppingbasket.commerce.domain.CartEntry;
import com.gurps.shoppingbasket.commerce.domain.CatalogItem;
import com.gurps.shoppingbasket.service.CatalogService;
import com.gurps.shoppingbasket.service.ShoppingCartService;

public class TestCart {

	@Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
       Field instance = ShoppingCartService.class.getDeclaredField("instance");
       instance.setAccessible(true);
       instance.set(null, null);
    }
	
	@Test
	public void testAddProduct() {
		CatalogService catalogService = CatalogService.getInstance();
		ShoppingCartService cartService = ShoppingCartService.getInstance();
		CatalogItem item = catalogService.findItemBySku("mySku1");
		
		Cart cart = cartService.getShoppingCart("gurps");
		CartEntry cartEntry = new CartEntry(cart.getNextCartEntryId(), item,  new BigDecimal("2"));
		cartService.addProduct("gurps", cartEntry);
		
		assertEquals("20.00",cart.getTotalCartValue().toPlainString());
	}
	
	@Test
	public void testRemoveProduct(){
		CatalogService catalogService = CatalogService.getInstance();
		ShoppingCartService cartService = ShoppingCartService.getInstance();
		CatalogItem item = catalogService.findItemBySku("mySku1");
		
		Cart cart = cartService.getShoppingCart("gurps");
		CartEntry cartEntry = new CartEntry(cart.getNextCartEntryId(), item,  new BigDecimal("2"));
		cartService.addProduct("gurps", cartEntry);
		
		cartService.removeEntry("gurps", 0);
		
		assertEquals("0.00", cart.getTotalCartValue().toPlainString());
		
	}
	
	@Test
	public void testRemoveProducts(){
		CatalogService catalogService = CatalogService.getInstance();
		ShoppingCartService cartService = ShoppingCartService.getInstance();
		CatalogItem item = catalogService.findItemBySku("mySku1");
		CatalogItem item2 = catalogService.findItemBySku("mySku2");
		
		Cart cart = cartService.getShoppingCart("gurps");
		CartEntry cartEntry = new CartEntry(cart.getNextCartEntryId(), item,  new BigDecimal("2"));
		cartService.addProduct("gurps", cartEntry);
		
		CartEntry cartEntry2 = new CartEntry(cart.getNextCartEntryId(), item2,  new BigDecimal("1"));
		cartService.addProduct("gurps", cartEntry2);
		
		cartService.removeEntries("gurps", 0,1);
		
		assertEquals("0.00", cart.getTotalCartValue().toPlainString());
	}
	
	@Test
	public void testGetTotalCartValue(){
		CatalogService catalogService = CatalogService.getInstance();
		ShoppingCartService cartService = ShoppingCartService.getInstance();
		CatalogItem item = catalogService.findItemBySku("mySku1");
		CatalogItem item2 = catalogService.findItemBySku("mySku2");
		
		Cart cart = cartService.getShoppingCart("gurps");
		CartEntry cartEntry = new CartEntry(cart.getNextCartEntryId(), item,  new BigDecimal("2"));
		cartService.addProduct("gurps", cartEntry);
		
		CartEntry cartEntry2 = new CartEntry(cart.getNextCartEntryId(), item2,  new BigDecimal("1"));
		cartService.addProduct("gurps", cartEntry2);
		
		
		
		assertEquals("31.00", cart.getTotalCartValue().toPlainString());
	}
	
	@Test
	public void testCartsDontConflict(){
		CatalogService catalogService = CatalogService.getInstance();
		ShoppingCartService cartService = ShoppingCartService.getInstance();
		CatalogItem item = catalogService.findItemBySku("mySku1");
		CatalogItem item2 = catalogService.findItemBySku("mySku2");
		
		Cart cart = cartService.getShoppingCart("gurps");
		CartEntry cartEntry = new CartEntry(cart.getNextCartEntryId(), item,  new BigDecimal("2"));
		cartService.addProduct("gurps", cartEntry);
		
		Cart cart2 = cartService.getShoppingCart("gurps2");
		CartEntry cartEntry2 = new CartEntry(cart2.getNextCartEntryId(), item2,  new BigDecimal("1"));
		cartService.addProduct("gurps2", cartEntry2);
		
		
		
		
		assertEquals("20.00", cart.getTotalCartValue().toPlainString());
		assertEquals("11.00", cart2.getTotalCartValue().toPlainString());
	}
}
