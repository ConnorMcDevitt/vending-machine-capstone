package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
	private Map<String,List<Items>> itemsInTheMachine;
	private BigDecimal availableFunds;
	
	
	public boolean isInStock(String key) {
		if (itemsInTheMachine.get(key).size() > 0) {
			System.out.println("The requested item is in stock.");
			return true;
		} else {
			System.out.println("The requested item is not in stock.");
			return false;
		}
	}

	public boolean canPurchase(String key) {
		if (itemsInTheMachine.get(key).get(0).getPrice().doubleValue() > availableFunds.doubleValue()){
			System.out.println("You cannot purchase that item.");
			return false;
		}
		
		return true;
	}
 	
	
	public void vend(String key) {
		
	
		
	}
	
	
	public void feedMoney (BigDecimal amountInserted) {
		availableFunds = availableFunds.add(amountInserted);
		System.out.println("Sucessfully inserted: $"+amountInserted.doubleValue());
	
	}
	
	
	public void refill() {
		
		// will call importer and get a map
		
	}
	
	
	
	
	
	

}
