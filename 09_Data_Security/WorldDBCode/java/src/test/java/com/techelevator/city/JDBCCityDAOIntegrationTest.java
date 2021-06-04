package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;

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
		
		dao = new JDBCCityDAO(dataSource);

	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void save_new_city_and_read_it_back() {
		//getCity method - helper method that calls all the setters for us and returns a City object
		//Arrange
		City theCity = getCity("Stevenville", "Iowa", TEST_COUNTRY, 10);

		//Act
		dao.save(theCity); // save the city (insert) to the database
		City actualCity = dao.findCityById(theCity.getId());

		//Assert
		//  this assertCitiesAreEqual method  checks to see that all properties of the two cities are the same
		assertCitiesAreEqual(theCity, actualCity);
		Assert.assertNotNull(theCity.getId());

	}

	@Test
	public void returns_cities_by_country_code() {
		//Arrange
		City theCity = getCity("Andyberg", "Michigan", TEST_COUNTRY, 35);
		dao.save(theCity);  // insert the city first in order to test the findCityByCountryCode method

		//Act
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		//Asserts
		assertNotNull(results);  // making sure something is coming back
		assertEquals(1, results.size());  // should only have 1 city in the list
		City savedCity = results.get(0);  // returns the city that was saved to the list
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {
		dao.save(getCity("Minnie", "Florida", TEST_COUNTRY, 12000));
		dao.save(getCity("Daisy", "Florida", TEST_COUNTRY, 12000));

		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		assertNotNull(results);
		assertEquals(2, results.size());

		//can we know for a fact which city will be in position 0 in the List?
		//No, because we don't have an ORDER BY in our SQL statement
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("Mickeyville", testDistrict, TEST_COUNTRY, 10);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		// compare the two city objects calling the helper method
		assertCitiesAreEqual(theCity, results.get(0));

	}

	
	// helper methods
	/*
	 * getCity creates a java City object for us to compare with
	 */
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	/*
	 * compares the Java objects and verifies that all fields are the same
	 */
	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
