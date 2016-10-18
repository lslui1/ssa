package ssa.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import ssa.entity.Review;
import ssa.service.IReviewService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class ReviewController {
	
	@Autowired
	private IReviewService ReviewService;
	
	@RequestMapping(value= "/ReviewsByClass/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewsByClassId(@PathVariable("class_id") int class_id) {
        List<Review> review = ReviewService.getReviewsByClassId(class_id);
        return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/ReviewsByLogin/{login_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewsByLoginId(@PathVariable("login_id") int login_id) {
        List<Review> review = ReviewService.getReviewsByLoginId(login_id);
        return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/AggregateProfessorScore/{professor_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getAggregateProfessorScore(@PathVariable("professor_id") int professor_id) {
        List<Integer> professorAggregate = ReviewService.getAggregateProfessorScore(professor_id);
        return new ResponseEntity<List<Integer>>(professorAggregate, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/AggregateProfessorScoreByClassId/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getAggregateProfessorScoreByClassId(@PathVariable("class_id") int class_id) {
        List<Integer> professorAggregate = ReviewService.getAggregateProfessorScoreByClassId(class_id);
        return new ResponseEntity<List<Integer>>(professorAggregate, HttpStatus.OK);
    }
	
//	@RequestMapping(value= "/ReviewsBySubject/{class_id}", method = RequestMethod.GET)
//    public ResponseEntity<List<Review>> getReviewsByClassId(@PathVariable("class_id") int class_id) {
//        List<Review> review = ReviewService.getReviewsByClassId(class_id);
//        return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
//    }
	
	
	@RequestMapping(value= "/SingleReview/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {
        Review review = ReviewService.getReviewById(id);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/deletereview/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> deleteReview(@PathVariable("id") Integer id) {
        ReviewService.deleteReview(id);
        return new ResponseEntity<Review>(HttpStatus.OK);
    }
	

	@RequestMapping(value= "/insertreview", method = RequestMethod.POST)
	public ResponseEntity<Void> insertReview(@RequestBody Review ReviewData) {
		System.out.println(ReviewData);
		Calendar calendar = Calendar.getInstance();
		java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
		ReviewData.setReview_date(currentDate);
		ReviewService.insertReview(ReviewData);
	    return new ResponseEntity<Void>(HttpStatus.OK);    
    }
	
	
	@RequestMapping(value= "/updatereview", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateReview(@RequestBody Review ReviewData) {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
		ReviewData.setReview_date(currentDate);
		ReviewService.updateReview(ReviewData);
		return new ResponseEntity<Void>(HttpStatus.OK);
    }

	
}
