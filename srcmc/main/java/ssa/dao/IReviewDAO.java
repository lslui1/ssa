package ssa.dao;

import java.util.List;

import ssa.entity.Review;

public interface IReviewDAO {
	
	List<Review> getReviewsByClassId(int class_id);
	List<Review> getReviewsByLoginId(int login_id);
	Review getReviewById(int id);
	void insertReview(Review Review);
	void deleteReview(Integer id);
	void updateReview(Review Review);

}
