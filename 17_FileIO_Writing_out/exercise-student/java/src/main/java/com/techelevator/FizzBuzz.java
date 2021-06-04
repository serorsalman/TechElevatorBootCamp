package com.techelevator;

public class FizzBuzz {
    private static String number = "0";

    public static String fizzBuzz(int inputNumber) {
        String inputAsString = Integer.toString(inputNumber);
        if ((inputNumber % 3 == 0 && inputNumber % 5 == 0)
                || (inputAsString.contains("3") && inputAsString.contains("5"))) {
            number = "FizzBuzz";
        } else if ((inputNumber % 3 == 0) || inputAsString.contains("3")) {
            number = "Fizz";
        } else if ((inputNumber % 5 == 0) || inputAsString.contains("5")) {
            number = "Buzz";
        } else {
            number = Integer.toString(inputNumber);
        }

        return number;
    }

}
