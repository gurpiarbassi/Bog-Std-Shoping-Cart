package com.gurps.shoppingbasket.commerce.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gurps.shoppingbasket.commerce.domain.CatalogItem;
import com.gurps.shoppingbasket.service.CatalogService;

public class TestCatalog {

	@Test
	public void testGetItems() {
		CatalogService catalogService = CatalogService.getInstance();
		
		assertEquals(5,catalogService.getItems().size());
		
		CatalogItem item = catalogService.getItems().get(0);
		assertEquals("mySku1", item.getSku());
		assertEquals("myDesc1", item.getDescription());
		assertEquals("10.00", item.getPrice().toPlainString());
	}
}
