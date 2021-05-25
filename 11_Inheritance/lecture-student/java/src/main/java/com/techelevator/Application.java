package com.techelevator;

import java.lang.reflect.AccessibleObject;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        System.out.println("Bidder:" + generalAuction.getHighBid().getBidder());
        System.out.println("   Amount:"+ generalAuction.getHighBid().getBidAmount());


        generalAuction.placeBid(new Bid("Fonz", 23));
        System.out.println("Bidder:" + generalAuction.getHighBid().getBidder());
        System.out.println("   Amount:"+ generalAuction.getHighBid().getBidAmount());

        generalAuction.placeBid(new Bid("Rick Astley", 13));
        System.out.println("Bidder:" + generalAuction.getHighBid().getBidder());
        System.out.println("   Amount:"+ generalAuction.getHighBid().getBidAmount());

        System.out.println( " All the bids so far: ");
        for(Bid bid: generalAuction.getAllBids()){ //returns a list
            // loop through the list of all bids
            System.out.println("Bidder: "+ bid.getBidder()+ "   Amount:" + bid.getBidAmount());
        }
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction object= new BuyoutAuction(" Favorite Green Tea Mug", 500);
        System.out.println(" created a buyout auction object");
        Bid bid = new Bid( " margaret", 10);
        object.placeBid(bid);

        System.out.println("Create a reserve auction object");
        ReserveAuction reserveAuction = new ReserveAuction("Dog Katy", 500);

        // place a bid for too little

        reserveAuction.placeBid(new Bid("Bob", 125));
        System.out.println("Is Bob's bid high enough? Name: " + reserveAuction.getHighBid().getBidder()
                + "    Amount:" + reserveAuction.getHighBid().getBidAmount());

        reserveAuction.placeBid((new Bid( " Kevin", 510)));
        System.out.println("Is Kevin's bid high enough? Name: " + reserveAuction.getHighBid().getBidder()
                + "    Amount:" + reserveAuction.getHighBid().getBidAmount());

        Auction [] auctionItems = new Auction[3];
        auctionItems [0] = new Auction(( "Red rubber ball"));
        auctionItems [ 1]= new BuyoutAuction( " Toy Truc", 2);
        auctionItems [2] = new ReserveAuction(" Blue Kite", 10);

        for (Auction auction: auctionItems){
            auction.placeBid(new Bid( "Bob", 15));
        }
        for (Auction auction: auctionItems){
            System.out.println("Items for sale: " + auction.getItemForSale() + "High Bid: "+
                    auction.getHighBid().getBidder() + " " + auction.getHighBid().getBidAmount());
        }

    }
}
