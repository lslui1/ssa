
-- drop database

	drop database if exists collegedb;
    create database collegedb;
    use collegedb;
    
-- create the tables
create table university (
	id int primary key auto_increment,
    name varchar(30)    
);
create table  professor(
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
ALTER TABLE `professor` 
ADD UNIQUE INDEX `ix_professor` (`first_name`, `last_name`, `university_id`);
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
insert professor(first_name, last_name, university_id) values ('Billy', 'Jackson', 1);
insert professor(first_name, last_name, university_id) values ('Phyllis', 'Turner', 1);
insert professor(first_name, last_name, university_id) values ('Susan', 'Cole', 1);
insert professor(first_name, last_name, university_id) values ('Wanda', 'Brooks', 1);
insert professor(first_name, last_name, university_id) values ('Johnny', 'Cooper', 1);
insert professor(first_name, last_name, university_id) values ('Roger', 'Howell', 1);
insert professor(first_name, last_name, university_id) values ('Marilyn', 'Reynolds', 1);
insert professor(first_name, last_name, university_id) values ('Anne', 'Fernandez', 1);
insert professor(first_name, last_name, university_id) values ('Nicholas', 'Lane', 1);
insert professor(first_name, last_name, university_id) values ('Todd', 'Washington', 1);
insert professor(first_name, last_name, university_id) values ('Brian', 'Hanson', 1);
insert professor(first_name, last_name, university_id) values ('Gregory', 'Palmer', 1);
insert professor(first_name, last_name, university_id) values ('Jeffrey', 'Meyer', 1);
insert professor(first_name, last_name, university_id) values ('Marie', 'Williamson', 1);
insert professor(first_name, last_name, university_id) values ('Theresa', 'Garcia', 1);
insert professor(first_name, last_name, university_id) values ('Russell', 'Thompson', 1);
insert professor(first_name, last_name, university_id) values ('Benjamin', 'Hansen', 1);
insert professor(first_name, last_name, university_id) values ('Deborah', 'Miller', 1);
insert professor(first_name, last_name, university_id) values ('Linda', 'Dixon', 1);
insert professor(first_name, last_name, university_id) values ('Ruby', 'Diaz', 1);
insert professor(first_name, last_name, university_id) values ('Donna', 'Reed', 1);
insert professor(first_name, last_name, university_id) values ('Terry', 'Tucker', 1);
insert professor(first_name, last_name, university_id) values ('Andrea', 'Carpenter', 1);
insert professor(first_name, last_name, university_id) values ('James', 'Nichols', 1);
insert professor(first_name, last_name, university_id) values ('Craig', 'Henderson', 1);
insert professor(first_name, last_name, university_id) values ('Jeffrey', 'Perez', 1);
insert professor(first_name, last_name, university_id) values ('Jennifer', 'Arnold', 1);
insert professor(first_name, last_name, university_id) values ('Russell', 'Weaver', 1);
insert professor(first_name, last_name, university_id) values ('Bobby', 'Long', 1);
insert professor(first_name, last_name, university_id) values ('Betty', 'Lawrence', 1);
insert professor(first_name, last_name, university_id) values ('David', 'Martin', 1);
insert professor(first_name, last_name, university_id) values ('Terry', 'Peters', 1);
insert professor(first_name, last_name, university_id) values ('Ann', 'Richardson', 1);
insert professor(first_name, last_name, university_id) values ('Ryan', 'Pierce', 1);
insert professor(first_name, last_name, university_id) values ('Albert', 'Meyer', 1);
insert professor(first_name, last_name, university_id) values ('Kenneth', 'Cole', 1);
insert professor(first_name, last_name, university_id) values ('Beverly', 'Diaz', 1);
insert professor(first_name, last_name, university_id) values ('Martin', 'Ford', 1);
insert professor(first_name, last_name, university_id) values ('Harry', 'Lane', 1);
insert professor(first_name, last_name, university_id) values ('Dorothy', 'Williamson', 1);
insert professor(first_name, last_name, university_id) values ('Julie', 'Grant', 1);
insert professor(first_name, last_name, university_id) values ('Rose', 'Meyer', 1);
insert professor(first_name, last_name, university_id) values ('Jonathan', 'West', 1);
insert professor(first_name, last_name, university_id) values ('Bonnie', 'Warren', 1);
insert professor(first_name, last_name, university_id) values ('Shirley', 'Ward', 1);
insert professor(first_name, last_name, university_id) values ('Amy', 'Ramirez', 1);
insert professor(first_name, last_name, university_id) values ('Steven', 'Garrett', 1);
insert professor(first_name, last_name, university_id) values ('Christopher', 'Fields', 1);
insert professor(first_name, last_name, university_id) values ('Rebecca', 'Burton', 1);
insert professor(first_name, last_name, university_id) values ('George', 'Owens', 1);
insert professor(first_name, last_name, university_id) values ('Irene', 'Little', 1);
insert professor(first_name, last_name, university_id) values ('Elizabeth', 'Diaz', 1);
insert professor(first_name, last_name, university_id) values ('Marie', 'Burns', 1);
insert professor(first_name, last_name, university_id) values ('Clarence', 'Roberts', 1);
insert professor(first_name, last_name, university_id) values ('Julie', 'Ruiz', 1);
insert professor(first_name, last_name, university_id) values ('Nancy', 'Moreno', 1);
insert professor(first_name, last_name, university_id) values ('Emily', 'Coleman', 1);
insert professor(first_name, last_name, university_id) values ('Benjamin', 'Reid', 1);
insert professor(first_name, last_name, university_id) values ('Steve', 'Hill', 1);
insert professor(first_name, last_name, university_id) values ('Joyce', 'Gonzalez', 1);
insert professor(first_name, last_name, university_id) values ('John', 'Morrison', 1);
insert professor(first_name, last_name, university_id) values ('Thomas', 'Reid', 1);
insert professor(first_name, last_name, university_id) values ('Judy', 'Harvey', 1);
insert professor(first_name, last_name, university_id) values ('Melissa', 'Howell', 1);
insert professor(first_name, last_name, university_id) values ('Philip', 'Cox', 1);
insert professor(first_name, last_name, university_id) values ('Bonnie', 'Chavez', 1);
insert professor(first_name, last_name, university_id) values ('Diana', 'Snyder', 1);
insert professor(first_name, last_name, university_id) values ('Amanda', 'Mccoy', 1);
insert professor(first_name, last_name, university_id) values ('Craig', 'Dixon', 1);
insert professor(first_name, last_name, university_id) values ('Adam', 'Bell', 1);
insert professor(first_name, last_name, university_id) values ('Paul', 'Thomas', 1);
insert professor(first_name, last_name, university_id) values ('Carol', 'Scott', 1);
insert professor(first_name, last_name, university_id) values ('Susan', 'Harris', 1);
insert professor(first_name, last_name, university_id) values ('Brandon', 'Gutierrez', 1);
insert professor(first_name, last_name, university_id) values ('Jimmy', 'Perkins', 1);
insert professor(first_name, last_name, university_id) values ('Nicholas', 'Harrison', 1);
insert professor(first_name, last_name, university_id) values ('Cheryl', 'Andrews', 1);
insert professor(first_name, last_name, university_id) values ('Douglas', 'Garrett', 1);
insert professor(first_name, last_name, university_id) values ('Melissa', 'Richardson', 1);
insert professor(first_name, last_name, university_id) values ('Phyllis', 'Lee', 1);
insert professor(first_name, last_name, university_id) values ('Douglas', 'Cook', 1);
insert professor(first_name, last_name, university_id) values ('Patrick', 'Chavez', 1);
insert professor(first_name, last_name, university_id) values ('Roy', 'Jones', 1);
insert professor(first_name, last_name, university_id) values ('Joyce', 'Murray', 1);
insert professor(first_name, last_name, university_id) values ('Jean', 'Kennedy', 1);
insert professor(first_name, last_name, university_id) values ('Willie', 'Hunter', 1);
insert professor(first_name, last_name, university_id) values ('Catherine', 'Butler', 1);
insert professor(first_name, last_name, university_id) values ('Kelly', 'Bradley', 1);
insert professor(first_name, last_name, university_id) values ('Frank', 'Cook', 1);
insert professor(first_name, last_name, university_id) values ('Jacqueline', 'Collins', 1);
insert professor(first_name, last_name, university_id) values ('Virginia', 'Wood', 1);
insert professor(first_name, last_name, university_id) values ('Catherine', 'Wilson', 1);
insert professor(first_name, last_name, university_id) values ('Tina', 'Price', 1);
insert professor(first_name, last_name, university_id) values ('Irene', 'Hunt', 1);
insert professor(first_name, last_name, university_id) values ('Andrea', 'Banks', 1);
insert professor(first_name, last_name, university_id) values ('Shirley', 'Johnston', 1);
insert professor(first_name, last_name, university_id) values ('Stephanie', 'Shaw', 1);
insert professor(first_name, last_name, university_id) values ('Catherine', 'Phillips', 1);
insert professor(first_name, last_name, university_id) values ('Antonio', 'Fox', 1);
insert professor(first_name, last_name, university_id) values ('Sean', 'Howard', 1);


-- CLASS: Sample data
-- English
INSERT class(university_id, professor_id, name, section)  VALUES(1,1,'English',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,2,'English',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,3,'English',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,4,'English',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,2,'English',102);
INSERT class(university_id, professor_id, name, section)  VALUES(1,3,'English',103);
INSERT class(university_id, professor_id, name, section)  VALUES(1,4,'English',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,5,'English',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,6,'English',203);
INSERT class(university_id, professor_id, name, section)  VALUES(1,7,'English',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,8,'English',302);
INSERT class(university_id, professor_id, name, section)  VALUES(1,9,'English',303);
-- Math
INSERT class(university_id, professor_id, name, section)  VALUES(1,10,'Math',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,11,'Math',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,12,'Math',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,13,'Math',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,11,'Math',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,12,'Math',203);
INSERT class(university_id, professor_id, name, section)  VALUES(1,13,'Math',204);
INSERT class(university_id, professor_id, name, section)  VALUES(1,14,'Math',401);
INSERT class(university_id, professor_id, name, section)  VALUES(1,15,'Math',402);
INSERT class(university_id, professor_id, name, section)  VALUES(1,16,'Math',403);
INSERT class(university_id, professor_id, name, section)  VALUES(1,17,'Math',404);
-- History
INSERT class(university_id, professor_id, name, section)  VALUES(1,19,'History',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,20,'History',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,21,'History',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,22,'History',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,24,'History',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,20,'History',301);
-- Computer Science
INSERT class(university_id, professor_id, name, section)  VALUES(1,21,'Computer Science',311);
INSERT class(university_id, professor_id, name, section)  VALUES(1,22,'Computer Science',312);
INSERT class(university_id, professor_id, name, section)  VALUES(1,23,'Computer Science',313);
INSERT class(university_id, professor_id, name, section)  VALUES(1,24,'Computer Science',441);
INSERT class(university_id, professor_id, name, section)  VALUES(1,25,'Computer Science',442);
INSERT class(university_id, professor_id, name, section)  VALUES(1,26,'Computer Science',443);
-- Psychology
INSERT class(university_id, professor_id, name, section)  VALUES(1,27,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,28,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,29,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,30,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,31,'Psychology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,28,'Psychology',102);
INSERT class(university_id, professor_id, name, section)  VALUES(1,29,'Psychology',231);
INSERT class(university_id, professor_id, name, section)  VALUES(1,30,'Psychology',232);
-- Education
INSERT class(university_id, professor_id, name, section)  VALUES(1,31,'Education',221);
INSERT class(university_id, professor_id, name, section)  VALUES(1,32,'Education',222);
INSERT class(university_id, professor_id, name, section)  VALUES(1,33,'Education',223);
INSERT class(university_id, professor_id, name, section)  VALUES(1,34,'Education',351);
INSERT class(university_id, professor_id, name, section)  VALUES(1,35,'Education',352);
INSERT class(university_id, professor_id, name, section)  VALUES(1,36,'Education',353);
-- Education
INSERT class(university_id, professor_id, name, section)  VALUES(1,37,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,38,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,39,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,40,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,41,'Philosophy',500);
INSERT class(university_id, professor_id, name, section)  VALUES(1,38,'Philosophy',501);
INSERT class(university_id, professor_id, name, section)  VALUES(1,39,'Philosophy',502);
INSERT class(university_id, professor_id, name, section)  VALUES(1,40,'Philosophy',503);
INSERT class(university_id, professor_id, name, section)  VALUES(1,41,'Philosophy',504);
INSERT class(university_id, professor_id, name, section)  VALUES(1,42,'Philosophy',505);
-- Speech
INSERT class(university_id, professor_id, name, section)  VALUES(1,43,'Speech',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,44,'Speech',102);
INSERT class(university_id, professor_id, name, section)  VALUES(1,45,'Speech',103);
INSERT class(university_id, professor_id, name, section)  VALUES(1,46,'Speech',201);
INSERT class(university_id, professor_id, name, section)  VALUES(1,47,'Speech',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,48,'Speech',203);
-- Spanish
INSERT class(university_id, professor_id, name, section)  VALUES(1,49,'Spanish',700);
INSERT class(university_id, professor_id, name, section)  VALUES(1,50,'Spanish',701);
INSERT class(university_id, professor_id, name, section)  VALUES(1,51,'Spanish',702);
INSERT class(university_id, professor_id, name, section)  VALUES(1,52,'Spanish',703);
INSERT class(university_id, professor_id, name, section)  VALUES(1,53,'Spanish',704);
INSERT class(university_id, professor_id, name, section)  VALUES(1,54,'Spanish',705);
-- German
INSERT class(university_id, professor_id, name, section)  VALUES(1,55,'German',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,56,'German',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,57,'German',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,58,'German',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,59,'German',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,60,'German',201);
-- French
INSERT class(university_id, professor_id, name, section)  VALUES(1,70,'French',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,71,'French',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,72,'French',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,73,'French',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,74,'French',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,75,'French',203);
-- Engineering
INSERT class(university_id, professor_id, name, section)  VALUES(1,76,'Engineering',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,77,'Engineering',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,78,'Engineering',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,79,'Engineering',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,80,'Engineering',301);
INSERT class(university_id, professor_id, name, section)  VALUES(1,81,'Engineering',303);
-- Anthropology
INSERT class(university_id, professor_id, name, section)  VALUES(1,82,'Anthropology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,83,'Anthropology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,84,'Anthropology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,85,'Anthropology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,86,'Anthropology',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,87,'Anthropology',203);
-- Political Science
INSERT class(university_id, professor_id, name, section)  VALUES(1,88,'Political Science',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,89,'Political Science',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,90,'Political Science',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,91,'Political Science',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,92,'Political Science',202);
INSERT class(university_id, professor_id, name, section)  VALUES(1,93,'Political Science',203);
-- Communication
INSERT class(university_id, professor_id, name, section)  VALUES(1,94,'Communication',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,95,'Communication',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,96,'Communication',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,97,'Communication',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,98,'Communication',101);
INSERT class(university_id, professor_id, name, section)  VALUES(1,99,'Communication',203);
-- sample data: login
INSERT login(password, user_name) VALUES('password', 'user');
INSERT login(password, user_name) VALUES('password', 'user1');
INSERT login(password, user_name) VALUES('password', 'user2');
INSERT login(password, user_name) VALUES('password', 'user3');
INSERT login(password, user_name) VALUES('password', 'user4');
INSERT login(password, user_name) VALUES('password', 'user5');
INSERT login(password, user_name) VALUES('password', 'user6');
INSERT login(password, user_name) VALUES('password', 'user7');
INSERT login(password, user_name) VALUES('password', 'user8');
INSERT login(password, user_name) VALUES('password', 'user9');
INSERT login(password, user_name) VALUES('password', 'user10');
INSERT login(password, user_name) VALUES('password', 'user11');
INSERT login(password, user_name) VALUES('password', 'user12');
INSERT login(password, user_name) VALUES('password', 'user13');
INSERT login(password, user_name) VALUES('password', 'user14');
INSERT login(password, user_name) VALUES('password', 'user15');
INSERT login(password, user_name) VALUES('password', 'user16');
INSERT login(password, user_name) VALUES('password', 'user17');
INSERT login(password, user_name) VALUES('password', 'user18');
INSERT login(password, user_name) VALUES('password', 'user19');
INSERT login(password, user_name) VALUES('password', 'user20');
INSERT login(password, user_name) VALUES('password', 'user21');
INSERT login(password, user_name) VALUES('password', 'user22');
INSERT login(password, user_name) VALUES('password', 'user23');
INSERT login(password, user_name) VALUES('password', 'user24');
INSERT login(password, user_name) VALUES('password', 'user25');
INSERT login(password, user_name) VALUES('password', 'user26');
INSERT login(password, user_name) VALUES('password', 'user27');
INSERT login(password, user_name) VALUES('password', 'user28');
INSERT login(password, user_name) VALUES('password', 'user29');
INSERT login(password, user_name) VALUES('password', 'user30');
INSERT login(password, user_name) VALUES('password', 'user31');
INSERT login(password, user_name) VALUES('password', 'user32');
INSERT login(password, user_name) VALUES('password', 'user33');
INSERT login(password, user_name) VALUES('password', 'user34');
INSERT login(password, user_name) VALUES('password', 'user35');
INSERT login(password, user_name) VALUES('password', 'user36');
INSERT login(password, user_name) VALUES('password', 'user37');
INSERT login(password, user_name) VALUES('password', 'user38');
INSERT login(password, user_name) VALUES('password', 'user39');
INSERT login(password, user_name) VALUES('password', 'user40');
INSERT login(password, user_name) VALUES('password', 'user41');
INSERT login(password, user_name) VALUES('password', 'user42');
INSERT login(password, user_name) VALUES('password', 'user43');
INSERT login(password, user_name) VALUES('password', 'user44');
INSERT login(password, user_name) VALUES('password', 'user45');
INSERT login(password, user_name) VALUES('password', 'user46');
INSERT login(password, user_name) VALUES('password', 'user47');
INSERT login(password, user_name) VALUES('password', 'user48');
INSERT login(password, user_name) VALUES('password', 'user49');


-- sample data: saved classes
INSERT saved_classes(login_id, class_id) VALUES(1,1);
INSERT saved_classes(login_id, class_id) VALUES(1,18);
INSERT saved_classes(login_id, class_id) VALUES(1,27);
INSERT saved_classes(login_id, class_id) VALUES(1,10);
INSERT saved_classes(login_id, class_id) VALUES(1,37);
INSERT saved_classes(login_id, class_id) VALUES(2,1);
INSERT saved_classes(login_id, class_id) VALUES(2,27);
INSERT saved_classes(login_id, class_id) VALUES(2,31);
INSERT saved_classes(login_id, class_id) VALUES(3,37);
INSERT saved_classes(login_id, class_id) VALUES(3,2);
INSERT saved_classes(login_id, class_id) VALUES(3,28);

-- sample data: review
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Very knowledgeable but also very, very long winded.','good class learned alot', 3, 1, '2016-10-05', 2016, 1, 5, 5);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Lectures are long you may get lost if you have a hard time concentrating.','Interesting class', 4, 1, '2016-10-03', 2016, 1, 3, 2);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('lectures the entire time, barely gives any notes, and his syllabus is useless','Wish I never took this class', 5, 1, '2016-10-22', 2016, 1, 2, 1);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ("he's boring and he cant help it, he runs off on tangents with that reminds me of the time", 'learned alot in this class', 6, 1, '2016-10-13', 2016, 1, 3, 2);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('boring but fair grader.','decent class', 7, 1, '2016-10-09', 2016, 1, 3, 4);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('assigns to much work', "the subject wasn't really interesting.", 4, 2, '2016-9-27', 2016, 1, 2, 1);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('sometimes does not know how to explain very clearly', "the subject wasn't really interesting.", 5, 2, '2016-9-27', 2016, 1, 3, 2);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('very boring and is always sweating', "alright class.", 6, 2, '2016-9-27', 2016, 1, 2, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ("horrible teacher didn't learn anything", "learned absolutely nothing.", 3, 2, '2016-9-27', 2016, 1, 2, 2);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ("doesn't care about students", 'Avoid at all costs.', 7, 2, '2016-9-27', 2016, 1, 1, 1);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('The professor was O.K.', 'BORING but I learned there are 137 tiles on the ceiling.', 4, 3, '2016-2-14', 2016, 2, 1, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Good Teacher made a boring subject interesting', "didn't like the class boring subject", 5, 3, '2016-3-14', 2016, 1, 4, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Helpful professor answered any questions I had', 'good class learned alot', 6, 3, '2016-1-14', 2016, 1, 3, 5);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Really arrogant teacher not helpful', 'avoid this class it ruined my gpa', 5, 3, '2016-5-14', 2016, 1, 1, 2);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Great professor!', 'class is so much fun and you learn things that are both useful and fascinating', 3, 3, '2016-10-14', 2016, 1, 5, 5);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('One of the best professors here', 'easy class', 4, 4, '2016-10-10', 2016, 1, 4, 4);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Awesome teacher', "Honestly, I didn't know what to expect from this class, but it was a really great class and well taught.", 5, 4, '2016-10-11', 2016, 1, 5, 4);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('Great professor!', 'My favorite class!', 6, 4, '2016-10-17', 2016, 1, 5, 3);
INSERT review(professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) VALUES ('You have to study for his tests but the questions are crystal clear. He made me enjoy my least favorite subject.', 'Okay class', 7, 4, '2016-10-12', 2016, 1, 3, 5);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ('extremely straight forward and  is always available to talk after class. Gives you the powerpoints ahead of time, which you can print out and bring to class, so the note taking became easier', 'fairly easy. pay attention and take notes and you will do fine', 50, 13, '2016-06-14', 2016, 1, 3, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Worst teacher at the school, doesn't prepare for lectures or knows what he's talking about ", "I hated this class DO NOT TAKE IT!", 50, 13, '2016-06-14', 2016, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ('very helpful really willing to work with students who are having trouble keeping up with ', "class was I little too boring for my taste", 26, 13, '2016-07-23', 2016, 1, 5, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ('BEST PROFESSOR EVER. take him every chance you get', "One of the hardest classes I've taken in college don't take it unless you want to spend all your time studying for one class", 4, 13, '2016-06-17', 2016, 1, 5, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Gives you all the notes and powerpoints, you don't need to take notes in class. Gives you review sheets which is very similar to the quizzes. A few papers. He's very understanding, lets you take make-up quizzes. This sem, we voted on a take home final too.", "if you attend class its an automatic A. i can gurantee it (cue trump voice).", 19, 13, '2016-01-23', 2016, 1, 5, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("best professor you will take at this school", "I was really disappointed with this course, because we haven't discussed half of the stuff that was on the Syllabus", 24, 15, '2016-09-25', 2016, 1, 4, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("OMG, he is the worst professor ever. MONOTONE, puts 70% class to sleep, even those who's eyes are open are sleeping", "boring class, but not too hard", 20, 15, '2016-03-16', 2016, 1, 2, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("As long as you go to class regularly and have a pulse you should pass this class with at least a B. Fair and an easy grader.", "Attendance not mandatory, however, class notes can be important (especially for the bonus questions on the exams), class participation is highly reccomened, (sit in the front) and make sure you do the extra credit term paper.", 5, 15, '2016-07-27', 2016, 1, 4, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Will literally refuse to help you if you ask him...seriously, no joke this guy is a total jerk. I don't know what his problem is, but he takes it out on his students. Avoiding him is not only good for you GPA, but also for your mental wellbeing.", "this class just simply sucks!", 10, 15, '2016-09-08', 2016, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Great professor! Try talking to him like i did to get on his good side. He was very hard for me at first; i struggled however near the end you will find this class so worth it. Im telling you. Stick with him! DO NOT DROP. Be ontime to class i swear one minute late he will not collect your assignments. My A was hard earned, but it was worth it!", "hard class really stressed me out in the beginning", 42, 15, '2016-10-15', 2016, 1, 4, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Really unhelpful professor", "One of my most boring classes", 39, 16, '2016-01-05', 2016, 1, 2, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("This class isn't too hard ", "lectures are clear and informative. We did not actually complete all the material. If you are taking the course because you want to learn more about the material rather than just have a teacher speed through the course then you'll like this professor.", 36, 16, '2016-05-06', 2016, 1, 3, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Glad I had this professor he was pretty, helpful.", "I enjoyed this course learned so much that I didn't know", 44, 16, '2016-03-16', 2016, 1, 4, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ('Good professor.. He will pass you. He tells funny stories every class, If u can take him.', "There's not one day that i do not look forward to this class", 40, 16, '2016-04-13', 2016, 1, 4, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("The #1 professor in the country... wait, the world. Just take him and see for yourself.", "This class makes you want to learn and know more about the subject. You'll get an A as long as you come to class and do the work.", 13, 16, '2016-01-12', 2016, 1, 5, 5);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Learned a lot. Really knows the textbook, also allows you to do an extra credit assignment online for the course of the class", "Textbook required but I only used it to help me with extra credit. If you can take notes fast, no need to crack open the textbook", 23, 24, '2016-10-06', 2016, 1, 3, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("The material is not hard. Prior knowledge is very helpful.", " Lectures are all about talking and students taking notes. Tests are average, if you read the textbook you should do good, also curves a lot.", 11, 24, '2016-08-24', 2016, 1, 4, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Requires a lot of studying.", " Very knowledgeable about the subject and all the tests are multiple choice!", 19, 24, '2016-03-27', 2016, 1, 1, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("One very easy semester project which helped bring me from a C to a B+. If you show that you care about your grade, you should be fine.", "a bit unorganized,and tends to ramble sometimes but other then that extremely knowledgable and passionate", 47, 24, '2016-06-15', 2016, 1, 3, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("quizzes are straight forward and easy.", "THE BEST PROFESSOR HANDS DOWN", 21, 24, '2016-08-14', 2016, 1, 3, 5);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 39, 1, '2013-01-05', 2013, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 36, 1, '2013-02-06', 2013, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 44, 1, '2013-03-16', 2013, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 40, 1, '2013-04-13', 2013, 2, 2, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 13, 1, '2013-05-12', 2013, 2, 3, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 23, 1, '2013-06-06', 2013, 2, 3, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 11, 1, '2014-01-24', 2014, 1, 3, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 19, 1, '2014-02-27', 2014, 1, 2, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 47, 1, '2014-03-15', 2014, 1, 3, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 21, 1, '2014-04-14', 2014, 2, 3, 3);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 39, 1, '2014-05-05', 2014, 2, 3, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 36, 1, '2014-05-16', 2014, 2, 3, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 44, 1, '2014-01-16', 2015, 1, 4, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 40, 1, '2014-02-13', 2015, 1, 3, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 13, 1, '2014-03-12', 2015, 1, 4, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 23, 1, '2015-03-26', 2015, 2, 3, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 11, 1, '2015-04-24', 2015, 2, 4, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 19, 1, '2016-03-27', 2016, 1, 5, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 47, 1, '2016-05-15', 2016, 1, 4, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values (null, null, 21, 1, '2016-05-20', 2016, 2, 5, 5);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("basically does whatever he wants and if he doesn't like you, good luck getting higher than a C", "AVOID AT ALL COSTS", 39, 25, '2016-05-23', 2016, 1, 1, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Grade based on tests and they're really simple.", "Great class", 22, 25, '2016-01-14', 2016, 1, 5, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("barely answers your emails or questions directly", "Don't take this class if you value your GPA", 36, 25, '2016-04-24', 2016, 1, 2, 2);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Without a doubt one of the best professors", "Not my favorite class but it's okay", 1, 25, '2016-10-12', 2016, 1, 3, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("has a wealth of information, but lacks the ability to convey it", "Liked the subject just wish I had a different teacher", 38, 25, '2016-03-02', 2016, 1, 3, 2);

insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Hands down my favorite professor, I've had in College", "One of the better classes I've taken here.", 3, 26, '2016-05-03', 2016, 1, 4, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("REALLY MEAN! but knows the material", "Lifelong skills especially in future working opportunities are acquired in class.", 44, 26, '2016-03-27', 2016, 1, 2, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("good teacher", "good class", 26, 26, '2016-02-03', 2016, 1, 4, 4);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("A complete jerk!", "Take the class And do the work you'll be fine", 40, 26, '2016-06-15', 2016, 1, 4, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("I thought she was tough and challenging, but looking back I cant think of another professor that prepared as much as this one", "Learn so much in this class.", 39, 26, '2016-10-13', 2016, 1, 5, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("will kill your GPA and not care, gives daily quizzes that are 50% of your grade, and you do not learn the material in class", "DO NOT TAKE THIS CLASS", 33, 27, '2016-02-26', 2016, 1, 1, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("Good teacher really cares about the students", "not too hard just do all the homework take notes and you should do good.", 24, 27, '2016-03-11', 2016, 1, 3, 5);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("okay teacher", "I really enjoyed the class wish it was deliverd with more passion", 7, 27, '2016-06-29', 2016, 1, 5, 3);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("someone please fire this person", "take any class but this one", 45, 27, '2016-03-01', 2016, 1, 2, 1);
insert review (professor_review, class_review, login_id, class_id, review_date, year, semester, class_rating, professor_rating) values ("You can tell the professor is trying, but just very good in getting the material across", "I think class should be taken by every one, learn so much", 48, 27, '2016-01-25', 2016, 1, 4, 2);

-- Insert trigger to throw error if the review.class_rating or review.professor_rating being assigned does not meet the minimum requirements for the SAT score
DROP TRIGGER IF EXISTS trg_valid_rating_ins;
DELIMITER $$
create trigger trg_valid_rating_ins 
before insert on review
for each row
begin
   declare msg varchar(128);
	if (new.class_rating < 1) or (new.class_rating > 5) or (new.professor_rating < 1 ) or (new.professor_rating > 5 )
    then
       set msg = concat('InsertReviewError: Trying to insert an invalid value in review.class_rating or review.professor_rating field.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;

-- Insert trigger to throw error if the review.semester being assigned is not valid
DROP TRIGGER IF EXISTS trg_valid_semester;
DELIMITER $$
create trigger trg_valid_semester 
before insert on review
for each row
begin
   declare msg varchar(128);
   if (new.semester < 1) or (new.semester > 4)
    then
       set msg = concat('InsertReviewError: Trying to insert an invalid value in review.semester field.');
       signal sqlstate '45000' set message_text = msg;
   end if;
end $$
DELIMITER ;