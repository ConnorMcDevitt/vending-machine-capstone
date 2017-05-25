package com.techelevator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

	Logger sut;
	File logFile;
	BigDecimal bd1;
	BigDecimal bd2;
	BigDecimal bd3;
	BigDecimal bd4;
	Scanner scanner;
	
	@Before	
	public void setUp() throws Exception {
		logFile = new File("/Users/timothynevits/workspace/team6-java-module1-capstone/module1-capstone/Log.txt");
		bd1 = new BigDecimal("5.00");
		bd2 = new BigDecimal("10.00");
		bd3 = new BigDecimal("7.21");
		bd4 = new BigDecimal("12.14");
		sut = new Logger();
		if(logFile.exists()) {
			logFile.delete();
		}
		
	}


	@Test
	public void testSuccessfullyCreatesAndWritesToNewFile() throws IOException {
		sut.log("Deposit Money",bd1,bd2);
		assertTrue(logFile.exists());
		scanner = new Scanner(logFile);
		String line = scanner.nextLine();
		String expectedString = (new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())) + "\t" + "Deposit Money" + "\t" + "$" + bd1 + "\t" + "$" + bd2;
		assertEquals(expectedString,line);
		scanner.close();
		
	}
	
	
	@Test
	public void testSuccessfullyAppendsToAnExistingFile() throws IOException {
		sut.log("Deposit Money",bd1,bd2);
		sut.log("CHEESE A1", bd3, bd4);
		assertTrue(logFile.exists());
		
		scanner = new Scanner(logFile);
		
		String line = scanner.nextLine();
		String expectedString = (new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())) + "\t" + "Deposit Money" + "\t" + "$" + bd1 + "\t" + "$" + bd2;
		assertEquals(expectedString,line);
		
		String line2 = scanner.nextLine();
		String expectedString2 = (new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a").format(new java.util.Date())) + "\t" + "CHEESE A1" + "\t" + "$" + bd3 + "\t" + "$" + bd4;
		assertEquals(expectedString2,line2);
		
		scanner.close();
		
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		logFile.delete();
		scanner.close();

	}

}
