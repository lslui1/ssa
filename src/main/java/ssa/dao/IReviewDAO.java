package ssa.dao;

import java.util.List;

import ssa.entity.Review;

public interface IReviewDAO {
	
	List<Review> getReviewsById(int class_id);
	void insertReview(Review Review);
	void deleteReview(Review Review);
	void updateReview(Review Review);

}
