package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

    public static void main(String[] args) {

        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("What is the destination file?");
            String filePath = userInput.nextLine();

            FizzWriter(filePath);
        }
    }

    private static void FizzWriter(String filePath) {
        File fizzBuzzFile = new File(filePath);// created file path for the object

        try (PrintWriter fileOutput = new PrintWriter(fizzBuzzFile)) {
            for (int i = 1; i <= 300; i++) {
                if (i % 5 == 0 &&
                        i % 3 == 0) {
                    fileOutput.println("FizzBuzz");
                } else if (i % 3 == 0 || (i / 10) % 10 == 3 || ((i % 10) == 3) || (i / 10) == 3 || (i / 100) == 3) {
                    fileOutput.println("Fizz");
                } else if (i % 5 == 0 || (i / 10) % 10 == 5 || (i / 10) == 5) {
                    fileOutput.println("Buzz");
                } else {
                    fileOutput.println(i);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}