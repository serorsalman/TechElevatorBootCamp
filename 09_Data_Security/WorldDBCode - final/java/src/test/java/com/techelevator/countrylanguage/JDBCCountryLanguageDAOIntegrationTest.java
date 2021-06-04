package com.techelevator.countrylanguage;

import com.techelevator.city.JDBCCityDAO;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCCountryLanguageDAOIntegrationTest {

    private static final String TEST_COUNTRY = "ZZZ";

    /* Using this particular implementation of DataSource so that
     * every database interaction is part of the same database
     * session and hence the same database transaction */
    private static SingleConnectionDataSource dataSource;
    private JDBCCountryLanguageDAO dao;

    /* Before any tests are run, this method initializes the datasource for testing. */
    // this method runs once!
    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        //  MUST HAVE THIS in order to be able to rollback!
        dataSource.setAutoCommit(false);
    }

    /* After all tests have finished running, this method will close the DataSource */
    // this method runs once at the end - after last test is run
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    /*
      run before any test methods run
     */
    @Before
    public void setup() {
        String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, "
                + "lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES "
                + "(?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, "
                + "'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);

        dao = new JDBCCountryLanguageDAO(dataSource);

    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void addLanguageAndReturn() {
        CountryLanguage language = new CountryLanguage();
        language.setCountrycode(TEST_COUNTRY);
        language.setLanguage("Margaretese");
        language.setOfficial(false);
        language.setPercentage(0.001);

        dao.addLanguage(language);  // add the language

        List<CountryLanguage> actualLanguages = dao.findLanguagesByCountryCode(TEST_COUNTRY);

        Assert.assertEquals(1, actualLanguages.size());

    }
}