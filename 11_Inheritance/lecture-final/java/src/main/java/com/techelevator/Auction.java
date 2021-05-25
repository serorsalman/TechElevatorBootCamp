package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0); // start with no bidder name and no bid amount
		allBids = new ArrayList<>();  // finish initialization of the ArrayList
		System.out.println("In Auction");
	}

	public boolean placeBid(Bid offeredBid) {
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
