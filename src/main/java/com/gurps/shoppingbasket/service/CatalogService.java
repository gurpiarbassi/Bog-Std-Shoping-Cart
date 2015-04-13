package com.gurps.shoppingbasket.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.gurps.shoppingbasket.commerce.domain.CatalogItem;

public class CatalogService {

	private static CatalogService instance;
	private List<CatalogItem> items;
	
	private CatalogService(){
		items = new ArrayList<CatalogItem>();
		items.add(new CatalogItem("mySku1", "myDesc1", new BigDecimal("10.00")));
		items.add(new CatalogItem("mySku2", "myDesc2", new BigDecimal("11.00")));
		items.add(new CatalogItem("mySku3", "myDesc3", new BigDecimal("12.00")));
		items.add(new CatalogItem("mySku4", "myDesc4", new BigDecimal("13.00")));
		items.add(new CatalogItem("mySku5", "myDesc5", new BigDecimal("14.00")));
	}
	
	public static CatalogService getInstance(){
		if(instance == null){
			instance = new CatalogService();
		}
		return instance;
	}
	
	public List<CatalogItem> getItems(){
		return items;
	}
	
	public CatalogItem findItemBySku(String sku){
		for(CatalogItem item : items){
			if(item.getSku().equals(sku)){
				return item;
			}
		}
		return null;
	}
}
