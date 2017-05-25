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
		
		Import im = new Import();
		itemsInTheMachine = im.stockMachine();
		
	}
	
	
	public void displayItems() {
		
		System.out.println();
		
		
		// Look at all slots, then pull out the LIST of items in each slot
		
		for (String key : itemsInTheMachine.keySet()) {
			
			List<Items> slotItems = itemsInTheMachine.get(key);
			
			// print out only available items
			if(slotItems.size()>0)  {
				
				System.out.print(key + "\t");
				System.out.print(slotItems.get(0).getItemName()+"\n");
				System.out.print("(" + slotItems.size() + ")");
				
			}
			
		}
		
		
	}
	
	
	
	
	
	

}
