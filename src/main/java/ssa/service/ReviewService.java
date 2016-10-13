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
	public List<Review> getReviewsById(int class_id) {
		return reviewDAO.getReviewsById(class_id);
		}
	
	@Override
	public void deleteReview(Review Review) {
		reviewDAO.deleteReview(Review);
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