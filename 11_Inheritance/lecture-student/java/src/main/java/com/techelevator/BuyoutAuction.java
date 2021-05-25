package com.techelevator;

public class BuyoutAuction extends Auction{
    private  int buyoutPrice;
    public BuyoutAuction ( String itemForSale, int buyoutPrice){
        super(itemForSale);
        System.out.println(" In BuyoutAcution");
        this.buyoutPrice=buyoutPrice;
    }
    // need a method to specify if the paid the amount
    @Override // means we are going tp provide a new version of the parent method

    public boolean placeBid (Bid offeredBid){
        boolean isCurrentWinningBid = false;
        // if the offeredbid is greater or equal to buyoutprice this is the winning bid
        if ( offeredBid.getBidAmount()>= buyoutPrice){
            isCurrentWinningBid = super.placeBid(offeredBid);

        }// otherwise, you have just bid a normal bid
        else {
            super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }
}
