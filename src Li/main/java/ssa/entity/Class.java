package ssa.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="university_id")
	private int university_id;
	
	@Column(name="professor_id")
	private int professor_id;

	@Column(name="name")
	private String name;
	
	@Column(name="section")
	private int section;
	
	public Class() {}
	
	public Class(int university_id, int professor_id, String name, int section) {
		super();
		this.university_id = university_id;
		this.professor_id = professor_id;
		this.name = name;
		this.section = section;
	}

	@Override
	public String toString() {
		return (String.format("%4d %4d %4d %-20s %4d", this.id, this.university_id, this.professor_id, this.name, this.section));
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

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
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

}