package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;


public class TimsTestingClass {
	
	public static void main(String[] args) throws IOException {
		
		
//		BigDecimal amount1 = new BigDecimal("10.00");
//		BigDecimal amount2 = new BigDecimal("15.00");
//		BigDecimal amount3 = new BigDecimal("4.00");
//		BigDecimal amount4 = new BigDecimal("7.00");
//		
//		BigDecimal amount5 = new BigDecimal("100.00");
//		BigDecimal amount6 = new BigDecimal("100.00");
//		
//		Logger logger = new Logger();
//		logger.log("FED MONEY", amount1, amount2);
//		logger.log("Purchased something", amount3, amount4);
//		logger.log("Change Given", amount5, amount6);
		
		
		VendingMachine vm = new VendingMachine();
		
		
		vm.refill();
		
		System.out.println(vm.displayItems());
//		
//		System.out.println(vm.isInStock("A1"));
//		
//		vm.vend("A1");
//		
//		vm.displayItems();
//		
//		
//		System.out.println(vm.getAvailableFunds());
//		
//		
//		String test = "%1$18s";
//		System.out.print(String.format(test,"heyhey"));
//		System.out.print("hey");
//		
//		
//	
//	BigDecimal amount1 = new BigDecimal("10.00");
//	BigDecimal amount2 = new BigDecimal("15.00");
	
//	System.out.println(amount1.compareTo(amount2));

//	Logger logger = new Logger();
//	
//	logger.log("PURCHASED SOCKS", amount1, amount2);
	
	}

}
