package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Review;

@Transactional
@Repository
public class ReviewDAO implements IReviewDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
	public List<Review> getReviewsById(int class_id) {
		 String hql = "FROM Review where class_id = '" + class_id + "'";
	     return (List<Review>) hibernateTemplate.find(hql);
	}
    
//    @Override
//	public List<Review> getReviewsByProfessor(int class_id) {
//		 String hql = "FROM Review where class_id = '" + class_id + "'";
//	     return (List<Review>) hibernateTemplate.find(hql);
//	}
	
	@Override
	public void deleteReview(Review Review) {
	    hibernateTemplate.delete(Review);
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


