package com.techelevator;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ImportTest {
	
	Import sut;
	Map<String, List<Items>> testMap;

	@Before
	public void setUp() throws Exception {
		sut = new Import();
		sut.readCSVFile();
		sut.createMap();
		testMap = new LinkedHashMap<>();
		List<Items> chipList = new ArrayList<>();
		List<Items> candyList = new ArrayList<>();
		List<Items> drinkList = new ArrayList<>();
		List<Items> gumList = new ArrayList<>();
		Chip chip = new Chip("Potato Crisps", new BigDecimal("3.05"));
		Candy candy = new Candy("Moonpie", new BigDecimal("1.80"));
		Drink drink = new Drink("Cola", new BigDecimal("1.25"));
		Gum gum = new Gum("U-Chews", new BigDecimal("0.85"));
		
		for(int i = 0; i < 5; i++) {
			chipList.add(chip);
			candyList.add(candy);
			drinkList.add(drink);
			gumList.add(gum);
		}
		
		testMap.put("A1", chipList);
		testMap.put("B1", candyList);
		testMap.put("C1", drinkList);
		testMap.put("D1", gumList);
		
	}
	
	@Test
	public void testAllComponents() throws FileNotFoundException {
		assertEquals
	}

}
