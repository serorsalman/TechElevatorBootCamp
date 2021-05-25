package com.techelevator;

import com.sun.source.tree.BreakTree;

public class ReserveAuction extends Auction {
    // property
    private int reservePrice;
    // constructor takes in itemForSale ( parent) and reservePrice(child)

    public ReserveAuction(String itemForSale, int reservePrice)
    {
        super(itemForSale);
        this.reservePrice=reservePrice;
    }
    /*
    Reservation needs to override the placeBid from the Auction class,
    if the offered bis does not meet or exceed the reserve price, the bid is ignored.
     */
    @Override // to make it work it has to match the name and parameter
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid= false;
        if ( offeredBid.getBidAmount()>= this.reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

}
