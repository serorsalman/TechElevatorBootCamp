package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid;//type of bid
	private List<Bid> allBids; //keep track of all bid

	public Auction(String itemForSale) {// the constructor
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();// no bids yet, just have to finish the initialization of the array list
		System.out.println( "In Auction");
	}

	public boolean placeBid(Bid offeredBid) { //the method
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
