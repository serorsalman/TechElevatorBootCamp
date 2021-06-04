package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

//		Singable[] singables =
//				new Singable[] {new Cow(), new Chicken(), new Pig(), new Tractor()};

		List<FarmAnimal> animals = new ArrayList<>();

		FarmAnimal farmAnimal = new FarmAnimal();
		for (int i = 0; i < 8; i++){
			int random = (int)(Math.random() * 4);
			// Math.random returns a number between 0 and 1 -- * 4 returns 0, 1, 2, or 3
			switch(random){
				case 0: // if random == 0, then add cow
					animals.add(new Cow());  // add a new cow object to the end of the animals List
					animals.get(i).sleep();
					break;
				case 1: // else if random == 1, then add chicken
					animals.add(new Chicken());
					animals.get(i).sleep();
					break;
				case 2:
					animals.add(new Pig());
					animals.get(i).sleep();
					break;
//				case 3:
//					animals.add(new Ostrich());
//					break;
				default:  // will handle the if choice == 3
					animals.add(new Cat());
					animals.get(i).sleep();
			}
		}
		for (FarmAnimal animal : animals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}