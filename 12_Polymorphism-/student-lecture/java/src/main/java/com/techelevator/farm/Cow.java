package com.techelevator.farm;

public class Cow extends FarmAnimal {
    public Cow() { // default constructor in cow
        // still posses 2 arg to the parent class

        super("Cow", "Moo");
    }

    @Override
    public String toString() {
        return "Came from Cow! \n" + super.toString();
    }
}
