package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
	private Map<String,List<Items>> itemsInTheMachine;
	private BigDecimal availableFunds;
	
	
	public boolean isInStock(String key) {
		if (itemsInTheMachine.get(key).size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canPurchase(String key) {
		if (itemsInTheMachine.get(key).get(0).getPrice().doubleValue() > availableFunds.doubleValue()){
			return false;
		}
		
		return true;
	}
 	
	
	public void vend(String key) {
		
	
		
	}
	
	
	public BigDecimal feedMoney (BigDecimal amountInserted) {
		
		// will increase balance -- do we need validation?
		
		return null;
	}
	
	
	public void refill() {
		
		// will call importer and get a map
		
	}
	
	
	
	
	
	

}
