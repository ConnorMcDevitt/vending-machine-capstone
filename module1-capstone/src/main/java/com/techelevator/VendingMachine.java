package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine {

	private Map<String, List<Items>> itemsInTheMachine;
	private BigDecimal availableFunds = new BigDecimal(0);

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

	public String displayItems() {

		// Make sure the vending machine has been successfully loaded at least
		// once.

		if (itemsInTheMachine != null && itemsInTheMachine.size() != 0) {

			StringBuilder printedListOfItems = new StringBuilder();

			for (String key : itemsInTheMachine.keySet()) {

				List<Items> slotItems = itemsInTheMachine.get(key);

				// print out only available items
				if (slotItems.size() > 0) {

					String name = slotItems.get(0).getItemName();
					String price = "$" + slotItems.get(0).getPrice().toString();
					printedListOfItems.append(key + "  ");
					printedListOfItems.append(String.format("%-20s", name));
					printedListOfItems.append(String.format("%1$6s", price));
					printedListOfItems.append("  (" + slotItems.size() + ")");
					printedListOfItems.append("\n");

				}

			}

			if (!printedListOfItems.toString().equals("")) {
				return printedListOfItems.toString();
			}
		}

		return "The vending machine is empty.";
	}

	public BigDecimal getAvailableFunds() {
		return availableFunds;
	}
}
