package com.techelevator;
/* show difference between for loop and for each loop
show diffrenece between array and ArrayList
String method
*/

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public static void main (String[] args){
        double [] prices = new double[10]; // 10 is how many in Array
        prices[2] =4.99;
        prices [6] = 6.99;
        prices[1] = 0.99;
        prices [8] = 42.99;

        //for loop -- oldie but goodie!

        for ( int i=0; i< prices.length; i++){
            System.out.println("index: " + i+ " Value: " + prices[i]);
        }
        System.out.println("Now print using the for each loop:"); // to visit each element in our array we use for each loop
        // for each loop
        for (double p:prices){// for each p in the prices array
            System.out.println(p);

        }
        System.out.println("Only Print values greater than 0: ");
        // only print out values greater than 0
        for ( double p:prices){
            if ( p> 0.0){
                System.out.println(p);
            }
        }
        List<Integer> ages = new ArrayList<>();// we don't need to set a size in List
        ages.add(29);
        ages.add(39);
        ages.add(15);
        ages.add(45);
        System.out.println("Printing out values from my list: ");

        // print out all values of the list using a for loop
        for ( int i=0; i<ages.size();i++){
            System.out.println(ages.get(i));
        }
        // print out values using a for each loop
        System.out.println("Using a for each loop: ");
        for (Integer a:ages){
            System.out.println(a); // variable is the same as first part of for each loop
                    }
        System.out.println("only print ages over 29 : ");
        for (Integer a: ages){
            if ( a> 29){
                System.out.println(a);
            }
        }
        // when should we use an Array? if i know how many are in the array, when length is fixed
        // when should we use a list? drop or add an element - dynamic
        // command line program



    }
}
