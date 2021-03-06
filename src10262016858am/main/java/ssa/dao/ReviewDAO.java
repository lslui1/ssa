package ssa.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ssa.entity.Review;
import ssa.entity.Class;
import ssa.entity.RatingData;

@Transactional
@Repository
@SuppressWarnings("unchecked")
public class ReviewDAO implements IReviewDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
	public List<Review> getReviewsByClassId(int class_id) {
		 String hql = "FROM Review where class_id = '" + class_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
	}
    
	public List<Review> getReviewsByLoginId(int login_id) {
		 String hql = "FROM Review where login_id = '" + login_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
	}
	
	public List<Review> getReviewsByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
	     List<Class> classes = (List<Class>) hibernateTemplate.find(hql);
	     List<Review> totalReviews = new ArrayList<Review>();
	     for (Class passedClass : classes) {
	    	 int class_id = passedClass.getId();
	    	 String hql2 = "FROM Review where class_id = '" + class_id + "'";
	    	 List<Review> reviews = (List<Review>) hibernateTemplate.find(hql2);
	    	 for (Review review: reviews) {
	    		 totalReviews.add(review);
	    	 }
	     }
	     return totalReviews;
	}
	
	public double getAggregateClassRatingByClassId(int class_id) {
		String hql = "FROM Review where class_id = '" + class_id + "'";
		List<Review> reviews = (List<Review>) hibernateTemplate.find(hql);
		List<Integer> ratings = new ArrayList<Integer>();
		double total = 0.0;
		for (int i=0; i<reviews.size(); i++) {
			Review tempReview = reviews.get(i);
			ratings.add(tempReview.getClass_rating());
			total += tempReview.getClass_rating();
			}
		total = total/reviews.size();
   	 	total = total*100;
   	 	total = Math.round(total);
   	 	total = total/100;
   	 	return total;
	}
	
	public double getAggregateProfessorRatingByClassId(int class_id) {
		String hql = "FROM Review where class_id = '" + class_id + "'";
		List<Review> reviews = (List<Review>) hibernateTemplate.find(hql);
		List<Integer> ratings = new ArrayList<Integer>();
		double total = 0.0;
		for (int i=0; i<reviews.size(); i++) {
			Review tempReview = reviews.get(i);
			ratings.add(tempReview.getProfessor_rating());
			total += tempReview.getProfessor_rating();
			}
		total = total/reviews.size();
   	 	total = total*100;
   	 	total = Math.round(total);
   	 	total = total/100;
   	 	return total;
	}
	
	public int getRatingCountByClassId(int class_id) {
		String hql = "FROM Review where class_id = '" + class_id + "'";
		List<Review> reviews = (List<Review>) hibernateTemplate.find(hql);
		int count = reviews.size();
		return count;
	}

	public double getAggregateClassRatingByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
		 List<Class> classList = new ArrayList<Class>();
	     classList = (List<Class>) hibernateTemplate.find(hql);
	     List<Review> reviewList = new ArrayList<Review>();
	     int reviewListSize = 0;
	     double total = 0.0;
	     for (int i=0; i<classList.size(); i++) {
	    	 Class tempClass = classList.get(i);
	    	 int classId = tempClass.getId();
	    	 String hql2 = "FROM Review where class_id = '" + classId + "'";
	    	 reviewList = (List<Review>) hibernateTemplate.find(hql2);
	    	 reviewListSize += reviewList.size();
	    	 for (int j=0; j<reviewList.size(); j++) {
	    		 Review tempReview = reviewList.get(j);
	    		 int classRating = tempReview.getClass_rating();
	    		 total += classRating;
	    	 }
	     }
    	 total = total/reviewListSize;
    	 total = total/classList.size();
    	 total = total*100;
    	 total = Math.round(total);
    	 total = total/100;
    	 return total;
	}
	
	public double getAggregateProfessorRatingByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
		 List<Class> classList = new ArrayList<Class>();
	     classList = (List<Class>) hibernateTemplate.find(hql);
	     List<Review> reviewList = new ArrayList<Review>();
	     double total = 0.0;
	     int reviewListSize=0;
	     for (int i=0; i<classList.size(); i++) {
	    	 Class tempClass = classList.get(i);
	    	 int classId = tempClass.getId();
	    	 String hql2 = "FROM Review where class_id = '" + classId + "'";
	    	 reviewList = (List<Review>) hibernateTemplate.find(hql2);
	    	 reviewListSize += reviewList.size();
	    	 for (int j=0; j<reviewList.size(); j++) {
	    		 Review tempReview = reviewList.get(j);
	    		 int professorRating = tempReview.getProfessor_rating();
	    		 total += professorRating;
	    	 }
	     }
	     total = total/reviewListSize;
    	 total = total*100;
    	 total = Math.round(total);
    	 total = total/100;
    	 return total;
	}
	
	public int getRatingCountByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
		 List<Class> classList = new ArrayList<Class>();
	     classList = (List<Class>) hibernateTemplate.find(hql);
	     List<Review> reviewList = new ArrayList<Review>();
	     int count = 0;
	     for (int i=0; i<classList.size(); i++) {
	    	 Class tempClass = classList.get(i);
	    	 int classId = tempClass.getId();
	    	 String hql2 = "FROM Review where class_id = '" + classId + "'";
	    	 reviewList = (List<Review>) hibernateTemplate.find(hql2);
	    	 count += reviewList.size();
	     }
	     return count;
	}
	
	public RatingData getClassRatingDataByProfessorId(int professor_id) {
		RatingData ratingData = new RatingData();
		ratingData.setAverage(getAggregateClassRatingByProfessorId(professor_id));
		ratingData.setCount(getRatingCountByProfessorId(professor_id));
		return ratingData;
	}
	
	public RatingData getProfessorRatingDataByProfessorId(int professor_id) {
		RatingData ratingData = new RatingData();
		ratingData.setAverage(getAggregateProfessorRatingByProfessorId(professor_id));
		ratingData.setCount(getRatingCountByProfessorId(professor_id));
		return ratingData;
	}
	
	public RatingData getClassRatingDataByClassId(int class_id) {
		RatingData ratingData = new RatingData();
		ratingData.setAverage(getAggregateClassRatingByClassId(class_id));
		ratingData.setCount(getRatingCountByClassId(class_id));
		return ratingData;
	}
	
	public RatingData getProfessorRatingDataByClassId(int class_id) {
		RatingData ratingData = new RatingData();
		ratingData.setAverage(getAggregateProfessorRatingByClassId(class_id));
		ratingData.setCount(getRatingCountByClassId(class_id));
		return ratingData;
	}
    
    public Review getReviewById(int id) {
		 String hql = "FROM Review where id = '" + id + "'";
	     return (Review) hibernateTemplate.find(hql).get(0);
	}
	
	@Override
	public void deleteReview(Integer id) {
		Review review = getReviewById(id);
		System.out.println(review);
	    hibernateTemplate.delete(review);
	}
	
	@Override
	public void insertReview(Review Review) {
	    hibernateTemplate.save(Review);
	}
	
	@Override
	public void updateReview(Review Review) {
	    hibernateTemplate.update(Review);
	}

}


