package com.techelevator;

import java.util.Scanner;
/*
Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.

Please enter the Fibonacci number: 25

0, 1, 1, 2, 3, 5, 8, 13, 21
 */
public class Fibonacci {

		public static void main(String[] args) {
			int count, num1 = 0, num2 = 1;
			System.out.println("How may numbers you want in the sequence:");
			Scanner scanner = new Scanner(System.in);
			count = scanner.nextInt();
			scanner.close();
			System.out.print("Fibonacci Series of "+count+" numbers:");
			System.out.print(num1+", ");
			System.out.print(num2+" ");


			for (int i=1;i<count-1; i++)
			{
			int sumOfPrevTwo = num1 + num2;
			if ( sumOfPrevTwo <= count ){
				num1 = num2;
				num2 = sumOfPrevTwo;

				System.out.print(", " + sumOfPrevTwo);
			}

			}
		}
}