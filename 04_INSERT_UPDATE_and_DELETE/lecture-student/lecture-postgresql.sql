-- INSERT

-- 1. Add Klingon as a spoken language in the USA
SELECT * FROM countrylanguage WHERE countrycode='USA';--just to check to see what language

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Klingon', false, 0.01); -- we got error when we run it the second time cause its already inserted 


-- 2. Add Klingon as a spoken language in Great Britain (GBR)
-- insert needs all coulumn in order to work 
SELECT * FROM countrylanguage WHERE countrycode = 'GBR';

INSERT INTO countrylanguage ( countrycode, language , isofficial, percentage)
        VALUES ('GBR', 'Klingon', false, 0.03);
, 
-- UPDATE

-- 1. Update the capital of the USA to Houston
SELECT * FROM city WHERE name='Houston';

UPDATE country
        SET capital = 3796;
        WHERE code= 'USA';
        
SELECT * FROM country WHERE code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state
 SELECT id FROM city WHERE name= 'Washington DC';

UPDATE country --update the country table 
        SET capital = (
        SELECT id FROM city WHERE name= 'Washington'-- select returns the id from the city to be loaded into country table 
        )
     WHERE code= 'USA';
     
UPDATE country 
        SET headofstate = 'Minnie Mouse'
        WHERE code = 'USA';

-- DELETE

-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage 
        WHERE countrycode= 'USA' AND language = 'English';

-- 2. Delete all occurrences of the Klingon language 

DELETE FROM countrylanguage
 WHERE language = 'Klingon';

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
INSERT INTO countrylanguage ( language)-- its not valid
        VALUES ('Elvish');
-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) --its not valid cause zzz is not there
        values('ZZZ', 'English', true, 10);
-- 3. Try deleting the country USA. What happens?
DELETE FROM country -- not allowed 
WHERE code='USA';

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO  countrylanguage (countrycode, language, isofficial, percentage)   
        VALUES ( 'USA', 'English', true, 86.2);
-- 2. Try again. What happens?
INSERT INTO  countrylanguage (countrycode, language, isofficial, percentage)   
        VALUES ( 'USA', 'English', true, 86.2);
-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country
        set continent
        WHERE code= 'USA';

-- How to view all of the constraints

SELECT pg_constraint.*
FROM pg_catalog.pg_constraint
INNER JOIN pg_catalog.pg_class ON pg_class.oid = pg_constraint.conrelid
INNER JOIN pg_catalog.pg_namespace ON pg_namespace.oid = connamespace;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
BEGIN TRANSACTION;
DELETE FROM countrylanguage;
SELECT * FROM countrylanguage;
ROLLBACK TRANSACTION;

-- 2. Try updating all of the cities to be in the USA and roll it back
START TRANSACTION;-- same as BEGIN TRANSACTION
UPDATE city SET countrycode = 'USA';

SELECT name, countrycode FROM city;
ROLLBACK; -- SAME as ROLLBACK TRANSACTION
-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.