package ssa.service;

import java.util.List;

import ssa.entity.Review;

public interface IReviewService {

	List<Review> getReviewsByClassId(int class_id);
	List<Review> getReviewsByLoginId(int login_id);
	Review getReviewById(int id);
	void deleteReview(Integer id);
	void insertReview(Review Review);
	void updateReview(Review Review);
	Double getAggregateClassRatingByProfessorId(int professor_id);
	Double getAggregateProfessorRatingByClassId(int class_id);
	Double getAggregateProfessorRatingByProfessorId(int professor_id);
	Double getAggregateClassRatingByClassId(int class_id);

}
