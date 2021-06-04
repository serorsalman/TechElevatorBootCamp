package com.techelevator.farm;

import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald {
    public static void main(String[] args) {
        // initialize the array with these objects
        FarmAnimal[] farmAnimals = new FarmAnimal[]{new Cow(), new Chicken(), new Goat(),
                new Pig(), new Ostrich()};

        for (FarmAnimal animal : farmAnimals) {
            String name = animal.getName();
            String sound = animal.getSound();
            System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
            System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
            System.out.println("With a " + sound + " " + sound + " here");
            System.out.println("And a " + sound + " " + sound + " there");
            System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
            System.out.println();
        }
        System.out.println(farmAnimals[0].toString());
        // the .toString() is the default if you don't call specific method
        System.out.println(farmAnimals[0]);

        System.out.println(farmAnimals[1]);

        //FarmAnimal farmAnimal = new FarmAnimal();
        // Programing to an interface!!!
        List<Singable> singables = new ArrayList<>();
        singables.add(new Goat());
        singables.add(new Tractor());
        singables.add(new Cow());

        for (Singable singable : singables) {
            String name = singable.getName();
            String sound = singable.getSound();
            System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
            System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
            System.out.println("With a " + sound + " " + sound + " here");
            System.out.println("And a " + sound + " " + sound + " there");
            System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
            System.out.println();
        }

        Singable tractor = new Tractor();

        Scanner input = new Scanner(System.in);  // allows user input
        System.out.println("What would you like to purchase?");
        System.out.println("1. Chicken");
        System.out.println("2. Apple");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 1){
            Chicken chicken = new Chicken();
            System.out.println("A chicken costs " + chicken.getPrice());
        } else {  // assume they want apples
            Apple apple = new Apple();
            System.out.println("Each apple costs " + apple.getPrice());
            System.out.println("How many would you like to purchase? ");
            int count = Integer.parseInt(input.nextLine());
            BigDecimal price = apple.getPrice();
            BigDecimal cost = price.multiply(new BigDecimal(count));
            System.out.println("The cost is " + cost);
        }

     //   Sellable sellable = new Sellable(); NO objects of interfaces!!
    }
}