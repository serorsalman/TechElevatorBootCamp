BEGIN TRANSACTION;

CREATE TABLE depertments
        (
        dep_id serial,
        name varchar(64) NOT NULL,
        
        CONSTRAINT pk_departments_id PRIMARY KEY (dep_id)
        );
        
CREATE TABLE job_titles 
        (
        job_id serial,
        title varchar(64) NOT NULL,
        
        CONSTRAINT pk_job_titles_id PRIMARY KEY (job_id)
        );
             
CREATE TABLE employees 
        (
        employee_id serial,
        job_titles_id int  NOT NULL,
        last_name varchar(64) NOT NULL,
        first_name varchar(64) NOT NULL,
        gender char(6),
        birth_day date,
        hire_day date  NOT NULL,
        dep_id integer  NOT NULL,
     
        
        CONSTRAINT pk_employee_id PRIMARY KEY ( employee_id),
        CONSTRAINT fk_dep_id FOREIGN KEY (dep_id) REFERENCES depertments (dep_id),
        CONSTRAINT fk_job_titles_id FOREIGN KEY (job_titles_id) REFERENCES job_titles (job_id)
        );
        
CREATE TABLE projects 
        (
        projects_id serial,
        name varchar(64) NOT NULL,
        employee_id int NOT NULL,
        start_date date NOT NULL,
         
         CONSTRAINT pk_project_id PRIMARY KEY (projects_id),
         CONSTRAINT fk_employee_id FOREIGN KEY ( employee_id) REFERENCES employees (employee_id)
         );
         
 INSERT INTO depertments (name) VALUES ('HR');
 INSERT INTO depertments (name) VALUES ('Finance'); 
 INSERT INTO depertments (name) VALUES ('Project Management');
 INSERT INTO depertments (name) VALUES ('Reasearch and Development');
 
 
 INSERT INTO job_titles (title) VALUES ('Director');
 INSERT INTO job_titles (title) VALUES ('Manager');
 INSERT INTO job_titles (title) VALUES ('Associate');
 INSERT INTO job_titles (title) VALUES ('Developer');
 
 
 INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Adam','Weaver','2001-01-01',4,1);
 
INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Adesuwa','Osagie','2002-01-01',4,3);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Alice','Ellison','2003-01-01',3,3);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Anita','Sirchia','2004-01-01',3,2);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Corrin','Scriber','2005-01-01',2,4);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Dave','HOY','2006-01-01',2,3);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Steven','Penn','2007-01-01',1,4);

INSERT INTO employees (first_name,last_name,hire_day,dep_id,job_titles_id) VALUES ('Josh','Peplow','2008-01-01',1,1); 




INSERT INTO projects (name,employee_id,start_date) VALUES ('Vending machine',6,'2013-06-10');

INSERT INTO projects (name,employee_id,start_date) VALUES ('Checking account',9,'2011-09-10');

INSERT INTO projects (name,employee_id,start_date) VALUES ('Animal farm',7,'2009-06-11');

INSERT INTO projects (name,employee_id,start_date) VALUES ('Movie rental',8,'2017-08-10');


SELECT * FROM job_titles;
SELECT * FROM depertments;
SELECT * FROM employees;
SELECT * FROM projects;

 ROLLBACK;
 
 COMMIT;        
         
        
        