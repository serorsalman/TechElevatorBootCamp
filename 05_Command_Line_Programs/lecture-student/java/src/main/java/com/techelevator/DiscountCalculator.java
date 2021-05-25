package com.techelevator;


import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);// create a scanner object and ties it to the keyboard


        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
                   String discountStr =userInput.nextLine();//saves what the uesr has typed in into the discountStr
                   double discount= Double.parseDouble(discountStr) / 100; // convert it to a percent



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String prices = userInput.nextLine();


         String[] priceArray =prices.split(" "); // split will split apart the string and return [ ]
        for (int i=0; i < priceArray.length; i++){
            double originalPrice= Double.parseDouble(priceArray[i]);
            // lets calculate the discount amount
            double discountAmount = originalPrice * discount; // how much the discount amount will be
            double salesPrice= originalPrice - discountAmount ; // this is the sales price
            System.out.println( "Original price: " + originalPrice + "  Sales price: " + salesPrice);

        }
        userInput.close(); // breaks the connection between program and keyboard


    }

}