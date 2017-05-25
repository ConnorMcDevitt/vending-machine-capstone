package com.techelevator;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ImportTest {
	
	Import sut;

	@Before
	public void setUp() throws Exception {
		sut = new Import();
		sut.readCSVFile();
		sut.createMap();
		Map<String, List<Items>> testMap = new LinkedHashMap<>();
		Chip chip = new Chip("Potato Crisps", new BigDecimal("3.05"));
		Candy candy = new Candy("Moonpie", new BigDecimal("1.80"));
		Drink drink = new Drink("Cola", new BigDecimal("1.25"));
		Gum gum = new Chip("Potato Crisps", new BigDecimal("3.05"));
		
		
		testMap.put("A1", chip);
		
		
	}

	@Test
	public void testAllComponents() {
		assertEquals()
	}

}
