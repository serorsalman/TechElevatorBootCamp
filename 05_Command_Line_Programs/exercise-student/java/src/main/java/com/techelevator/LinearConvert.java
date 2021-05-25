package com.techelevator;

import java.util.Scanner;

/*Linear conversion
Write a program that converts meters to feet and vice-versa.

The foot to meter conversion formula is:

m = f * 0.3048
The meter to foot conversion formula is:

f = m * 3.2808399
Write a command line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet. Convert the length to the opposite measurement, and display the old and new measurements to the console.

Please enter the length: 58
Is the measurement in (m)eter, or (f)eet? f
58f is 17m.
*/
public class LinearConvert {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Create constant value
        final double METERS_PER_FOOT = 0.3048;
        final double FOOT_PER_METERS = 3.2808399;
        double lengthEntered = 0; // initiating the Variable
        String distanceType = " ";

        double answerToDis = 0;


        // Prompt user to enter a number in feet

        System.out.print("Please enter a length: ");
        lengthEntered = input.nextDouble(); // Setting the variable

        System.out.print(" Please enter the measurement type, (m)eters or (f)eet: ");

        distanceType = input.next().toLowerCase(); // to convert uppercase to lowercase

        if (distanceType.equals("m")) {
            answerToDis = lengthEntered * METERS_PER_FOOT;
            System.out.print(lengthEntered + " m " + answerToDis + " f ");
        }
        else if ( distanceType.equals("f")){
        	answerToDis = lengthEntered * FOOT_PER_METERS;
			System.out.print(lengthEntered + " f " + answerToDis + " m ");

		}

    }


}

