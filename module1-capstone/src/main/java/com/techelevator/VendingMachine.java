package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
	private Map<String,List<Items>> itemsInTheMachine;
	private BigDecimal availableFunds;
	
	
	public boolean isInStock(String key) {
		
		return false;
	}
	
	
	public boolean canPurchase(String key) {
		
		
		return false;
	}
 	
	
	public void vend(String key) {
		
		// will decrease available funds
		
	}
	
	
	public BigDecimal feedMoney (BigDecimal amountInserted) {
		
		// will increase balance -- do we need validation?
		
		return null;
	}
	
	
	public void refill() {
		
		// will call importer and get a map
		
	}
	
	
	
	
	
	

}
