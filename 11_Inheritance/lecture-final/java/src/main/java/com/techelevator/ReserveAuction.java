package com.techelevator;

public class ReserveAuction extends Auction {
    // property
    private int reservePrice;

    // constructor takes in itemForSale (parent) and reservePrice(child)
    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    /*
    ReserveAuction needs to override the placeBid from the Auction
    class.

    If the offered bid does not meet or exceed the reserve price,
    the bid is ignored.
     */
    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= this.reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;

    }
}
