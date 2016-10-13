package ssa.service;

import java.util.List;

import ssa.entity.Review;

public interface IReviewService {

	List<Review> getReviewsById(int class_id);
	void deleteReview(Review Review);
	void insertReview(Review Review);
	void updateReview(Review Review);
}
