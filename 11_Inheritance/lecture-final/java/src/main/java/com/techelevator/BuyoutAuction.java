package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        System.out.println("In BuyoutAuction");
        this.buyoutPrice = buyoutPrice;
    }

    /*
      Override means we are going to provide
      a new version of the parent's method
      *
      If offeredBid meets or exceeds the buyoutPrice
      bid is set to buyoutPrice and all future bids are
      ignored
     */
    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        //if the offeredBid price is greater than or equal to the buyoutPrice
        // this is now the winningBid
        if(offeredBid.getBidAmount() >= buyoutPrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }  // otherwise, you have just bid a normal bid
        else {
            super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }
}
