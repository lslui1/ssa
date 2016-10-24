package ssa.controller;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssa.entity.Class;
import ssa.entity.CombinedReview;
import ssa.entity.Professor;
import ssa.entity.RatingData;
import ssa.entity.Review;
import ssa.entity.University;
import ssa.service.IClassService;
import ssa.service.IProfessorService;
import ssa.service.IReviewService;
import ssa.service.IUniversityService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class ReviewController {
	
	@Autowired
	private IClassService classService;
	
	@Autowired
	private IProfessorService professorService;
	
	@Autowired
	private IUniversityService universityService;
	
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
	
	@RequestMapping(value= "/ReviewsByProfessor/{professor_id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedReview>>  getReviewsByProfessorId(@PathVariable("professor_id") int professor_id) {
		ArrayList<CombinedReview> combinedreviews = new ArrayList<CombinedReview>();
        List<Review> reviews = ReviewService. getReviewsByProfessorId(professor_id);
		for (Review aReview : reviews) {
			Class aClass = classService.getClassById(aReview.getClass_id());
			Professor aProfessor = professorService.getProfessorById(aClass.getProfessor_id());			
			University aUniversity = universityService.getUniversityById(aClass.getUniversity_id());
			
			CombinedReview aCombinedReview = new CombinedReview();
			aCombinedReview.setReview_id(aReview.getId());
			aCombinedReview.setLogin_id(aReview.getLogin_id());
			aCombinedReview.setReview_date(aReview.getReview_date());
			aCombinedReview.setProfessor_review(aReview.getProfessor_review());
			aCombinedReview.setClass_review(aReview.getClass_review());
			aCombinedReview.setClass_rating(aReview.getClass_rating());
			aCombinedReview.setProfessor_rating(aReview.getProfessor_rating());
			aCombinedReview.setClass_id(aClass.getId());
			aCombinedReview.setName(aClass.getName());
			aCombinedReview.setSection(aClass.getSection());
			aCombinedReview.setUniversity_id(aUniversity.getId());
			aCombinedReview.setUniversity_name(aUniversity.getName());
			aCombinedReview.setSemester(aReview.getSemester());
			aCombinedReview.setYear(aReview.getYear());
			aCombinedReview.setProfessor_id(aProfessor.getId());
			aCombinedReview.setProfessor_fname(aProfessor.getFirst_name());
			aCombinedReview.setProfessor_lname(aProfessor.getLast_name());			
			combinedreviews.add(aCombinedReview);
		}
        return new ResponseEntity<ArrayList<CombinedReview>>(combinedreviews, HttpStatus.OK);
	}
	

	
	@RequestMapping(value= "/AggregateClassRatingByProfessorId/{professor_id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getAggregateClassRatingByProfessorId(@PathVariable("professor_id") int professor_id) {
		Double professorAggregate = ReviewService.getAggregateClassRatingByProfessorId(professor_id);
        return new ResponseEntity<Double>(professorAggregate, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/AggregateProfessorRatingByClassId/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getAggregateProfessorRatingByClassId(@PathVariable("class_id") int class_id) {
        Double professorAggregate = ReviewService.getAggregateProfessorRatingByClassId(class_id);
        return new ResponseEntity<Double>(professorAggregate, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/AggregateProfessorRatingByProfessorId/{professor_id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getAggregateProfessorRatingByProfessorId(@PathVariable("professor_id") int professor_id) {
		Double professorAggregate = ReviewService.getAggregateProfessorRatingByProfessorId(professor_id);
        return new ResponseEntity<Double>(professorAggregate, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/AggregateClassRatingByClassId/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getAggregateClassRatingByClassId(@PathVariable("class_id") int class_id) {
		Double classAggregate = ReviewService.getAggregateClassRatingByClassId(class_id);
        return new ResponseEntity<Double>(classAggregate, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/RatingCountByClassId/{class_id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getRatingCountByClassId(@PathVariable("class_id") int class_id) {
		int ratingCount = ReviewService.getRatingCountByClassId(class_id);
        return new ResponseEntity<Integer>(ratingCount, HttpStatus.OK);
    }
    
	@RequestMapping(value= "/RatingCountByProfessorId/{professor_id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getRatingCountByProfessorId(@PathVariable("professor_id") int professor_id) {
		Integer ratingCount = ReviewService.getRatingCountByProfessorId(professor_id);
        return new ResponseEntity<Integer>(ratingCount, HttpStatus.OK);
    }
	
	
	
	
	
	@RequestMapping(value= "/ClassRatingDataByProfessorId/{professor_id}", method = RequestMethod.GET)
	public ResponseEntity<RatingData> getClassRatingDataByProfessorId(@PathVariable("professor_id") int professor_id) {
		RatingData ratingData = ReviewService.getClassRatingDataByProfessorId(professor_id);
		return new ResponseEntity<RatingData>(ratingData, HttpStatus.OK);
	}   
	@RequestMapping(value= "/ProfessorRatingDataByProfessorId/{professor_id}", method = RequestMethod.GET)
	public ResponseEntity<RatingData> getProfessorRatingDataByProfessorId(@PathVariable("professor_id") int professor_id) {
		RatingData ratingData = ReviewService.getProfessorRatingDataByProfessorId(professor_id);
		return new ResponseEntity<RatingData>(ratingData, HttpStatus.OK);
  	}          
	@RequestMapping(value= "/ProfessorRatingDataByClassId/{class_id}", method = RequestMethod.GET)
	public ResponseEntity<RatingData> getClassRatingDataByClassId(@PathVariable("class_id") int class_id) {
		RatingData ratingData = ReviewService.getClassRatingDataByClassId(class_id);
		return new ResponseEntity<RatingData>(ratingData, HttpStatus.OK);
	} 
	@RequestMapping(value= "/ClassRatingDataByClassId/{class_id}", method = RequestMethod.GET)
	public ResponseEntity<RatingData> getProfessorRatingDataByClassId(@PathVariable("class_id") int class_id) {
		RatingData ratingData = ReviewService.getProfessorRatingDataByClassId(class_id);
		return new ResponseEntity<RatingData>(ratingData, HttpStatus.OK);
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
