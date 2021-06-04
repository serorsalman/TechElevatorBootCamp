package com.techelevator.farm;

public class Cow extends FarmAnimal {

    public Cow() {  // default constructor in Cow
        // still passes 2 args to the parent class
        super("Cow", "Moo");
    }

    @Override
    public String toString(){
        return "Came from cow! \n"+
                super.toString();
    }
}
