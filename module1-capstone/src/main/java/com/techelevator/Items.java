package com.techelevator;

import java.math.BigDecimal;

abstract class Items {
	
	BigDecimal price;
	String itemName;
	
	public BigDecimal getPrice() {
		return price;
	}
	public String getItemName() {
		return itemName;
	}
	
	abstract public void getSound();

}
