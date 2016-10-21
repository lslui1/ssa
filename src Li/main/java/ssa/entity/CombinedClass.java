package ssa.entity;

public class CombinedClass {

	private int id;
	private int savedClassId;
	private int university_id;
	private int professor_id;
	private String name;
	private int section;
	private String professor_fname;
	private String professor_lname;
	private String university_name;
	private double aggregateClassRating;
	private double aggregateProfessorRating;
	private int aggregateCount;
	private int alternativeCount;
	
	public CombinedClass() {}
	
	public CombinedClass(int id, int university_id, int professor_id, String name, int section, String professor_fname,
			String professor_lname, String university_name) {
		super();
		this.id = id;
		this.university_id = university_id;
		this.professor_id = professor_id;
		this.name = name;
		this.section = section;
		this.professor_fname = professor_fname;
		this.professor_lname = professor_lname;
		this.university_name = university_name;
	}

	@Override
	public String toString() {
		return (String.format("%4d %4d %4d %-20s %4d %-20s %-20s %-20s %4.2f %4.2f %4d", this.id, this.university_id,
				this.professor_id, this.name, this.section, this.professor_fname, this.professor_lname,
				this.university_name, this.aggregateClassRating, this.aggregateProfessorRating, this.aggregateCount));
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

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public double getAggregateClassRating() {
		return aggregateClassRating;
	}

	public void setAggregateClassRating(double aggregateClassRating) {
		this.aggregateClassRating = aggregateClassRating;
	}

	public double getAggregateProfessorRating() {
		return aggregateProfessorRating;
	}

	public void setAggregateProfessorRating(double aggregateProfessorRating) {
		this.aggregateProfessorRating = aggregateProfessorRating;
	}

	public int getAggregateCount() {
		return aggregateCount;
	}

	public void setAggregateCount(int aggregateCount) {
		this.aggregateCount = aggregateCount;
	}

	public int getSavedClassId() {
		return savedClassId;
	}

	public void setSavedClassId(int savedClassId) {
		this.savedClassId = savedClassId;
	}

	public int getAlternativeCount() {
		return alternativeCount;
	}

	public void setAlternativeCount(int alternativeCount) {
		this.alternativeCount = alternativeCount;
	}
	
	
	
}
