BEGIN TRANSACTION;


CREATE TABLE customer
(
    customer_id serial, 
    name varchar(64) NOT NULL,
    address varchar(100) NOT NULL,
    phone varchar(16),
    
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

COMMIT TRANSACTION;

CREATE TABLE artist
(
    artist_id serial,
    name varchar(64) NOT NULL,
    
    CONSTRAINT pk_artist PRIMARY KEY (artist_id)
);

CREATE TABLE art
(
    art_id serial,
    title varchar(100),
    artist_id int NOT NULL,
    
    CONSTRAINT pk_art PRIMARY KEY (art_id),
    -- fk_art_artist -- this is just a name for postgres
    -- FOREIGN KEY means we are setting up a foreign key from this table (art) to another table (artist)
    -- (artist_id) refers to the art table column name
    -- REFERENCES -- going to tell psql what the other table is for the fk references
    -- artist -- table
    -- (artist_id) -- column in the artist table that IS the foreign key
    CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id) 
 );
 
 CREATE TABLE customer_purchase
 (
    purchase_id serial,
    customer_id INT NOT NULL, -- want this to reference the customer table
    art_id int NOT NULL,  -- want this to the art table
    transation_date timestamp NOT NULL,
    price money NOT NULL,
    
    CONSTRAINT pk_purchase PRIMARY KEY (purchase_id),
    CONSTRAINT fk_customer_purchase_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    CONSTRAINT fk_customer_purchase_art FOREIGN KEY (art_id) REFERENCES art (art_id)
 );
    
 