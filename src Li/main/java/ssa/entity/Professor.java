package ssa.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="university_id")
	private int university_id;
	
	@Column(name="first_name")
	private String first_name;

	@Column(name="last_name")
	private String last_name;

	public Professor() {}

	public Professor(int university_id, String first_name, String last_name) {
		super();
		this.university_id = university_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return (String.format("%4d %4d %-20s %-20s", this.id, this.university_id, this.first_name, this.last_name));
	}


}