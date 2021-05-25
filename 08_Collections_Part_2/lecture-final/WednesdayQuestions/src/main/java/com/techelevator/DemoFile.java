package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public static void main(String[] args) {
        double[] prices = new double[10];  // 10 is how many

        /*
          Show differences between for loop and forEach loop
          Show differences between array and ArrayList
          String methods
         */

        prices[2] = 4.99;
        prices[6]= 6.99;
        prices[1] = 0.99;
        prices[8] = 42.99;

        // for loop -- oldie but goodie!
        for (int i = 0; i < prices.length; i++){
            System.out.println("Index: " + i + "  value: " + prices[i]);
        }

        System.out.println("Now print using the for each loop: ");
        // for each loop - we use this to go through all elements in the array
        for(double p : prices) {  // for each p in the prices array
            System.out.println(p);
        }

        System.out.println("Only print values greater than 0: ");
        // only print out values greater than 0
        for (double p: prices){
            if (p > 0.0){
                System.out.println(p);
            }
        }

        List<Integer> ages = new ArrayList<>();
        ages.add(29);
        ages.add(39);
        ages.add(15);
        ages.add(45);

        System.out.println("Printing out values from my List: ");
        //print out all values of the List using a for loop
        for (int i = 0 ; i < ages.size(); i++){
            System.out.println(ages.get(i));
        }

        //print out values using a for each loop
        System.out.println("Using a for each loop: ");
        for (Integer a: ages){
            System.out.println(a);  // variable is the same as first part of for each loop
        }

        System.out.println("Only print ages over 29: ");
        for (Integer a: ages){
            if (a > 29){
                System.out.println(a);
            }
        }


        // when should I use an array?  when length is fixed
        // when should I use a List?  may have to drop or add an element -- dynamic
        //  command line programs -- binary one, prompt keep entering numbers until
    }
}
