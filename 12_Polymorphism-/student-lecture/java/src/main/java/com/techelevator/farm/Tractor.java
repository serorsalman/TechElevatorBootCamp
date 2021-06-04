package com.techelevator.farm;

public class Tractor implements Singable{
    @Override
    // provide the bodies for this method
    public String getName() {
        return "tractor";
    }

    @Override
    public String getSound() {
        return "Vrooom";
    }
}
