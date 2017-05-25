package com.techelevator;

import java.io.FileNotFoundException;
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
		
		Import im = new Import();
		try {
			itemsInTheMachine = im.stockMachine();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file.");
			e.printStackTrace();
		}
		
	}
	
	
	public void displayItems() {
		
		System.out.println();
		
		
		// Look at all slots, then pull out the LIST of items in each slot
		
		if(itemsInTheMachine.isEmpty()) {
			System.out.println("\nThe machine is empty.\n");
			return;
		}
		
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
