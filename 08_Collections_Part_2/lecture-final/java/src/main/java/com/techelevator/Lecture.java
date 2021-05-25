package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map where name is a String and zip is a String
		// Key (name) must be unique
		Map <String, String> nameToZip = new HashMap<>();

		// loading or putting key, value pairs into our HashMap
		nameToZip.put("Bob", "34232");
		nameToZip.put("Joe", "48232");
		nameToZip.put("Jim", "56241");
		nameToZip.put("Sue", "78123");
		nameToZip.put("Ann", "43561");


		// if I know the key, I can get the value
		System.out.println("Joe lives at " + nameToZip.get("Joe"));

		// keys have to be unique
		nameToZip.put("Joe", "99999");  // this will overwrite the old value
		System.out.println("Joe lives at " + nameToZip.get("Joe"));

		System.out.println("******************* Print out all values using a keySet *****************");
		Set<String> keys = nameToZip.keySet(); // returns a collection of all the keys in the Map

		for(String key: keys){  // for each key in my keys Set
			System.out.println(key + " lives at " + nameToZip.get(key));
		}

		nameToZip.remove("Sue");  // I don't want Sue in my map today

		System.out.println("***************  Print out all values using an Entry Set **********************");
		for(Map.Entry<String, String> nameZip : nameToZip.entrySet()){
			System.out.println(nameZip.getKey() + " lives at " + nameZip.getValue());
		}

		nameToZip.put("Mary", null);  // adds a key with no value

		nameToZip.put("Tom", "44444");
		nameToZip.put("Tim", "55555");
		nameToZip.put("Jill", "44444");

		// JAVA IS CASE-SENSITIVE -- if it looks different, it is!  Joe is not the same as joe, not same as jOe
		System.out.println(nameToZip);
		// nameToZip with nothing after it, it is defaulting to call nameToZip.toString()
		// nameToZip.toString() returns a string representation of the Map

		if (nameToZip.containsValue("44444")){
			System.out.println("We have people living in 44444");
		} else {
			System.out.println("No one lives at 44444");
		}
		nameToZip.remove("Mary");
		//let's print out only keys whose value is 44444
		int counter = 0;
		for (Map.Entry<String, String> nameZip: nameToZip.entrySet()){
			if (nameZip.getValue().equals("44444")){
				System.out.println(nameZip.getKey() + " lives at " + nameZip.getValue());
				counter++;
			}
		}
		System.out.println(counter + " people live at 44444");
	}

}
