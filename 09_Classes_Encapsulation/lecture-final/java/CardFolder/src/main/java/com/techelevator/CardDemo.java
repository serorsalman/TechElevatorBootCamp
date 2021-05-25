package com.techelevator;

public class CardDemo {

    public static void main(String[] args) {

        // create 3 card objects
        Card card1 = new Card();
        Card card2 = new Card("Hearts", '4', false);
        Card card3 = new Card("Clubs", 'K', true);

        card1.setSuit("Spades");
        card1.setRank('A');
        card1.setFaceDown(true);

        System.out.println("Card1: " + card1.getSuit());
        System.out.println(card1.getRank());
        System.out.println(card1.isFaceDown());

        System.out.println("Card2: " + card2.getSuit());
        System.out.println(card2.getRank());
        System.out.println(card2.isFaceDown());

        System.out.println("Card3: " + card3.getSuit());
        System.out.println(card3.getRank());
        System.out.println(card3.isFaceDown());

    }
}
