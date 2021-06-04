-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
FROM country
ORDER BY population DESC
LIMIT 10;  --OFFSET 5 will return a starting in position 6 and going


--Names of countries and continents in ascending order

SELECT name, continent
FROM country
ORDER BY continent ASC, name ASC; -- ASC is default we dont really need it 

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL -- needs this to exclude the null values 
ORDER BY lifeexpectancy DESC
limit 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
 SELECT name || ', ' || district AS citystatenames
        FROM city
        WHERE district IN ( 'California', 'Oregon', 'Washington')
        ORDER BY district, city.name; 

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT ROUND(CAST(AVG(lifeexpectancy)AS numeric),2) AS "AVG Life Axpectancy" FROM country; -- round to two decimal places 

-- Total population in Ohio
SELECT district, SUM (population) --display phio, then the sum of all population 
        FROM city               -- from the city table
        WHERE district = 'Ohio' --where district is ohio
        GROUP BY district;      -- group by allows me to print the district name(ohio)


-- The surface area of the smallest country in the world
SELECT name, surfacearea
        FROM country
        ORDER BY surfacearea LIMIT 1;
 
 SELECT name, MIN(surfacearea) AS Msa
        FROM country
        GROUP BY country.name
        ORDER BY Msa LIMIT 1; 
        

-- The 10 largest countries in the world
SELECT name, surfacearea 
        FROM country
        ORDER BY surfacearea DESC
        LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT COUNT(indepyear) AS"Countries indep year is 1991"
        FROM country
        WHERE indepyear = 1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, count(countrycode)
        FROM countrylanguage
        GROUP BY language               -- this give us an English bucket, Arabic bucket, etc.
        ORDER BY count(countrycode) DESC;
        
        -- another way
SELECT language, COUNT(countrycode) AS countries 
        FROM countrylanguage
        GROUP BY language
        ORDER BY countries DESC; 


-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG ( lifeexpectancy)
        FROM country
        GROUP BY continent 
        ORDER BY AVG(lifeexpectancy) DESC;
        
-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG ( lifeexpectancy)
        FROM country
        GROUP BY continent 
        ORDER BY AVG(lifeexpectancy) DESC NULLS LAST;-- moves null to the bottom
-- other way        

SELECT continent, AVG ( lifeexpectancy)
        FROM country
        WHERE lifeexpectancy IS NOT NULL
        GROUP BY continent 
        ORDER BY AVG(lifeexpectancy) DESC;


-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population) -- return two columns, state name (district) and sum of population of all cities in each district
        FROM city               -- get the info from city table
        WHERE countrycode= 'USA'        -- only return districts from USA
        GROUP BY district               -- give a bucket for each state name(district)
        ORDER BY district;              -- put them in alpha order by state name 
        

-- The average population of cities in each state in the USA ordered by state name
SELECT district, AVG(population) -- return two columns, state name (district) and avaerge of population of all cities in each district
        FROM city               -- get the info from city table
        WHERE countrycode= 'USA'        -- only return districts from USA
        GROUP BY district               -- give a bucket for each state name(district)
        ORDER BY district; 
        
        -- to round it this following way
        
SELECT district, ROUND(CAST(AVG(population)AS numeric), 2) AS "AVG population" -- add second AS to change the column name
        FROM city               -- get the info from city table
        WHERE countrycode= 'USA'        -- only return districts from USA
        GROUP BY district               -- give a bucket for each state name(district)
        ORDER BY district; 
        
        
        
                                                         -- SUBQUERIES
-- Find the names of cities under a given government leader
SELECT name, code
        FROM country
        WHERE headofstate = 'Elisabeth II';
        --subquery is a query within a query
        
SELECT city.name, district
       FROM city
       WHERE countrycode IN 
       (SELECT code FROM country WHERE headofstate= 'Elisabeth II'); -- this is a subquery -- code, can be written country.code

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT code 
        FROM country
        where indepyear IS NULL;-- returns all countries has not declared independence yet
        
        -- to return the names
        
 SELECT city.name, city.district, country.code
        FROM city , country
        WHERE countrycode IN
        (SELECT country.code FROM country WHERE indepyear IS NULL);
        
        -- another way list just the names
SELECT ci.name
        FROM city AS ci
        where countrycode IN
        ( SELECT country.code FROM country WHERE indepyear IS NULL);
        

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
        LIMIT 10 OFFSET 10; -- return postion 10-20 -- start at 

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

-- Gets the MIN population and the MAX population from the city table.

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
