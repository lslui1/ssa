
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
INSERT professor VALUES ('Joe','Downey',1);
INSERT professor VALUES ('Jane','Jones',1);
INSERT professor VALUES ('Bill','Tensi',1);
INSERT professor VALUES ('Sherry','Nagy',1);
INSERT professor VALUES ('Frank','Schell',1);
INSERT professor VALUES ('Michelle','Bellman',1);
INSERT professor VALUES ('George','Hunt',1);
INSERT professor VALUES ('Amy','Brock',1);
INSERT professor VALUES ('Larry','Seger',1);
INSERT professor VALUES ('Kathy','Miller',1);
INSERT professor VALUES ('John','Mills',1);
INSERT professor VALUES ('Lance','Cole',1);
INSERT professor VALUES ('Justin','Bishop',1);
INSERT professor VALUES ('Mark','Brenner',1);
INSERT professor VALUES ('Alison','Helms',1);
INSERT professor VALUES ('Janice','Mims',1);
INSERT professor VALUES ('Alice','Williams',1);
INSERT professor VALUES ('Karen','Smith',1);
INSERT professor VALUES ('Shana','Lane',1);

-- CLASS: Sample data
-- English
INSERT class  VALUES(1,1,'English',101);
INSERT class  VALUES(1,1,'English',102);
INSERT class  VALUES(1,1,'English',103);
INSERT class  VALUES(1,2,'English',201);
INSERT class  VALUES(1,2,'English',202);
INSERT class  VALUES(1,2,'English',203);
INSERT class  VALUES(1,3,'English',301);
INSERT class  VALUES(1,3,'English',302);
INSERT class  VALUES(1,3,'English',303);
-- Math
INSERT class  VALUES(1,4,'Math',201,50);
INSERT class  VALUES(1,4,'Math',202,NULL);
INSERT class  VALUES(1,4,'Math',203,NULL);
INSERT class  VALUES(1,5,'Math',204,NULL);
INSERT class  VALUES(1,5,'Math',401,50);
INSERT class  VALUES(1,5,'Math',402,NULL);
INSERT class  VALUES(1,6,'Math',403,NULL);
INSERT class  VALUES(1,6,'Math',404,NULL);
-- History
INSERT class  VALUES(1,7,'History',101,80);
INSERT class  VALUES(1,7,'History',201,80);
INSERT class  VALUES(1,7,'History',301,80);
-- Computer Science
INSERT class  VALUES(1,8,'Computer Science',311,40);
INSERT class  VALUES(1,8,'Computer Science',312,40);
INSERT class  VALUES(1,8,'Computer Science',313,40);
INSERT class  VALUES(1,9,'Computer Science',441,40);
INSERT class  VALUES(1,9,'Computer Science',442,40);
INSERT class  VALUES(1,9,'Computer Science',443,40);
-- Psychology
INSERT class  VALUES(1,10,'Psychology',101,20);
INSERT class  VALUES(1,10,'Psychology',102,20);
INSERT class  VALUES(1,11,'Psychology',231,20);
INSERT class  VALUES(1,11,'Psychology',232,20);
-- Education
INSERT class  VALUES(1,12,'Education',221,60);
INSERT class  VALUES(1,12,'Education',222,60);
INSERT class  VALUES(1,13,'Education',223,60);
INSERT class  VALUES(1,13,'Education',351,70);
INSERT class  VALUES(1,14,'Education',352,70);
INSERT class  VALUES(1,14,'Education',353,70);


