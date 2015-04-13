package com.gurps.shoppingbasket.commerce.domain;

import java.math.BigDecimal;

public class CartEntry implements CommerceItem{

	private int entryId;
	private CatalogItem catalogItem;
	
	
	private BigDecimal quantity;
	
	public CartEntry(int id, CatalogItem item, BigDecimal quantity) {
		this.catalogItem = item;
		this.quantity = quantity;
		this.entryId = id;
	}

	public int getEntryId() {
		return entryId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public CatalogItem getCatalogItem() {
		return catalogItem;
	}

	@Override
	public String getSku() {
		return catalogItem.getSku();
	}

	@Override
	public String getDescription() {
		return catalogItem.getDescription();
	}

	@Override
	public BigDecimal getPrice() {
		return catalogItem.getPrice();
	}
}
