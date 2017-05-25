package com.techelevator;

public class Candy extends Items {

	public Candy(String name) {
		super(name);
	}

	String sound = "Munch Munch, Yum!";

	@Override
	public String getSound() {
		return sound;
	}

}
