package com.techelevator;
public class Gum extends Items {

	public Gum(String name) {
		super(name);
	}

	String sound = "Chew Chew, Yum!";

	@Override
	public String getSound() {
		return sound;
	}
}
