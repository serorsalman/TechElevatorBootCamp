package com.techelevator.countrylanguage;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCCountryLanguageDAO implements CountryLanguageDAO{

    // attribute of a JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    // constructor that accepts a dataSource object as a parameter
    public JDBCCountryLanguageDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource); // connects this DAO to our database
    }

    @Override
    public List<CountryLanguage> getAllLanguages() {
        List<CountryLanguage> languageList = new ArrayList<>();
        String sqlGetAllLanguages = "SELECT countrycode, language, isofficial, percentage FROM countrylanguage";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllLanguages);
        while (results.next()){
            CountryLanguage theLanguage = mapRowToCountryLanguage(results);
            languageList.add(theLanguage);
        }
        return languageList;
    }

    @Override
    public List<CountryLanguage> findLanguagesByCountryCode(String countrycode) {
        List<CountryLanguage> languageList = new ArrayList<>();
        String sqlGetAllLanguages = "SELECT countrycode, language, isofficial, percentage " +
                "FROM countrylanguage WHERE countrycode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllLanguages, countrycode);
        while (results.next()){
            CountryLanguage theLanguage = mapRowToCountryLanguage(results);
            languageList.add(theLanguage);
        }
        return languageList;
    }

    @Override
    public void addLanguage(CountryLanguage language) {
        String sqlAddLanguage = "INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sqlAddLanguage, language.getCountrycode(),
                language.getLanguage(), language.isOfficial(), language.getPercentage());
    }

    @Override
    public void updateLanguage(CountryLanguage language) {

    }

    @Override
    public void deleteLanguage(CountryLanguage language) {

    }

    private CountryLanguage mapRowToCountryLanguage(SqlRowSet results){
        CountryLanguage language = new CountryLanguage();
        language.setCountrycode(results.getString("countrycode"));
        language.setLanguage(results.getString("language"));
        language.setOfficial(results.getBoolean("isofficial"));
        language.setPercentage(results.getDouble("percentage"));

        return language;
    }
}
