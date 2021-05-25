package com.techelevator;

public class AlienDemo {

    //need a main (now this class is called an app)
    public static void main(String[] args) {
        //create an object of the Alien class
        Alien mork = new Alien();

        mork.setColor("beige");
        mork.setHasBigHead(true);
        mork.setPlanetOfOrigin("Ork");
        mork.setSpeciesName("Orkan");

        System.out.println("Alien: \n\tPlanet of Origin: " + mork.getPlanetOfOrigin());
        System.out.println("\tSpecies name: " + mork.getSpeciesName());
        System.out.println("\tColor: " + mork.getColor());
        System.out.println("\tBig Head? " + mork.getHasBigHead());
    }
}
