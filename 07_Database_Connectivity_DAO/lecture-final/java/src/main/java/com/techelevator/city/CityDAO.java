package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	// CRUD operations --  Create, Read, Update, Delete
	public void save(City newCity);  //Create
	public City findCityById(long id);  //Read
	public List<City> findCityByCountryCode(String countryCode);  //Read
	public List<City> findCityByDistrict(String district);  //Read
	public void update(City city);  //Update
	public void delete(long id);   // Delete
}
