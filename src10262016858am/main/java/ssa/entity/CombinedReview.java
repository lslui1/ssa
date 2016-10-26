package ssa.entity;

import java.sql.Date;


public class CombinedReview {

	private int review_id;
	private int login_id;
	private Date review_date;
	private String professor_review;
	private String class_review;
	private int class_rating;
	private int professor_rating;

	private int class_id;
	private String name;
	private int section;

	private int university_id;
	private String university_name;
	private int year;
	private int semester;

	private int professor_id;
	private String professor_fname;
	private String professor_lname;

	public CombinedReview() {}

	
	
	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public String getProfessor_review() {
		return professor_review;
	}

	public void setProfessor_review(String professor_review) {
		this.professor_review = professor_review;
	}

	public String getClass_review() {
		return class_review;
	}

	public void setClass_review(String class_review) {
		this.class_review = class_review;
	}

	public int getClass_rating() {
		return class_rating;
	}

	public void setClass_rating(int class_rating) {
		this.class_rating = class_rating;
	}

	public int getProfessor_rating() {
		return professor_rating;
	}

	public void setProfessor_rating(int professor_rating) {
		this.professor_rating = professor_rating;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public String getProfessor_fname() {
		return professor_fname;
	}

	public void setProfessor_fname(String professor_fname) {
		this.professor_fname = professor_fname;
	}

	public String getProfessor_lname() {
		return professor_lname;
	}

	public void setProfessor_lname(String professor_lname) {
		this.professor_lname = professor_lname;
	}
	
	
	
	
}
