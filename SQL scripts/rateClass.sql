
-- drop all tables

-- create the tables
create table university (
	id int primary key auto_increment,
    name varchar(30)    
);
create table professor (
	id int primary key auto_increment,
    first_name varchar(30) not null,
	last_name varchar(30) not null,
    university_id int not null,
	foreign key (university_id) references university(id)
);

create table class (
	id int primary key auto_increment,
	university_id int not null,
    professor_id int,
    name varchar(30),
    section int,
	foreign key (professor_id) references professor(id),
	foreign key (university_id) references university(id)
);
create table login (
	id int primary key auto_increment,
    password varchar(30) not null,
    user_name varchar(30) not null	
    );
create table review (
	id int primary key auto_increment,
	professor_review text,
	class_review text,
	login_id int,
	class_id int,
	review_date date,
	year int,
	semester int,
	class_rating int,
	professor_rating int,
	foreign key (login_id) references login(id),
	foreign key (class_id) references class(id)
);
create table saved_classed (
	id int primary key auto_increment,
    login_id int,
    class_id int,
    foreign key (login_id) references login(id),
	foreign key (class_id) references class(id)
);

-- University: Sample data
INSERT university(name) VALUES('Hillman College');

-- Professor: Sample data
INSERT professor(first_name,last_name,university_id) VALUES ('Joe','Downey',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Jane','Jones',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Bill','Tensi',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Sherry','Nagy',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Frank','Schell',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Michelle','Bellman',1);
INSERT professor(first_name,last_name,university_id) VALUES ('George','Hunt',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Amy','Brock',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Larry','Seger',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Kathy','Miller',1);
INSERT professor(first_name,last_name,university_id) VALUES ('John','Mills',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Lance','Cole',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Justin','Bishop',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Mark','Brenner',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Alison','Helms',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Janice','Mims',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Alice','Williams',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Karen','Smith',1);
INSERT professor(first_name,last_name,university_id) VALUES ('Shana','Lane',1);

-- CLASS: Sample data
-- English
INSERT class(university_id, professor_id, name, section)  VALUES(1,1,'English',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,1,'English',102);
INSERT class(university_id, professor_id, name, section)  VALUES(1,1,'English',103);
INSERT class(university_id, professor_id, name, section)  VALUES(1,2,'English',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,2,'English',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,2,'English',203);
INSERT class(university_id, professor_id, name, section)  VALUES(1,3,'English',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,3,'English',302);
INSERT class(university_id, professor_id, name, section)  VALUES(1,3,'English',303);
-- Math
INSERT class(university_id, professor_id, name, section)  VALUES(1,4,'Math',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,4,'Math',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,4,'Math',203);
INSERT class(university_id, professor_id, name, section)  VALUES(1,5,'Math',204);
INSERT class(university_id, professor_id, name, section)  VALUES(1,5,'Math',401);
INSERT class(university_id, professor_id, name, section)  VALUES(1,5,'Math',402);
INSERT class(university_id, professor_id, name, section)  VALUES(1,6,'Math',403);
INSERT class(university_id, professor_id, name, section)  VALUES(1,6,'Math',404);
-- History
INSERT class(university_id, professor_id, name, section)  VALUES(1,7,'History',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,7,'History',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,7,'History',301);
-- Computer Science
INSERT class(university_id, professor_id, name, section)  VALUES(1,8,'Computer Science',311);
INSERT class(university_id, professor_id, name, section)  VALUES(1,8,'Computer Science',312);
INSERT class(university_id, professor_id, name, section)  VALUES(1,8,'Computer Science',313);
INSERT class(university_id, professor_id, name, section)  VALUES(1,9,'Computer Science',441);
INSERT class(university_id, professor_id, name, section)  VALUES(1,9,'Computer Science',442);
INSERT class(university_id, professor_id, name, section)  VALUES(1,9,'Computer Science',443);
-- Psychology
INSERT class(university_id, professor_id, name, section)  VALUES(1,10,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,10,'Psychology',102);
INSERT class(university_id, professor_id, name, section)  VALUES(1,11,'Psychology',231);
INSERT class(university_id, professor_id, name, section)  VALUES(1,11,'Psychology',232);
-- Education
INSERT class(university_id, professor_id, name, section)  VALUES(1,12,'Education',221);
INSERT class(university_id, professor_id, name, section)  VALUES(1,12,'Education',222);
INSERT class(university_id, professor_id, name, section)  VALUES(1,13,'Education',223);
INSERT class(university_id, professor_id, name, section)  VALUES(1,13,'Education',351);
INSERT class(university_id, professor_id, name, section)  VALUES(1,14,'Education',352);
INSERT class(university_id, professor_id, name, section)  VALUES(1,14,'Education',353);


