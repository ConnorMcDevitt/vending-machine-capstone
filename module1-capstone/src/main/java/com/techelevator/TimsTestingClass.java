package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;

public class TimsTestingClass {
	
	public static void main(String[] args) throws IOException {
	
	BigDecimal amount1 = new BigDecimal("10.00");
	BigDecimal amount2 = new BigDecimal("15.00");
	
	Logger logger = new Logger();
	
	logger.log("PURCHASED SOCKS", amount1, amount2);
	
	}

}
