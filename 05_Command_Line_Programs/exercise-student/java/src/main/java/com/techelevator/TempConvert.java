package com.techelevator;

import java.util.Scanner;
//Temperature conversion
//		The Fahrenheit to Celsius conversion formula is:
//
//		Tc = (Tf - 32) / 1.8
//		where 'Tc' is the temperature in Celsius, and 'Tf' is the temperature in Fahrenheit.
//
//		The Celsius to Fahrenheit conversion formula is:
//
//		Tf = Tc * 1.8 + 32
//		Write a command line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or (F)ahrenheit. Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
//
//		Please enter the temperature: 58
//		Is the temperature in (C)elsius, or (F)ahrenheit? F
//		58F is 14C.
public class TempConvert {

	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Create constant value

		double tempEntered = 0; // initiating the Variable
		String tempType = " ";

		double tempConv = 0;


		// Prompt user to enter

		System.out.print("Please enter the temperature: ");
		tempEntered = input.nextDouble(); // Setting the variable

		System.out.print(" is the temperature in (C)elsius, or (F)ahrenheit? ");

		tempType = input.next().toUpperCase(); // to convert lowercase to uppercase
		// the switch trevor's way
		// swtich is looking at the value
		switch (tempType){
			case "F":
				tempConv = (tempEntered - 32) / 1.8;
				System.out.print(tempEntered + " F " + tempConv + " C ");
				break;// stop the switch once we get our value
			// make another case for C
			case "C":
				tempConv = (tempEntered * 1.8 + 32);
				System.out.print(tempEntered + " C " + tempConv + " F ");
				break;// stop the switch once we get our value
			default:
				System.out.print("Wrong temp type was entered!!");
				break;// stop the switch once we get our value


		}

	}
}




