package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

import java.util.ArrayList;
import java.util.List;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");

		CityDAO dao = new JDBCCityDAO(worldDataSource);

		// a Java representation (object) of a city that I want to write to the database
		City daveVille = new City();
		daveVille.setCountryCode("USA");
		daveVille.setDistrict("Ohio");
		daveVille.setName("Daveville");
		daveVille.setPopulation(25);

//		dao.save(daveVille);

		List<City> cityList = dao.findCityByCountryCode("USA");
		System.out.println("Listing cities in the USA ");
		for (City city: cityList){
			System.out.println("Id: " + city.getId() + " Name: " + city.getName() + ", " + city.getDistrict());
			if (city.getName().equals("Daveville")){
				dao.delete(city.getId());
			}
		}



	}

}
