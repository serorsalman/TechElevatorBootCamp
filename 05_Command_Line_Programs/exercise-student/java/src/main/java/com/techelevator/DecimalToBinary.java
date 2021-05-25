
/*
Decimal to Binary
Write a command line program which prompts the user for a series of decimal integer values separated by spaces. Each decimal integer is displayed along with its equivalent binary value.

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		Scanner input = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");


		String decimalEntered; // setting a string
		decimalEntered = input.nextLine(); // set the value of the string
		String[] decimalSplitted = decimalEntered.split(" "); // splliting the enteries each time we see a space


		for(int i = 0;  i < decimalSplitted.length ; i++) {
			int inputDecimal = Integer.parseInt(decimalSplitted[i]); //changing the string to int (parse to int)
			System.out.print(inputDecimal + " in binary is ");// it ok to print the rest in the next line without using +

			decimalToBinary(inputDecimal);
			System.out.println(" ");// add enter to printing
		}
	}//
	public static void decimalToBinary(int inputDecimal){

		int binaryConvertion [] = new int[40];// 40 is just to set a number to prevent big numbers
		int index = 0;

		while (inputDecimal >0){

			binaryConvertion[index ++] = inputDecimal % 2 ;// count/ save how many index we have
			inputDecimal = inputDecimal / 2;
		}
		for(int i = index-1;i >= 0;i--){ // count down the print order backward
			System.out.print(binaryConvertion[i]);

		}
	}
}


