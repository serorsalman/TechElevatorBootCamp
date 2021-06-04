-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO actor ( first_name, last_name)
                VALUES ( 'Hampton' , 'Avenue');
 INSERT INTO actor ( first_name, last_name)
                VALUES ( 'Lisa' , 'Byway');
 SELECT * FROM actor;
        
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
INSERT INTO film ( title, description, release_year, language_id, length)
        VALUES ( 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece',
                2008, 1, 198);
                
                
                SELECT * FROM film where title = 'Euclidean PI';


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.-- we have to insert that row to connect them both 
INSERT INTO film_actor ( actor_id, film_id) 
        VALUES ((SELECT actor_id from actor where first_name= 'Hampton' and last_name = 'Avenue'),
                (SELECT film_id from film where title = 'Euclidean PI'));
                
INSERT INTO film_actor ( actor_id, film_id) 
        VALUES ((SELECT actor_id from actor where first_name= 'Lisa' and last_name = 'Byway'),
                (SELECT film_id from film where title = 'Euclidean PI'));             

-- 4. Add Mathmagical to the category table.
INSERT INTO category (name)
        VALUES( 'Mathmagical');
        
SELECT name from category;
        
        
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO film_category ( film_id, category_id)
        VALUES ((SELECT film_id FROM film where title = 'Euclidean PI'),(SELECT category_id FROM category where name='Mathmagical'));
INSERT INTO film_category ( film_id, category_id)
        VALUES ((SELECT film_id FROM film where title = 'EGG IGBY'),(SELECT category_id FROM category where name='Mathmagical'));
INSERT INTO film_category ( film_id, category_id)
        VALUES ((SELECT film_id FROM film where title = 'KARATE MOON'),(SELECT category_id FROM category where name='Mathmagical'));
INSERT INTO film_category ( film_id, category_id)
        VALUES ((SELECT film_id FROM film where title = 'RANDOM GO'),(SELECT category_id FROM category where name='Mathmagical'));
INSERT INTO film_category ( film_id, category_id)
        VALUES ((SELECT film_id FROM film where title = 'YOUNG LANGUAGE'),(SELECT category_id FROM category where name='Mathmagical')); 
               
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

UPDATE film
        SET rating = 'G'
        WHERE film_id IN (SELECT f.film_id from film f          --to assign the film id in the ones we need to update 
        JOIN film_category fc ON fc.film_id=f.film_id
        JOIN category c ON fc.category_id = c.category_id
        where c.name='Mathmagical');      
        

-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory ( film_id , store_id)
        VALUES ((SELECT film_id FROM film where title = 'Euclidean PI'), 1);
        
INSERT INTO inventory ( film_id , store_id)
        VALUES ((SELECT film_id FROM film where title = 'Euclidean PI'), 2);



-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE FROM film
        WHERE title = 'Euclidean PI';
        
        -- CHECKING IF STILL EXISTS 
SELECT * FROM film
        WHERE title = 'Euclidean PI';
        --NO IT DID NOT WORK, it violates the foreign key in film_actor table


DELETE FROM film
        WHERE film_id = 1001;
        --- still not working 
        

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM category 
        WHERE name= 'Mathmagical';
        -- no it did not work cause its still referenced in the film category 
DELETE FROM category WHERE category_id = 17;
-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM film_category       
        WHERE category_id= 17;
        
        -- checking 
        SELECT * from category;
         

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM category WHERE category_id = 17;
                                -- finally we can delete cause the primary key is deleted 


-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
SELECT * FROM film
        WHERE title = 'Euclidean PI';
        
        -- we need to delete the actors 
        DELETE FROM  actor
               where first_name= 'Lisa' and last_name = 'Byway';
               DELETE FROM actor
              Where first_name= 'Hampton' and last_name = 'Avenue';
               
               -- I deleted the actors
              DELETE FROM film where title = 'Euclidean PI'; -- was not deleted becuase of the film_id still conected in inventory
    
    
    DELETE FROM inventory where film_id= 1001;
    
    
     DELETE FROM film where title = 'Euclidean PI'; 

 -- FINALLY
 SELECT * FROM film where title = 'Euclidean PI';
 -- I had to delete the primary key that linked the movie in different tables in order to delete the movie 

