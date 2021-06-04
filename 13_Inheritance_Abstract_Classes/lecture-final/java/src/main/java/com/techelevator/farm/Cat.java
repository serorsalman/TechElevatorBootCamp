package com.techelevator.farm;

public final class Cat extends FarmAnimal{

    public Cat() {
        super("Cat", "Meow");
    }

//    @Override  -- doesn't compile because getSound() is final in parent
//    public String getSound(){
//        return "meow";  // our cats will always return meow
//    }
}
