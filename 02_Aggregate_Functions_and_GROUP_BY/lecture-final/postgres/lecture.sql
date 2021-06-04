-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
   FROM country
   ORDER BY population DESC
   LIMIT 10; -- OFFSET 5;  will return starting in position 6 and going to 10

--Names of countries and continents in ascending order
SELECT name, continent 
   FROM country
   ORDER BY continent, name ASC; -- don't need ASC as this is the default

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
   FROM country
   WHERE lifeexpectancy IS NOT NULL -- need this because otherwise it returned null values
   ORDER BY lifeexpectancy DESC
   LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT name || ', '|| district AS citystatename
   FROM city
   WHERE district IN ('California', 'Oregon', 'Washington')
   ORDER BY district, city.name; -- give me the name column from the city table

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy) AS "AVG Life Expectancy" FROM country;

SELECT ROUND( CAST( AVG(lifeexpectancy) AS numeric), 2) AS "AVG Life Expectancy" FROM country; -- round to two decimal places

-- Total population in Ohio
SELECT district, SUM(population)  -- display Ohio, then the sum of all populations
  FROM city                             -- from the city table
  WHERE district = 'Ohio'               -- where district is Ohio
  GROUP BY district;                    -- group by allows me to print the district name (Ohio)
  
-- The surface area of the smallest country in the world
SELECT name, surfacearea
   FROM country
   ORDER BY surfacearea LIMIT 1;
   
SELECT name, MIN(surfacearea) AS msa
   FROM country
   GROUP BY country.name 
   ORDER BY msa LIMIT 1;

-- The 10 largest countries in the world
SELECT name, surfacearea 
   FROM country
   ORDER BY surfacearea DESC
   LIMIT 10;
-- The number of countries who declared independence in 1991
SELECT COUNT(indepyear) AS "Countries indep year is 1991"
   FROM country
   WHERE indepyear = 1991;
   
-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode)
   FROM countrylanguage
   GROUP BY language             -- this gives us an English bucket, Arabic bucket, etc.
   ORDER BY COUNT(countrycode) DESC;

SELECT language, COUNT(countrycode) AS countries
   FROM countrylanguage
   GROUP BY language             -- this gives us an English bucket, Arabic bucket, etc.
   ORDER BY countries DESC;
   
-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy)
   FROM country
   GROUP BY continent -- a different bucket for each continent
   ORDER BY AVG(lifeexpectancy) DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) AS avglifeexp
   FROM country
   GROUP BY continent
   ORDER BY avglifeexp DESC NULLS LAST; -- moves the nulls to the bottom

SELECT continent, AVG(lifeexpectancy)
   FROM country
   WHERE lifeexpectancy IS NOT NULL
   GROUP BY continent
   ORDER BY AVG(lifeexpectancy) DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)  -- return 2 columns for me , state name (district) and a sum of the pop of all the cities in each district
   FROM city      -- get the info from the city table
   WHERE countrycode = 'USA'  -- only return states (districts) that are in USA
   GROUP BY district   -- give me a bucket for each state name (district)
   ORDER BY district;  -- put them in alpha order by state name (district)

-- The average population of cities in each state in the USA ordered by state name
SELECT district, ROUND(CAST(AVG(population) AS numeric), 2) AS "AVG Population"
   FROM city 
   WHERE countrycode = 'USA'
   GROUP BY district
   ORDER BY district;

-- SUBQUERIES
-- Find the names of cities under a given government leader
SELECT name, code 
   FROM country
   WHERE headofstate = 'Elisabeth II';
   
-- subquery is a query within a query
SELECT city.name, district
   FROM city
   WHERE countrycode IN
   (SELECT country.code FROM country WHERE headofstate = 'Elisabeth II'); -- this is my subquery

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT code
   FROM country 
   WHERE indepyear IS NULL;  -- returns all the code for countries who have not declared their independence yet.
 
SELECT ci.name
   FROM city AS ci
   WHERE ci.countrycode IN
   (SELECT co.code FROM country AS co WHERE co.indepyear IS NULL);

-- Additional samples
-- You may alias column and table names to be more descriptive
SELECT name AS city_name
   FROM city;

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.
SELECT c.name as "City name", co.name AS "Country name"
   FROM city AS c, country AS co;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip
SELECT name, population
   FROM city
   ORDER BY population DESC
   LIMIT 10 OFFSET 10;
   
SELECT name, population FROM city ORDER BY population DESC;

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT (name || ' is in the state of ' || district) AS city_state
FROM city
WHERE countryCode = 'USA';

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table
SELECT COUNT(name) AS city_count
FROM city;

-- Also counts the number of rows in the city table
SELECT COUNT(population)
FROM city;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population) AS total_city_population, COUNT(population) AS number_of_cities, AVG(population) AS avergage_population
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) AS smallest_population, MAX(population) AS largest_population
FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode, MIN(population), MAX(population)
FROM city
GROUP BY countrycode;