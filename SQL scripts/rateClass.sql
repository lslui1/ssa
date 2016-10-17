
-- drop database

	drop database if exists collegedb;
    create database collegedb;
    use collegedb;
    
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
	year int(4),
	semester int(1),
	class_rating int,
	professor_rating int,
	foreign key (login_id) references login(id),
	foreign key (class_id) references class(id)
);
create table saved_classes (
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
-- Education
INSERT class(university_id, professor_id, name, section)  VALUES(1,14,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,15,'Philosophy',501);
INSERT class(university_id, professor_id, name, section)  VALUES(1,15,'Philosophy',502);
INSERT class(university_id, professor_id, name, section)  VALUES(1,16,'Philosophy',503);
INSERT class(university_id, professor_id, name, section)  VALUES(1,16,'Philosophy',504);
INSERT class(university_id, professor_id, name, section)  VALUES(1,16,'Philosophy',505);
-- sample data: login
INSERT login(password, user_name) VALUES('password', 'user');
INSERT login(password, user_name) VALUES('password', 'user1');
INSERT login(password, user_name) VALUES('password', 'user2');
INSERT login(password, user_name) VALUES('password', 'user3');
INSERT login(password, user_name) VALUES('password', 'user4');
INSERT login(password, user_name) VALUES('password', 'user5');
INSERT login(password, user_name) VALUES('password', 'user6');



-- sample data: saved classes
INSERT saved_classes(login_id, class_id) VALUES(1,1);
INSERT saved_classes(login_id, class_id) VALUES(1,10);
INSERT saved_classes(login_id, class_id) VALUES(1,18);
INSERT saved_classes(login_id, class_id) VALUES(2,1);
INSERT saved_classes(login_id, class_id) VALUES(2,27);
INSERT saved_classes(login_id, class_id) VALUES(2,31);
INSERT saved_classes(login_id, class_id) VALUES(3,37);
INSERT saved_classes(login_id, class_id) VALUES(3,2);
INSERT saved_classes(login_id, class_id) VALUES(3,28);

-- sample data: review
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Very knowledgeable but also very, very long winded.','good class learned alot', 3, 18, '2016-10-05', 2016, 1, 3, 4);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('assigns to much work', "the subject wasn't really interesting.", 4, 27, '2016-9-27', 2016, 1, 2, 1);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Great professor!', 'My favorite class!', 3, 37, '2016-10-14', 2016, 1, 5, 5);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('The professor was O.K.', 'BORING but I learned there are 137 tiles on the ceiling.', 4, 10, '2016-2-14', 2016, 2, 1, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Good Teacher made a boring subject interesting', "didn't like the class boring subject", 5, 31, '2016-3-14', 2016, 1, 4, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Helpful professor answered any questions I had', 'good class learned alot', 6, 2, '2016-1-14', 2016, 1, 3, 5);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Really arrogant teacher not helpful', 'avoid this class it ruined my gpa', 5, 18, '2016-5-14', 2016, 1, 1, 2);
