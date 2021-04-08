package com.techelevator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner userInput = new Scanner(System.in);
        public void run () throws IOException {
            movieRenatalreader MovieReader = new movieRenatalreader();
            List<Movies> vendingList = MovieReader.inventoryImport();
        }

    }
}