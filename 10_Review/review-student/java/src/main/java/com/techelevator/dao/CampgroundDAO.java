package com.techelevator.dao;

import com.techelevator.model.Campground;

import java.util.List;

public interface CampgroundDAO {

    List<Campground> getCampgroundsByParkId(int parkId);
    // lets add a campground
    Campground createNewCampground(Campground campground);

}
