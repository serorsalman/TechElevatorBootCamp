package com.techelevator.farm;

public class FarmAnimal implements Singable{
	private String name;
	private String sound;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
@Override
	public String getName() {
		return name;
	}
@Override
	public String getSound() {
		return sound;
	}

	@Override // override the object
	public String toString() {
		String output;
		output= "Name: " + name;
		output+= "\nSound: " + sound;
		return output;
		// return "Name: " + name + "\nSound: " + sound;
	}
}