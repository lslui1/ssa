package ssa.dao;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ssa.entity.Review;
import ssa.entity.Class;

@Transactional
@Repository
public class ReviewDAO implements IReviewDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
	public List<Review> getReviewsByClassId(int class_id) {
		 String hql = "FROM Review where class_id = '" + class_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
	}
    
	public List<Review> getReviewsByLoginId(int login_id) {
		 String hql = "FROM Review where login_id = '" + login_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
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
		total = total * 100;
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
		total = total * 100;
		total = Math.round(total);
		total = total/100;
		return total;
	}
	
	
	public double getAggregateClassRatingByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
		 List<Class> classList = new ArrayList<Class>();
	     classList = (List<Class>) hibernateTemplate.find(hql);
	     System.out.println(classList);
	     List<Review> reviewList = new ArrayList<Review>();
	     List<Integer> ratingsList = new ArrayList<Integer>();
	     double total = 0.0;
	     for (int i=0; i<classList.size(); i++) {
	    	 Class tempClass = classList.get(i);
	    	 int classId = tempClass.getId();
	    	 System.out.println(classId);
	    	 String hql2 = "FROM Review where class_id = '" + classId + "'";
	    	 reviewList = (List<Review>) hibernateTemplate.find(hql2);
	    	 for (int j=0; j<reviewList.size(); j++) {
	    		 Review tempReview = reviewList.get(j);
	    		 int classRating = tempReview.getClass_rating();
	    		 total += classRating;
	    	 }
	     }
	     System.out.println(total);
	     System.out.println(reviewList.size());
    	 total = total/reviewList.size();
    	 total = total/classList.size();
 		total = total * 100;
 		total = Math.round(total);
 		total = total/100;
	     return total;
	}
	
	public double getAggregateProfessorRatingByProfessorId(int professor_id) {
		 String hql = "FROM Class where professor_id = '" + professor_id + "'";
		 List<Class> classList = new ArrayList<Class>();
	     classList = (List<Class>) hibernateTemplate.find(hql);
	     System.out.println(classList);
	     List<Review> reviewList = new ArrayList<Review>();
	     double total = 0.0;
	     for (int i=0; i<classList.size(); i++) {
	    	 Class tempClass = classList.get(i);
	    	 int classId = tempClass.getId();
	    	 System.out.println(classId);
	    	 String hql2 = "FROM Review where class_id = '" + classId + "'";
	    	 reviewList = (List<Review>) hibernateTemplate.find(hql2);
	    	 for (int j=0; j<reviewList.size(); j++) {
	    		 Review tempReview = reviewList.get(j);
	    		 int professorRating = tempReview.getProfessor_rating();
	    		 System.out.println(professorRating);
	    		 total += professorRating;
	    	 }
	     }
	     System.out.println(total);
	     System.out.println(reviewList.size());
	     total = total/reviewList.size();
			total = total * 100;
			total = Math.round(total);
			total = total/100;
	     return total;
	}
	
    
    
    public Review getReviewById(int id) {
		 String hql = "FROM Review where id = '" + id + "'";
	     return (Review) hibernateTemplate.find(hql).get(0);
	}
    
//    @Override
//	public List<Review> getReviewsByProfessor(int class_id) {
//		 String hql = "FROM Review where class_id = '" + class_id + "'";
//	     return (List<Review>) hibernateTemplate.find(hql);
//	}
	
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


