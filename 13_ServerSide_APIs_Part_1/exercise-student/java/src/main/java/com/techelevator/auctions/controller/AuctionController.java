package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "0", value = "currentBid_lte") double currentBid_lte,
                              @RequestParam(required = false, defaultValue = "", value = "title_like") String title_like) {
        if (title_like.equals("") && currentBid_lte == 0) {
            return dao.list();
        } else if (!title_like.equals("") && currentBid_lte == 0) {

            return dao.searchByTitle(title_like);
        } else if (currentBid_lte > 0 && title_like.equals("")) {
            return dao.searchByPrice(currentBid_lte);

        }
        return dao.searchByTitleAndPrice(title_like, currentBid_lte);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }
}