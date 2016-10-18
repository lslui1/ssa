package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IReviewDAO;
import ssa.entity.Review;

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

}