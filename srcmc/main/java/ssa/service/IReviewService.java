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
	List<Integer> getAggregateProfessorScore(int professor_id);
	List<Integer> getAggregateProfessorScoreByClassId(int class_id);

}
