package com.techelevator;

import java.math.BigDecimal;

public class Change {

	BigDecimal totalChange;
	
	
	public String calculateChange(BigDecimal differencePrice) {
		BigDecimal quarter = new BigDecimal(0.25);
		BigDecimal dime = new BigDecimal(0.10);
		BigDecimal nickle = new BigDecimal(0.05);
		int numQuarters=0;
		int numDimes=0;
		int numNickles=0;
		
		
		
		while (differencePrice.doubleValue() >0.00){
		if (differencePrice.doubleValue() > quarter.doubleValue()){
			differencePrice.subtract(quarter);
			numQuarters = numQuarters +1;
			
			
		} else if (differencePrice.doubleValue() > dime.doubleValue()){
			differencePrice.subtract(dime);
			numDimes = numDimes +1;
			
		} else {
			differencePrice.subtract(nickle);
			numNickles = numNickles +1;
			
		}
		}
		
		
		totalChange = new BigDecimal(numQuarters * 0.25 + numDimes * 0.10 + numNickles * 0.05);
		return "Your total change is: $" + totalChange.toString() + ": Quarters:" + numQuarters + ", Dimes:" + numDimes + ",  Nickes:" + numNickles;
	}
	

	
}
