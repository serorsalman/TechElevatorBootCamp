-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
select film.title
from film
join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id=actor.actor_id
where actor.first_name = 'NICK'
and actor.last_name = 'STALLONE';



-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT film.title
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id= actor.actor_id
WHERE actor.first_name= 'RITA'
AND actor.last_name= 'REYNOLDS';



-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT film.title
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id= actor.actor_id

WHERE actor.last_name= 'DEAN';

-- 4. All of the the â€˜Documentaryâ€™ films
-- (68 rows)
SELECT f.title, c.name
        FROM film f
        JOIN film_category fc ON f.film_id= fc.film_id
        JOIN category c ON fc.category_id=c.category_id
        where c.name ='Documentary'
        ORDER BY f.title;


-- 5. All of the â€˜Comedyâ€™ films
-- (58 rows)
SELECT f.title, c.name
        FROM film f
        JOIN film_category fc on f.film_id = fc.film_id
        JOIN category c ON fc.category_id= c.category_id
        WHERE c.name= 'Comedy';


-- 6. All of the (Children) films that are rated (G)
-- (10 rows)
SELECT f.title, c.name, f.rating
        FROM film f
        JOIN film_category fc on f.film_id = fc.film_id
        JOIN category c ON fc.category_id= c.category_id
        WHERE c.name= 'Children'
        AND f.rating= 'G';

-- 7. All of the (Family) films that are rated (G) and are less than 2 hours in length
-- (3 rows)
SELECT f.title, c.name, f.rating, f.length
        FROM film f
        JOIN film_category fc on f.film_id = fc.film_id
        JOIN category c ON fc.category_id= c.category_id
        WHERE c.name= 'Family'
        AND f.rating= 'G'
        and f.length < 120 ;

-- 8. All of the films featuring actor Matthew Leigh that are rated (G)
-- (9 rows)
SELECT f.title, f.rating
FROM film f
JOIN film_actor ON f.film_id = film_actor.film_id
JOIN actor ON film_actor.actor_id= actor.actor_id
WHERE actor.first_name= 'MATTHEW'
AND actor.last_name= 'LEIGH'
and f.rating = 'G';

-- 9. All of the (Sci-Fi) films released in 2006
-- (61 rows)
SELECT f.title, c.name, f.release_year
        FROM film f
        JOIN film_category fc on f.film_id = fc.film_id
        JOIN category c ON fc.category_id= c.category_id
        WHERE c.name= 'Sci-Fi'
        AND f.release_year = '2006' ;

-- 10. All of the (Action) films starring Nick Stallone
-- (2 rows)
SELECT f.title, c.name, f.release_year
        FROM film f
        JOIN film_category fc on f.film_id = fc.film_id
        JOIN category c ON fc.category_id= c.category_id        
        JOIN film_actor ON f.film_id = film_actor.film_id
        JOIN actor ON film_actor.actor_id= actor.actor_id
        WHERE actor.first_name= 'NICK'
        AND actor.last_name= 'STALLONE'
        AND c.name= 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT address.address, city.city, address.district, country.country
FROM address
JOIN store ON store.store_id= address.address_id
JOIN city ON city.city_id = address.address_id
JOIN country ON city.country_id = country.country_id;


-- 12. A list of all stores by ID, the store)s street address, and the name of the store)s manager
-- (2 rows)
SELECT address.address,store.store_id, staff.first_name, staff.last_name
FROM address 
JOIN Store ON store.store_id= address.address_id
JOIN staff ON store.store_id = staff.store_id;


-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be (ELEANOR HUNTâ€? with 46 rentals, #10 should have 39 rentals)
SELECT c.first_name, c.last_name, COUNT(c.customer_id) AS num_of_rental
FROM customer c
JOIN payment p ON p.customer_id = c.customer_id
GROUP BY c.first_name, c.last_name
ORDER BY num_of_rental DESC LIMIT 10;


-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be (KARL SEALâ€? with 221.55 spent, #10 should be (ANA BRADLEYâ€? with 174.66 spent)
SELECT c.first_name, c.last_name, SUM(p.amount) AS totalpayment
FROM customer c
JOIN payment p ON p.customer_id = c.customer_id
GROUP BY c.first_name, c.last_name
ORDER BY totalpayment DESC LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT store.store_id, a.address, COUNT(r.rental_date), SUM(p.amount) AS Total_Payment, AVG(amount)
 FROM store
 JOIN address a ON a.address_id = store.address_id
 JOIN inventory i ON i.store_id = store.store_id
 JOIN rental r ON r.inventory_id = i.inventory_id
 JOIN payment p ON p.rental_id = r.rental_id
 GROUP BY store.store_id, address
 ORDER BY Total_Payment;

-- 16. The top ten film titles by number of rentals
-- (#1 should be (BUCKET BROTHERHOODâ€? with 34 rentals and #10 should have 31 rentals)
SELECT f.title , COUNT(r.*) AS toprental
FROM film f
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY f.title
ORDER BY toprental DESC LIMIT 10;

-- 17. The top five film categories by number of rentals
-- (#1 should be (Sportsâ€? with 1179 rentals and #5 should be (Familyâ€? with 1096 rentals)
SELECT c.name , COUNT(r.*) AS toprental
FROM film f
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON c.category_id = fc.category_id
GROUP BY c.name
ORDER BY toprental DESC LIMIT 5;

-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title , COUNT(r.*) AS toprental
FROM film f
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON c.category_id = fc.category_id
WHERE c.name='Action'
GROUP BY f.title
ORDER BY toprental DESC LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be (GINA DEGENERESâ€? with 753 rentals and #10 should be (SEAN GUINESSâ€? with 599 rentals)
SELECT a.first_name, a.last_name, COUNT(r.*) AS toprental
FROM actor a
JOIN film_actor fa ON fa.actor_id= a.actor_id
JOIN film f ON f.film_id = fa.film_id
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY a.actor_id, a.first_name, a.last_name
ORDER BY toprental DESC LIMIT 10;


-- 20. The top 5 (Comedyâ) actors ranked by number of rentals of films in the (Comedyâ) category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name, a.last_name, COUNT(r.*) AS toprental
FROM actor a
JOIN film_actor fa ON fa.actor_id= a.actor_id
JOIN film f ON f.film_id = fa.film_id
JOIN inventory i ON i.film_id = f.film_id
JOIN rental r ON r.inventory_id = i.inventory_id
JOIN film_category fc ON fc.film_id = f.film_id
JOIN category c ON c.category_id = fc.category_id
WHERE c.name='Comedy'
GROUP BY a.actor_id, a.first_name, a.last_name
ORDER BY toprental DESC LIMIT 5;