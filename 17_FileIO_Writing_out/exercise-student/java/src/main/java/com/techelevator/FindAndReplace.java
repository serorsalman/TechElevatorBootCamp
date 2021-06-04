package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
// scanner to ask the user
        //searches by get each line
        Scanner userInput = new Scanner(System.in);
        System.out.println(" What is the search word? ");
        String wordToBeSearched = userInput.nextLine();
        System.out.println(" What is the replacement word? ");
        String wordReplacement = userInput.nextLine();
        System.out.println("What is the source file? ");
        String srcFile = userInput.nextLine();//String object
        System.out.println(" What is the destination file? ");
        String dFile = userInput.nextLine();

        File sourceFile = new File(srcFile);//file object -thats what we need to interact
        File destFile = new File(dFile);


        try (PrintWriter writer = new PrintWriter(destFile)) {
            Scanner fileScanner = new Scanner(sourceFile);
            //to write to a file we have to have to use PrintWriter class to allow to write to the dest file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(wordToBeSearched)) {
                    line = line.replace(wordToBeSearched, wordReplacement);
                }
                writer.println(line);
                // to print the replacement word, we put it out the if,
                //even though the word wont be there we still need the word to be print in the new file
            }
            fileScanner.close();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();

        }
    }
}