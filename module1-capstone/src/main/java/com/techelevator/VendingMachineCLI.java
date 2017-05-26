package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_BUY_ITEM = "Buy Item";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[]PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_BUY_ITEM, 
														PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String FEED_MENU_OPTION_ONE = "$1.00";
	private static final String FEED_MENU_OPTION_TWO = "$2.00";
	private static final String FEED_MENU_OPTION_FIVE = "$5.00";
	private static final String FEED_MENU_OPTION_TEN = "$10.00";
	private static final String FEED_MENU_OPTION_EXIT = "Go Back";
	private static final String[] FEED_MENU_OPTIONS = { FEED_MENU_OPTION_ONE, FEED_MENU_OPTION_TWO, 
														FEED_MENU_OPTION_FIVE, FEED_MENU_OPTION_TEN, FEED_MENU_OPTION_EXIT };
	
	private Menu menu;
	private VendingMachine vm;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		vm.refill();
		//Original menu.
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.displayItems();
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					System.out.println("Current Balance is $" + vm.getAvailableFunds());
					String purchaseChoice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						//Feed Money Menu
						while(true) {
							System.out.println("Current Balance is $" + vm.getAvailableFunds());
							String feedChoice = (String)menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
							
							if(feedChoice.equals(FEED_MENU_OPTION_EXIT)) {
								break;
							}
							vm.feedMoney(new BigDecimal(feedChoice));
						}
					} else if(purchaseChoice.equals(PURCHASE_MENU_OPTION_BUY_ITEM)) {
						System.out.println("Current Balance is $" + vm.getAvailableFunds());
						System.out.println(vm.displayItems());
						System.out.println("Please enter your selection or enter 0 to exit: ");
						menu.getChoiceForSpecificItem(vm);
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
