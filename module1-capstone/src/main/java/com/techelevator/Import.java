package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Import {
	
	Map<String, List<Items>> vendingMap;
	
	
	public String[] readCSVFile() throws FileNotFoundException {
		String document = "";
		String[] documentArray;
		File f = new File("vendingmachine.csv");
		try(Scanner s = new Scanner(f)) {
		    while(s.hasNextLine()) {
		        document += s.nextLine() + "\n";
		    }
		}
		documentArray = document.split("\n");
		return documentArray;
	}
	
	public void createMap(String[] documentArray) {
		Map<String, List<Items>> vendingMap = new HashMap<>();
		
		for(String element : documentArray) {
			
			String[] elementArray = element.split("|");
			String tempKey = elementArray[0];
			List<Items> tempList = new ArrayList<>();
			BigDecimal bd = new BigDecimal(elementArray[2]);
			
			if(elementArray[0].startsWith("A")) {
				
				Chip chip = new Chip(elementArray[1], bd);
				for(int i = 0; i < 5; i++) {
					tempList.add(chip);
				}
				vendingMap.put(tempKey, tempList);
				
			} else if (elementArray[0].startsWith("B")) {
				
				Candy candy = new Candy(elementArray[1], bd);
				for(int i = 0; i < 5; i++) {
					tempList.add(candy);
				}
				vendingMap.put(tempKey, tempList);
				
			} else if (elementArray[0].startsWith("C")) {
				
				Drink drink = new Drink(elementArray[1], bd);
				for(int i = 0; i < 5; i++) {
					tempList.add(drink);
				}
				vendingMap.put(tempKey, tempList);
				
			} else if (elementArray[0].startsWith("D")) {
				
				Gum gum = new Gum(elementArray[1], bd);
				for(int i = 0; i < 5; i++) {
					tempList.add(gum);
				}
				vendingMap.put(tempKey, tempList);
			}
			
			
			
			for(int i = 0; i < 5; i++) {
			}
			
		}
		this.vendingMap = vendingMap;
	}
	

	
	//Goes through each specific item in the machine and sets the length of its list to 5 and then returns a map (aligning with its key).
	public Map<String, List<Items>> stockMachine() {
		return vendingMap;
	}
}
