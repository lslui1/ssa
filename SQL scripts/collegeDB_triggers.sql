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

-- trigger to throw error if the review.semester being assigned is not valid
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