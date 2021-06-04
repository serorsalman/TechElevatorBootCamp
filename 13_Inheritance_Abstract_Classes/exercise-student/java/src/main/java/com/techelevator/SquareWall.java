package com.techelevator;

public class SquareWall extends RectangleWall {
    private int sideLength;



    public int getSideLength() {
        return sideLength;
    }

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength= sideLength;

    }
    @Override
    public String toString() {


        return this.getName() + " (" + this.sideLength+ "x" + this.sideLength + ")" + " square";
    }
    @Override
    public int getArea() {

        return this.sideLength * this.sideLength;
    }



}
