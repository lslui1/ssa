package ssa.entity;

public class RatingData {
	
	double average;
	int count;
	
	public RatingData() {}
	
	public RatingData(double average, int count) {
		super();
		this.average = average;
		this.count = count;
	}


	public double getAverage() {
		return average;
	}


	public void setAverage(double average) {
		this.average = average;
	}


	public int getCount() {
		return count;
	}
	

	public void setCount(int count) {
		this.count = count;
	}

	
	
}


