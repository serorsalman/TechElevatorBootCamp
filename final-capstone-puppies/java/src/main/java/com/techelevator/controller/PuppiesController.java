package com.techelevator.controller;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PuppyDao;
import com.techelevator.model.Puppy;

/**
 * PuppiesController
 */
/**
 * ApiController
 */
@RestController          // identifies the controller a REST api controller - can be called from web service
@RequestMapping("/api")  // Identify root path for all controllers in the - just like it did before
@CrossOrigin   
public class PuppiesController {
	
	@Autowired
	PuppyDao thePuppies;
	
	@GetMapping(path= {"/allPuppies", "/"})   // indicates this method with handle HTTP GET requests for the allPuppies
	public List<Puppy> returnPuppyData()  {
		
		logTimestamp("Getting all puppies");                                    // log time of request	
		List<Puppy> allPuppies = thePuppies.getPuppies();  // Get all puppies from data base
		
		return allPuppies;                                 // return the data requested rather than the view name
	}

	@GetMapping("/puppy/{id}")   // indicates this method with handle HTTP GET requests for the /puppy with id of Puppy to retreive
	public Puppy returnPuppyById(@PathVariable int id) {
    
		logTimestamp("Returning puppy " + id);                              // log time of request	
		
		Puppy aPuppy = thePuppies.getPuppy(id);      // Get the puppie with the supplied id from the database
		
		return aPuppy;                               // return the data requested rather than the view name
	}
	
  // indicates this method with handle HTTP Delete requests for the /remove with id of Puppy to retreive

	
	  // indicates this method with handle HTTP POST requests for the /newPuppy

  // indicates this method with handle HTTP POST requests for the /newPuppy

	
	
	static void logTimestamp(String msg) {    // log timestamp of request to Console
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());	
		System.out.println(msg + " at " + timestamp);
	}
}
