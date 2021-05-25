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

		//Map where name is a string and zip is a string
		// Key (name) must be unique

		Map <String , String> nameToZip= new HashMap<>();
		//Loading or putting key,value pairs into our HashMap

		nameToZip.put("Bob", "34232");
		nameToZip.put("Joe", "48232");
		nameToZip.put("Jim", "56241");
		nameToZip.put("Sue", "78123");
		nameToZip.put("Ann", "43561");

		// if we Know the key, we can get the value
		System.out.println("Joe lives at " + nameToZip.get("Joe"));

		// keys have to be uniqe
		nameToZip.put("Joe", "99999");// this will overwrite the old value

		System.out.println("Joe lives at " + nameToZip.get("Joe"));

		System.out.println("############# Print out all values using KeySet ##############");
		Set<String > keys = nameToZip.keySet(); // returns a collection of all the keys in the Map ( no diplucate )

		for (String key :keys
			 ) {
			System.out.println(key + " lives at " + nameToZip.get(key));

		}
		nameToZip.remove("Sue");
		System.out.println("*********** print out all values using an entry set *****************");

		for ( Map.Entry<String, String> nameZip : nameToZip.entrySet()){
			System.out.println(nameZip.getKey() + " lives at " + nameZip.getValue());
		}
		nameToZip.put ( "Mary", null); // add a key with no value

		nameToZip.put("Tom", "44444");
		nameToZip.put("Tim", "55555");
		nameToZip.put("Jill", "44444");

		// Java is case sensitive
		System.out.println(nameToZip);
		// nametozipp with nothing after it, it is defaulting to call nametozip.tostring()
		// nameto zip.tostring() returns a string representation of the map

		if ( nameToZip.containsValue("44444")){
			System.out.println(" we have people living in 44444");
		}else {
			System.out.println(" no one lives at 44444");
		}
		nameToZip.remove("Mary");
		// let's print out only keys whose value is 44444
		int counter= 0;
		for (Map.Entry<String, String> nameZip: nameToZip.entrySet()){
			if ( nameZip.getValue().equals("44444")){
				System.out.println(nameZip.getKey() + " lives at " + nameZip.getValue());
				counter ++;
			}
		}
		System.out.println( counter + " people live at 44444");




	}

}
