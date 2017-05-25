package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Map<String, List<Items>> itemsInTheMachine;
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
		if (itemsInTheMachine.get(key).get(0).getPrice().doubleValue() > availableFunds.doubleValue()) {
			System.out.println("You cannot purchase that item.");
			return false;
		}

		return true;
	}

	public void vend(String key) {

		availableFunds = availableFunds.subtract(itemsInTheMachine.get(key).get(0).getPrice());
		itemsInTheMachine.get(key).remove(0);
	}

	public void feedMoney(BigDecimal amountInserted) {
		availableFunds = availableFunds.add(amountInserted);
		System.out.println("Sucessfully inserted: $" + amountInserted.doubleValue());

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

		if (itemsInTheMachine.isEmpty()) {
			System.out.println("\nThe machine is empty.\n");
			return;
		}

		for (String key : itemsInTheMachine.keySet()) {

			List<Items> slotItems = itemsInTheMachine.get(key);

			// print out only available items
			if (slotItems.size() > 0) {

				System.out.print(key + "\t");
				System.out.print(slotItems.get(0).getItemName() + "\t");
				System.out.print("(" + slotItems.size() + ")");
				System.out.println();
			}

		}
	}
}
