package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald {
	public static void main(String[] args) {
// initiealize the array with these object
		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(),new Goat(),
		new Pig(), new Ostrich()};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println(farmAnimals[0].toString());
			// the .toString is the default if you dont call specific method
		}
			System.out.println(farmAnimals[0]);
			List <Singable> singables = new ArrayList<>();
			singables.add(new Goat());
			singables.add(new Tractor());
			singables.add(new Cow());

			for ( Singable singable: singables){
				String name = singable.getName();
				String sound = singable.getSound();
				System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
				System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
				System.out.println("With a " + sound + " " + sound + " here");
				System.out.println("And a " + sound + " " + sound + " there");
				System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
				System.out.println(farmAnimals[0].toString());

			}
		Scanner input = new Scanner(System.in);

		System.out.println(" What you would like to purchase : ");
		System.out.println("1. Chicken");
		System.out.println("2. Apple");
		System.out.println("Enter your choice");
		int choice = Integer.parseInt(input.nextLine());
		if ( choice ==1){
			Chicken chicken = new Chicken();
			System.out.println("A Chicken costs " + chicken.getPrice() );
		} else { // assume they want apples
			Apple apple = new Apple();
			System.out.println("Each apple costs: " + apple.getPrice());
			System.out.println("How many you would like to purchase? ");
			int count = Integer.parseInt(input.nextLine());
			BigDecimal price = apple.getPrice();
			BigDecimal cost = price.multiply(new BigDecimal(count));

			System.out.println(" the total cost is " + cost);
		}


	}
}