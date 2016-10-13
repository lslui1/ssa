package ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")

public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="login_id")
	private int login_id;
	@Column(name="class_id")
	private int class_id;
	@Column(name="date_of_review")
	private Date date_of_review;
	@Column(name="year")
	private int year;
	@Column(name="semester")
	private int semester;
	@Column(name="review_class")
	private String review_class;
	@Column(name="review_professor")
	private String review_professor;
	@Column(name="class_rating")
	private int class_rating;
	@Column(name="professor_rating")
	private int professor_rating;
	
	
	public Review() {};
	
	public Review(int login_id, int class_id, Date date_of_review, int year, int semester, String review_class,
			String review_professor, int class_rating, int professor_rating) {
		super();
		this.login_id = login_id;
		this.class_id = class_id;
		this.date_of_review = date_of_review;
		this.year = year;
		this.semester = semester;
		this.review_class = review_class;
		this.review_professor = review_professor;
		this.class_rating = class_rating;
		this.professor_rating = professor_rating;
	}
	
	
}
	
	
