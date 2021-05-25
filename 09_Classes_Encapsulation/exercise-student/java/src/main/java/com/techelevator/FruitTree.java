package com.techelevator;

public class FruitTree {
    //Instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Constructor

    public FruitTree (String typeOfFruit,int startingPiecesOfFruit){
        this.typeOfFruit= typeOfFruit;
        this.piecesOfFruitLeft=startingPiecesOfFruit;
                    }
                    //setting getters

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }
    /*
    If there are enough pieces left on the tree, it "picks" the fruit and updates piecesOfFruitLeft by subtracting numberOfPiecesToRemove from it.
The method returns true if there were enough pieces left to pick. It returns false if no fruit was picked—that is, piecesOfFruitLeft was less than numberOfPiecesToRemove.
     */
    // create method
    public boolean pickFruit (int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }
        return false;
    }

}
