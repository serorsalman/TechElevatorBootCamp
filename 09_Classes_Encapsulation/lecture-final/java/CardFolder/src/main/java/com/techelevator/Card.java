package com.techelevator;

// template for all Cards
public class Card {

    // data members declared at top
    private String suit;
    private char rank;
    private boolean faceDown;

    // default constructor because it has no params
    public Card(){

    }

    // Construct a card object and set the suit, rank and faceDown properties using the parameter passed in
    public Card(String suit, char rank, boolean faceDown){
        this.suit = suit;
        this.rank = rank;
        this.faceDown = faceDown;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }
}
