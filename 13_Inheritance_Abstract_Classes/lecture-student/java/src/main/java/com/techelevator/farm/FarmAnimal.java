package com.techelevator.farm;

public class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep= false;// default is awake
	}
	public void sleep(){
		isAsleep = true;
		sound = "Zzzzz....";
	}

	public String getName( ) {
		return name;
	}


	// the word final say no one can override
	public final String getSound (){
		return sound;
	}
	//public abstract String eat();
// every child must override this method
}