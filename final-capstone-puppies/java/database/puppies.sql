drop table if exists puppies;

create table puppies (
	id serial PRIMARY KEY,
	name VARCHAR(50),
	weight INT,
	gender VARCHAR(50),
	paper_trained BOOLEAN,
	image VARCHAR (100)
);
insert into puppies (id, name, weight, gender, paper_trained, image) values (1, 'Lady', 8, 'Female', true,'https://images.dog.ceo/breeds/doberman/n02107142_3575.jpg');
insert into puppies (id, name, weight, gender, paper_trained, image)  values (2, 'Snoopy', 15, 'Male', true, 'https://images.dog.ceo/breeds/poodle-standard/n02113799_1532.jpg');
insert into puppies (id, name, weight, gender, paper_trained, image)  values (3, 'Astro', 10, 'Male', false,'https://images.dog.ceo/breeds/australian-shepherd/pepper.jpg');
insert into puppies (id, name, weight, gender, paper_trained, image)  values (4, 'Lassie', 9, 'Female', true,'https://images.dog.ceo/breeds/terrier-norwich/n02094258_366.jpg');
insert into puppies (id, name, weight, gender, paper_trained, image)  values (5, 'Clifford', 14, 'Male', false, 'https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_2678.jpg');
ALTER SEQUENCE puppies_id_seq RESTART WITH 6;
select * from puppies;
