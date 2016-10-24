package ssa.entity;


public class CombinedProfessor {

	private int id;

	private int university_id;
	
	private String university_name;

	private String first_name;

	private String last_name;

	private double AggregateProfRating;
	
	private int count;
	
	
	public CombinedProfessor() {}

	public CombinedProfessor(int university_id, String first_name, String last_name) {
		super();
		this.university_id = university_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return (String.format("%4d %4d %-20s %-20s %-20s %4.2f %4d", this.id, this.university_id, this.university_name, this.first_name, this.last_name, this.AggregateProfRating, this.count));
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

	public double getAggregateProfRating() {
		return AggregateProfRating;
	}

	public void setAggregateProfRating(double aggregateProfRating) {
		AggregateProfRating = aggregateProfRating;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}


}