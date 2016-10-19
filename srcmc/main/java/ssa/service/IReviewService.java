package ssa.service;

import java.util.List;

import ssa.entity.RatingData;
import ssa.entity.Review;
import ssa.entity.Professor;

public interface IReviewService {

	List<Review> getReviewsByClassId(int class_id);
	List<Review> getReviewsByLoginId(int login_id);
	Review getReviewById(int id);
	void deleteReview(Integer id);
	void insertReview(Review Review);
	void updateReview(Review Review);
	double getAggregateClassRatingByProfessorId(int professor_id);
	double getAggregateProfessorRatingByClassId(int class_id);
	double getAggregateProfessorRatingByProfessorId(int professor_id);
	double getAggregateClassRatingByClassId(int class_id);
	int getRatingCountByClassId(int class_id);
	int getRatingCountByProfessorId(int professor_id);
	RatingData getClassRatingDataByProfessorId(int professor_id);
	RatingData getProfessorRatingDataByProfessorId(int professor_id);
	RatingData getClassRatingDataByClassId(int class_id);
	RatingData getProfessorRatingDataByClassId(int class_id);
	Professor getProfessorByProfessorLastName(String last_name);

}
