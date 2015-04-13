package com.gurps.shoppingbasket.commerce.domain;

import java.math.BigDecimal;

public class CatalogItem {

	private String sku;
	private String description;	
	private BigDecimal price;
	
	
	public CatalogItem(String sku, String description,
			BigDecimal price) {
		super();
		this.sku = sku;
		this.description = description;
		this.price = price;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
