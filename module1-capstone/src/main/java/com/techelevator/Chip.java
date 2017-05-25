package com.techelevator;

public class Chip extends Items {

	public Chip(String name) {
		super(name);
	}

	String sound = "Crunch Crunch, Yum!";

	@Override
	public String getSound() {
		return sound;
	}

}
