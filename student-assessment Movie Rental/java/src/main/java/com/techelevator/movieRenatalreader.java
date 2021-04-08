package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class movieRenatalreader {
    public List<Movies> inventoryImport() {
        File MovieCSV = new File("MovieInput.csv");
        int counter = 0;
        List<Movies> moviesList = new ArrayList<>();

        try (Scanner MovieReader = new Scanner(MovieCSV)) {

            while (MovieReader.hasNextLine()) {
                String line = MovieReader.nextLine();
                String lineArray[] = line.split("\\|");
                counter++;

                if (lineArray[2].contains("DVD")) {
                    moviesList.add(new Dvd(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[2].contains("VHS")) {
                    moviesList.add(new Vhs(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[2].contains("Blu-ray")) {
                    moviesList.add(new Bluray(lineArray[0], lineArray[1], new BigDecimal(lineArray[2])));

                }
            }
            return moviesList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return moviesList;
    }
}