package com.techelevator;
public class Drink extends Items {

	public Drink(String name) {
		super(name);
	}

	String sound = "Glug Glug, Yum!";

	@Override
	public String getSound() {
		return sound;
	}

}
