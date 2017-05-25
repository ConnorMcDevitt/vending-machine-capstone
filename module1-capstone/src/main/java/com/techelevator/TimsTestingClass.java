package com.techelevator;

import java.io.IOException;


public class TimsTestingClass {
	
	public static void main(String[] args) throws IOException {
		
		VendingMachine vm = new VendingMachine();
		
		
		vm.refill();
		
		vm.displayItems();
		
		System.out.println(vm.isInStock("A1"));
		
		
//	
//	BigDecimal amount1 = new BigDecimal("10.00");
//	BigDecimal amount2 = new BigDecimal("15.00");
	
//	System.out.println(amount1.compareTo(amount2));

//	Logger logger = new Logger();
//	
//	logger.log("PURCHASED SOCKS", amount1, amount2);
	
	}

}
