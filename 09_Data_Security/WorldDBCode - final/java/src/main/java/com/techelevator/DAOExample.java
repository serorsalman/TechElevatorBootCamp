package com.techelevator;

import com.techelevator.countrylanguage.CountryLanguage;
import com.techelevator.countrylanguage.CountryLanguageDAO;
import com.techelevator.countrylanguage.JDBCCountryLanguageDAO;
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

        //programming to the interface!
        CountryLanguageDAO countryLanguageDao =
                new JDBCCountryLanguageDAO(worldDataSource);

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

        List<CountryLanguage> languageList = countryLanguageDao.getAllLanguages();
        System.out.println("Displaying all languages ************************");
        for (CountryLanguage language : languageList){
            System.out.println("Country Code: " + language.getCountrycode() + " Language: " +
                    language.getLanguage());
        }

        CountryLanguage pigLatin = new CountryLanguage();
        pigLatin.setCountrycode("USA");
        pigLatin.setLanguage("Pig Latin");
        pigLatin.setOfficial(false);
        pigLatin.setPercentage(0.000001);

        //addLanguage doesn't return anything
//        countryLanguageDao.addLanguage(pigLatin);

        List<CountryLanguage> languageListForUsa =
                countryLanguageDao.findLanguagesByCountryCode("USA");
        System.out.println("Displaying all languages for USA ************************");
        for (CountryLanguage language : languageListForUsa){
            System.out.println("Country Code: " + language.getCountrycode() + " Language: " +
                    language.getLanguage());
        }

    }

}