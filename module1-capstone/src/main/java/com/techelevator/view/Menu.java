package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.VendingMachine;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}
	
	public void getChoiceForSpecificItem(VendingMachine vm) {
		String userInput = in.nextLine();
		String selectedOption = userInput;
		if(selectedOption.equals("0")) {
			return;
		} else if(vm.isInStock(selectedOption) && vm.canPurchase(selectedOption)) {
			System.out.println(vm.vend(selectedOption));
		} else if (!vm.isInStock(selectedOption)) {
			vm.isInStock(selectedOption);
		} else if (!vm.canPurchase(selectedOption)) {
			vm.canPurchase(selectedOption);
		} else {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}
