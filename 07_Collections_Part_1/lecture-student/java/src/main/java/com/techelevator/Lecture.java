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
		List <String> names = new ArrayList<>(); // right side <>, you dont have to put the data type
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Gandalf");


		System.out.println(names.size());// will tell how many elements in the list




		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for ( int i=0; i<names.size(); i ++){
			System.out.println(names.get(i)); // will print out the names in order
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		names.add("Sam");

		for ( int i=0; i<names.size(); i ++){
			System.out.println(names.get(i)); // will print out the names in order
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		names.add(3, "Bilbo");
		printList(names); //


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		names.remove(4);
		printList(names);
		System.out.println("####################");
		System.out.println("or removed by object");
		System.out.println("####################");

		names.remove("Sam");
		printList(names);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		if (names.contains("Bilbo")) {// contains is a boolean
			System.out.println("bilbo is here");
		}else{
			System.out.println("no one can find him");
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		int indexOfPippen= names.indexOf("Pippin");
		System.out.println("pippin is in the index " + indexOfPippen);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		// declare an array names.size() element
		//String[] namesArray= new String [names.size()];
		// copy them individually using a for loop or

		// example from excersize
		String[] namesArray= names.toArray(new String[0]);// copy all list items to the new array
		// cant call the print list cause its not array anymore
		for ( int i=0; i< namesArray.length; i++){
			System.out.println(namesArray[i]);
		}
		List<String> nameList= new ArrayList<>(Arrays.asList(namesArray)); // converts from array to list


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names); // this will sort element alphabetically
		printList(names);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		Collections.reverse(names);
		printList(names);


		System.out.println("####################");
		System.out.println("       FOREACH loop       ");
		System.out.println("####################");
		System.out.println();
		for ( String name:names){ // loop through the names array and put each element into var called name

			System.out.println(name);
		}
		// create an integer object
		Integer i = 10; // autoboxed--take the primitive number 10 and turn it into integer
		int i1=10; // unbox the object i into the primitive type i1


	}// end of the main method
	public static void printList(List<String> names){
		for ( int i=0; i<names.size(); i ++){
			System.out.println(names.get(i)); // will print out the names in order
		}
	}
}// end of the lecture class
