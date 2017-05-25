package com.techelevator;

import java.math.BigDecimal;

public class Change {

	public String calculateChange(BigDecimal amount) {
		BigDecimal quarter = new BigDecimal(0.25);
		BigDecimal dime = new BigDecimal(0.10);
		BigDecimal nickle = new BigDecimal(0.05);
		int numQuarters=0;
		int numDimes=0;
		int numNickles=0;
		
		
		
		while (amount.doubleValue() >0.00){
		if (amount.doubleValue() > quarter.doubleValue()){
			amount.subtract(quarter);
			numQuarters = numQuarters +1;
			
			
		} else if (amount.doubleValue() > dime.doubleValue()){
			amount.subtract(dime);
			numDimes = numDimes +1;
			
		} else {
			amount.subtract(nickle);
			numNickles = numNickles +1;
			
		}
		}
		
		
		BigDecimal totalChange = new BigDecimal(numQuarters * 0.25 + numDimes * 0.10 + numNickles * 0.05);
		return "Your total change is: $" + totalChange.toString() + ": Quarters:" + numQuarters + ", Dimes:" + numDimes + ",  Nicles:" + numNickles;
	}
	

	
}
