package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Tutorial {
	
    public static void main(String[] args) {

    	// Step One: Declare a List
        List<String> sevenList;
        sevenList = new ArrayList<String>();

    	
    	// Step Two: Add values to a List
        sevenList.add("Ada");
        sevenList.add("Grace");
        sevenList.add("Margaret");
        sevenList.add("Adele");

    	
    	// Step Three: Looping through a List in a for loop

        for (int i = 0; i < sevenList.size(); i++) {
            System.out.println("The name at index " + i + " is " + sevenList.get(i));
        }

    	
    	// Step Four: Remove an item
        sevenList.remove("Ada");

    	
    	// Step Five: Looping through List in a for-each loop

            for (String name : sevenList) {
                System.out.println("Name: " + name);
            }

        }

    }


