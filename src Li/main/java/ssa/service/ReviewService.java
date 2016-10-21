package ssa.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IReviewDAO;
import ssa.entity.Review;
import ssa.entity.RatingData;

@Service
public class ReviewService implements IReviewService {
	
	@Autowired
	private IReviewDAO reviewDAO;
	
	@Override
	public List<Review> getReviewsByClassId(int class_id) {
		return reviewDAO.getReviewsByClassId(class_id);
		}
	
	@Override
	public List<Review> getReviewsByLoginId(int login_id) {
		return reviewDAO.getReviewsByLoginId(login_id);
	}
	
	@Override
	public Review getReviewById(int id) {
		return reviewDAO.getReviewById(id);
		}
	
	@Override
	public void deleteReview(Integer id) {
		reviewDAO.deleteReview(id);
	}
	
	@Override
	public void insertReview(Review Review) {
		reviewDAO.insertReview(Review);
	}
	
	@Override
	public void updateReview(Review Review) {
		reviewDAO.updateReview(Review);
	}
	
	@Override
	public double getAggregateClassRatingByProfessorId(int professor_id) {
		return reviewDAO.getAggregateClassRatingByProfessorId(professor_id);
	}
	
	@Override
	public double getAggregateProfessorRatingByClassId(int class_id) {
		return reviewDAO.getAggregateProfessorRatingByClassId(class_id);
	}
	
	@Override
	public double getAggregateProfessorRatingByProfessorId(int professor_id) {
		return reviewDAO.getAggregateProfessorRatingByProfessorId(professor_id);
	}
	
	@Override
	public double getAggregateClassRatingByClassId(int class_id) {
		return reviewDAO.getAggregateClassRatingByClassId(class_id);
	}

	@Override
	public int getRatingCountByClassId(int class_id) {
		return reviewDAO.getRatingCountByClassId(class_id);
	}
	@Override
	public int getRatingCountByProfessorId(int professor_id) {
		return reviewDAO.getRatingCountByProfessorId(professor_id);
	}
	
	
	
	@Override
	public RatingData getClassRatingDataByProfessorId(int professor_id) {
		return reviewDAO.getClassRatingDataByProfessorId(professor_id);
	}
	@Override
	public RatingData getProfessorRatingDataByProfessorId(int professor_id) {
		return reviewDAO.getProfessorRatingDataByProfessorId(professor_id);
	}
	@Override
	public RatingData getClassRatingDataByClassId(int class_id) {
		return reviewDAO.getClassRatingDataByClassId(class_id);
	}
	@Override
	public RatingData getProfessorRatingDataByClassId(int class_id) {
		return reviewDAO.getProfessorRatingDataByClassId(class_id);
	}
	
}
