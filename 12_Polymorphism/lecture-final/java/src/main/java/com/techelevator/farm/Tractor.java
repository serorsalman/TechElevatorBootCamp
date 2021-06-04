package com.techelevator.farm;

public class Tractor implements Singable {
    @Override
    // provide the body for this method
    public String getName() {
        return "Tractor";
    }

    @Override
    public String getSound() {
        return "Vrooom";
    }
}
