package com.gurps.shoppingbasket.commerce.domain;

import java.math.BigDecimal;

public interface CommerceItem {

	public abstract String getSku();

	public abstract String getDescription();

	public abstract BigDecimal getQuantity();

	public abstract BigDecimal getPrice();

}