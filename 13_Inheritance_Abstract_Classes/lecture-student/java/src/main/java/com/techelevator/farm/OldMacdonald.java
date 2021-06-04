package com.techelevator.farm;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OldMacdonald {
	public static void main(String[] args) {

//		Singable[] singables =
//				new Singable[] {new Cow(), new Chicken(), new Pig(), new Tractor()};
		List<FarmAnimal>animals= new ArrayList<>();

		for ( int i=0; i<8; i++){
			int random= (int)( Math.random() * 4);
			// math. random, returns a umber between 0 and 1 * 4 returns 0,1,2 or 3
			switch (random){
				case 0:// if random == 0
					animals.add(new Cow());
					animals.get(i).sleep();
					break;
				case 1:// else if random ==1
					animals.add(new Chicken());
					animals.get(i).sleep();
					break;
				case 2:
					animals.add(new Pig());
					animals.get(i).sleep();
					break;
//				case 3: // we never gonna get 4 so we dont need this one
//					animals.add(new Ostrich());
//					break;

				default:
					animals.add(new Cat());
					animals.get(i).sleep();

			}
		}
		for (Singable animal : animals) {
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