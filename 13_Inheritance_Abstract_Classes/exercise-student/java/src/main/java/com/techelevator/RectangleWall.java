package com.techelevator;

public class RectangleWall extends Wall{
    private int length;//properties of the class
    private int height;

    public RectangleWall(String name, String color) {
        super(name, color);
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.height=height;
        this.length= length;
    }

    @Override
    public String toString() {


        return this.getName() + " (" + this.length + "x" + this.height + ")" + " rectangle";
    }



    @Override
    public int getArea() {

        return this.height * this.length;
    }

}
