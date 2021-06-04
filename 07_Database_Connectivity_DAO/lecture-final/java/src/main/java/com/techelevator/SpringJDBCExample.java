package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdStoreDataSource = new BasicDataSource();
		dvdStoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		//object BasicDataSource
		// method setUrl(" jdbc connectivity
		// postgresql is the type of database
		// localhost means on local machine (vs. internet connection)
		// 5432 -- port that postgres is running on
		// /dvdstore -- name of the database we are connecting to
		dvdStoreDataSource.setUsername("postgres");
		dvdStoreDataSource.setPassword("postgres1");

		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdStoreDataSource);
				// JdbcTemplate constructor needs a datasource passed to it

		String sqlFilmsByReleaseYear2006 = "SELECT * FROM film WHERE release_year = 2006 LIMIT 10";
		// string of my sql statement (just like we would type in DBV)

		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByReleaseYear2006);
		// SqlRowSet is the class and we create an object called results
		// results will hold the rows that come back from the query to the database
		// dvdstoreJdbcTemplate.queryForRowSet() is what sends the sql statement to the db and returns the rows
		while(results.next()){
			String filmTitle = results.getString("title");
			// create a string var called film title
			// call the SqlRowSet object  (results) and call the getString method on that object
			// parameter for getString is the postgres column name "title"
			int releaseYr = results.getInt("release_year");
			String rating = results.getString("rating");
			System.out.println(filmTitle + " (" + releaseYr + ")  - " + rating);
		}

		
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String category = "Comedy";
		String sqlFilmsByCategory = "SELECT film.title, film.release_year " +
				    "FROM film JOIN film_category ON film.film_id = film_category.film_id " +
				     "JOIN category ON category.category_id = film_category.category_id " +
				     " WHERE category.name = ?";  // question mark is a placeholder for a variable
		
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */

		results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);
		System.out.println("****  Films of the category " + category + " ***********");
		while (results.next()){
			String filmTitle = results.getString("title");
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle + " (" + releaseYear + ") ");
		}
		
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor (actor_id, first_name, last_name) " +
				"VALUES ( ?, ?, ?)";  // don't need a ; in the sql because JdbcTemplate will add for you

//		dvdstoreJdbcTemplate.update(sqlCreateActor,1000, "Minnie", "Mouse");
		// this line can only run once (can only INSERT once)
		
		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);
		
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);
		// SqlRowSet object results will hold what comes back from the sql query

		// move the cursor to the beginning of the set -- in this situation there is only one row coming back
		results.next();  // this points the cursor at the one piece of data coming back

		int id = results.getInt(1);  // returns the next city_id
		System.out.println("Next city_id available is " + id);


		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) " +
				"VALUES(?, ?, ?, ?, ?)";
		worldJdbcTemplate.update(sqlCreateNewCity, id, "Smallville", "USA", "Kansas", 45001);

	}
}
