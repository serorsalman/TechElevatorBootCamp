package com.techelevator.countrylanguage;

import java.util.List;

public interface CountryLanguageDAO {

    // CRUD Create, Read, Update, Delete
    public List<CountryLanguage> getAllLanguages();
    public List<CountryLanguage> findLanguagesByCountryCode (String countrycode);
    public void addLanguage(CountryLanguage language);
    public void updateLanguage(CountryLanguage language);
    public void deleteLanguage(CountryLanguage language);
}
