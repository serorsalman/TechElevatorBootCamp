package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	//word abstract means no instances of FarmAnimals can be created
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep = false;  // default is awake
	}

	public void sleep() {
		isAsleep = true;
		sound = "Zzzzzz....";
	}

	public String getName( ) {
		return name;
	}
	// the word final say no one can override
	// means everyone (parent and children) must use this version
	public final String getSound( ) {
		return sound +"!";
	}
//	public abstract String eat(); // every child must override this method

}