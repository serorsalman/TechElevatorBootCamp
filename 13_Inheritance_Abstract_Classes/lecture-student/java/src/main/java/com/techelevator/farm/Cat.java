package com.techelevator.farm;

public class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "Meow");
    }

//    @Override =--- doesn't compile because getSound() is final in parent level
//    public String getSound() {
//        return "Meow";// our cats will always return meow
//    }
}
