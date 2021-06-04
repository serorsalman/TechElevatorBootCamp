package com.techelevator;

public abstract class Wall {
    private String name;
    private String color;

    //all children class MUST provide the body ( fulfill the contract
    public abstract int getArea(); // only the head, no body

    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
