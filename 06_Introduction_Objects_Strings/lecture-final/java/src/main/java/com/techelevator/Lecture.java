package com.techelevator;

import java.util.Arrays;
import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		int[] myArray = new int[10];
		Arrays.fill(myArray, 42);  // val: is from IntelliJ -- DON'T TYPE IT!!!
		// Arrays.fill initializes each element to 42 in the array
//		System.out.println(myArray);  -- prints out hex address of where myArray is stored in heap
		System.out.println(Arrays.toString(myArray));

		int[] newArray = Arrays.copyOf(myArray, 5);  // copy the first 5 elements from myArray into newArray
		System.out.println("new array: " + Arrays.toString(newArray));

		newArray[1] = 13;
		newArray[2] = 3;
		newArray[3] = 7;
		newArray[4] = 39;
		// now, newArray will hold 42, 13, 3, 7, 39
		System.out.println("newArray now is: " + Arrays.toString(newArray));

		Arrays.sort(newArray);  // sorts the array in ascending order
		System.out.println("newArray after the sort: " + Arrays.toString(newArray));

		if (Arrays.equals(myArray, newArray)){
			System.out.println("Arrays are equal to each other");
		} else {
			System.out.println("Arrays are not equal to each other");
		}


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greeting = "Hello, World!";
		System.out.println("greeting: " + greeting);

		String name = "Margaret";
		String name2 = new String("Margaret");  // declares a new string in another spot

		if (name == name2) {  // compare values in the stack, not the heap
			System.out.println("Names are Equal");
		} else {
			System.out.println("Names are not Equal");
		}

		if (name.equals(name2)) { // compares what is in the heap
			System.out.println("Names are Equal");
		} else {
			System.out.println("Names are Not Equal");
		}

		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		System.out.println("*************charAt****************");
		// greeting = "Hello, World!"
		char first = greeting.charAt(0); // 'H'
		char seven = greeting.charAt(7); //'W'

		System.out.println(first);
		System.out.println(seven);

		// count how many o's there are in the string
		int count = 0;
		for (int i = 0 ; i < greeting.length(); i++){
			if (greeting.charAt(i) == 'o'){
				count++;  // add one to count
			}
		}
		System.out.println("There are " + count + " o's in the string " + greeting);

		boolean containsWorld = greeting.contains("World");
		System.out.println("contains the word world: " + containsWorld);

		containsWorld = greeting.toLowerCase().contains("world");
		System.out.println("contains world without matching case: " + containsWorld);

		String subStr = greeting.substring(0, 5);
		System.out.println(subStr);
		subStr = greeting.substring(7);
		System.out.println(subStr);

		String firstName = "Margaret";  // firstName in the stack points to a location in the heap hold "Margaret"
		firstName = "Bob";  //firstName in the stack now points to a different location in the heap holding "Bob"

		String upperFirstName = firstName.toUpperCase();

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		String newStr= null;  // means variable is in the stack but doesn't reference any spot in the heap

		if (newStr == null){
			System.out.println("newStr is null");
		}

		newStr = "";  // references a spot in the heap
		if (newStr == null){
			System.out.println("newStr is null");
		} else {
			System.out.println("newStr is empty");
		}


		char[] helloArray = {'H', 'e','l','l','o'};  // character array is different than a string
		String hello1 = new String(helloArray);  // holds the address of the character array stored in heap
		String hello2 = new String(helloArray); // holds the address of the character array stored in heap
		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

//		 So, to compare the values of two objects, we need to use the equals method.
//		 * Every object type has an equals method
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}
	}
}
