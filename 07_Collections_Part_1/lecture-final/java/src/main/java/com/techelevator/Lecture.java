package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List <String> names = new ArrayList<>();  // right side <>, you don't HAVE to put the data type
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Gandalf");

		System.out.println(names.size());  // tell me how many elements are in my list


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i)); // will print out the names in the order in which they were entered
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Sam");

		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i)); // will print out the names in the order in which they were entered
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(3, "Bilbo");

		printList(names);  // WRITING OUR OWN METHOD!!!!!  Called printList(argument is a List object)

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(4);
		printList(names);

		System.out.println("#################");
		System.out.println("Or can be removed by object (which in this case is a String)");
		System.out.println( "#################");
		names.remove("Sam");
		printList(names);

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (names.contains("Bilbo")){ // contains method is a boolean method -- means it will return true or false
			System.out.println("Bilbo is HERE!");
		} else {
			System.out.println("No one can find Bilbo");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfPippin = names.indexOf("Pippin");
		System.out.println("Pippin is in index: " + indexOfPippin);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// declare an array that holds names.size() elements
//		String[] namesArray = new String[names.size()];
		// copy them individually using a for loop OR

		String[] namesArray = names.toArray(new String[0]); // copies all List items to the array called namesArray
		for (int i = 0; i < namesArray.length; i++){
			System.out.println(namesArray[i]);
		}

		List<String> nameList = new ArrayList<>(Arrays.asList(namesArray));  // converts from array to List


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);  // this will sort element alphabetically

		// the Collections.sort is an in-memory sort (meaning it moves elements around in memory)
		// permanent sort
		printList(names);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);  // put them in reverse order (in-memory) (permanent)
		printList(names);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name: names){  // loop through the names array and put each element into var called name
			System.out.println(name);
		}


		// Create an Integer object
		Integer i = 10;  // Autoboxed automatically -- take the primitive number 10 and turn into an Integer

		int i1 = i;  // unbox the object i into the primitive type i1

		int[] intArray = new int[10];  //intArray is a reference type holding 10 primitive ints

	} // end of main method

	public static void printList(List <String> names){
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i)); // will print out the names in the order in which they were entered
		}
	}
} // end of the Lecture class
