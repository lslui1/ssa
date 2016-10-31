package ssa.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ssa.entity.Class;
import ssa.service.IClassService;
import ssa.entity.Professor;
import ssa.entity.University;
import ssa.service.IUniversityService;
import ssa.entity.CombinedClass;
import ssa.entity.CombinedReview;
import ssa.service.IProfessorService;
import ssa.service.IReviewService;
import ssa.entity.Review;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class ClassController {

	@Autowired
	private IClassService classService;
	
	@Autowired
	private IProfessorService professorService;
	
	@Autowired
	private IUniversityService universityService;
	
	@Autowired
	private IReviewService reviewService;
	
	
	@RequestMapping(value= "/alternativeclassesbyclassid/{classid}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedClass>> getAlternativeClassesByClassId(@PathVariable("classid") Integer classId) {
		
		Class primaryClass = classService.getClassById(classId);
		double aggregateClassRating = reviewService.getAggregateClassRatingByClassId(classId);
		double aggregateProfessorRating = reviewService.getAggregateProfessorRatingByClassId(classId);
		double totalAggregateRating = (aggregateClassRating + aggregateProfessorRating) / 2;
		ArrayList<CombinedClass> alternativeclasses = new ArrayList<>();
		List<Class> comparisonClasses = classService.getAllClassesBySubjectSection(primaryClass.getName(), primaryClass.getSection());
		for (Class aClass : comparisonClasses) {
			double comparisonaggregateClassRating = reviewService.getAggregateClassRatingByClassId(aClass.getId());
			double comparisonaggregateProfessorRating = reviewService.getAggregateProfessorRatingByClassId(aClass.getId());
			double comptotalAggregateRating = (comparisonaggregateClassRating + comparisonaggregateProfessorRating) / 2;
			int comptotalAggregateCount = reviewService.getRatingCountByClassId(aClass.getId());
			if ( comptotalAggregateRating > totalAggregateRating) {
				Professor aProfessor = professorService.getProfessorById(aClass.getProfessor_id());
				University aUniversity = universityService.getUniversityById(aClass.getUniversity_id());
				CombinedClass aCombinedClass = new CombinedClass();
				aCombinedClass.setId(aClass.getId());
				aCombinedClass.setName(aClass.getName());
				aCombinedClass.setUniversity_id(aClass.getUniversity_id());
				aCombinedClass.setSection(aClass.getSection());
				aCombinedClass.setProfessor_id(aClass.getProfessor_id());			
				aCombinedClass.setProfessor_fname(aProfessor.getFirst_name());
				aCombinedClass.setProfessor_lname(aProfessor.getLast_name());
				aCombinedClass.setUniversity_name(aUniversity.getName());
				aCombinedClass.setAggregateClassRating(comparisonaggregateClassRating);
				aCombinedClass.setAggregateProfessorRating(comparisonaggregateProfessorRating);
				aCombinedClass.setAggregateCount(comptotalAggregateCount);
				alternativeclasses.add(aCombinedClass);
			}
		}
        return new ResponseEntity<ArrayList<CombinedClass>>(alternativeclasses, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value= "/alternativeclasscountbyclassid/{classid}", method = RequestMethod.GET)
    public int getAlternativeClassCountByClassId(@PathVariable("classid") Integer classId) {
		int count = 0;
		Class primaryClass = classService.getClassById(classId);
		double aggregateClassRating = reviewService.getAggregateClassRatingByClassId(classId);
		double aggregateProfessorRating = reviewService.getAggregateProfessorRatingByClassId(classId);
		double totalAggregateRating = (aggregateClassRating + aggregateProfessorRating) / 2;

		List<Class> comparisonClasses = classService.getAllClassesBySubjectSection(primaryClass.getName(), primaryClass.getSection());
		for (Class aClass : comparisonClasses) {
			double comparisonaggregateClassRating = reviewService.getAggregateClassRatingByClassId(aClass.getId());
			double comparisonaggregateProfessorRating = reviewService.getAggregateProfessorRatingByClassId(aClass.getId());
			double comptotalAggregateRating = (comparisonaggregateClassRating + comparisonaggregateProfessorRating) / 2;
			if ( comptotalAggregateRating > totalAggregateRating) {
				count++;
			}
		}
        return count;
	}
	
	
	

	@RequestMapping(value= "/combinedreviewsbyloginid/{loginid}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedReview>> getCombinedReviewsById(@PathVariable("loginid") Integer loginId) {
		ArrayList<CombinedReview> combinedreviews = new ArrayList<CombinedReview>();

		List<Review> reviews = reviewService.getReviewsByLoginId(loginId);
		
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

	
	
	@RequestMapping(value= "/combinedclasses", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedClass>> getAllCombinedClasses() {
		ArrayList<CombinedClass> combinedclasses = new ArrayList<CombinedClass>();

		List<Class> classes = classService.getAllClasses();
		
		for (Class aClass : classes) {
			Professor aProfessor = professorService.getProfessorById(aClass.getProfessor_id());
			University aUniversity = universityService.getUniversityById(aClass.getUniversity_id());
			CombinedClass aCombinedClass = new CombinedClass();
			aCombinedClass.setId(aClass.getId());
			aCombinedClass.setName(aClass.getName());
			aCombinedClass.setUniversity_id(aClass.getUniversity_id());
			aCombinedClass.setSection(aClass.getSection());
			aCombinedClass.setProfessor_id(aClass.getProfessor_id());			
			aCombinedClass.setProfessor_fname(aProfessor.getFirst_name());
			aCombinedClass.setProfessor_lname(aProfessor.getLast_name());
			aCombinedClass.setUniversity_name(aUniversity.getName());		
			
			aCombinedClass.setAggregateClassRating(reviewService.getAggregateClassRatingByClassId(aClass.getId()));
			aCombinedClass.setAggregateProfessorRating(reviewService.getAggregateProfessorRatingByClassId(aClass.getId()));
			aCombinedClass.setAggregateCount(reviewService.getRatingCountByClassId(aClass.getId()));
			
			combinedclasses.add(aCombinedClass);		
		}
        return new ResponseEntity<ArrayList<CombinedClass>>(combinedclasses, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/combinedclassbyclassid/{classid}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedClass>> getCombinedClassByClassId(@PathVariable("classid") Integer classId) {
		
		ArrayList<CombinedClass> combinedclasses = new ArrayList<CombinedClass>();
		
		Class aclass = classService.getClassById(classId);
		Professor aProfessor = professorService.getProfessorById(aclass.getProfessor_id());
		University aUniversity = universityService.getUniversityById(aclass.getUniversity_id());
		CombinedClass aCombinedClass = new CombinedClass();
		aCombinedClass.setId(aclass.getId());
		aCombinedClass.setName(aclass.getName());
		aCombinedClass.setUniversity_id(aclass.getUniversity_id());
		aCombinedClass.setSection(aclass.getSection());
		aCombinedClass.setProfessor_id(aclass.getProfessor_id());			
		aCombinedClass.setProfessor_fname(aProfessor.getFirst_name());
		aCombinedClass.setProfessor_lname(aProfessor.getLast_name());
		aCombinedClass.setUniversity_name(aUniversity.getName());			
		aCombinedClass.setAggregateClassRating(reviewService.getAggregateClassRatingByClassId(aclass.getId()));
		aCombinedClass.setAggregateProfessorRating(reviewService.getAggregateProfessorRatingByClassId(aclass.getId()));
		aCombinedClass.setAggregateCount(reviewService.getRatingCountByClassId(aclass.getId()));
		combinedclasses.add(aCombinedClass);

        return new ResponseEntity<ArrayList<CombinedClass>>(combinedclasses, HttpStatus.OK);
	}

	@RequestMapping(value= "/combinedclassbyprofessorid/{professorid}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CombinedClass>> getCombinedClassByProfessorId(@PathVariable("professorid") Integer professorId) {
		ArrayList<CombinedClass> combinedclasses = new ArrayList<CombinedClass>();
		List<Class> classes = classService.getAllClassesByProf(professorId);
		for (Class aClass : classes) {
			Professor aProfessor = professorService.getProfessorById(aClass.getProfessor_id());
			University aUniversity = universityService.getUniversityById(aClass.getUniversity_id());
			CombinedClass aCombinedClass = new CombinedClass();
			aCombinedClass.setId(aClass.getId());
			aCombinedClass.setName(aClass.getName());
			aCombinedClass.setUniversity_id(aClass.getUniversity_id());
			aCombinedClass.setSection(aClass.getSection());
			aCombinedClass.setProfessor_id(aClass.getProfessor_id());			
			aCombinedClass.setProfessor_fname(aProfessor.getFirst_name());
			aCombinedClass.setProfessor_lname(aProfessor.getLast_name());
			aCombinedClass.setUniversity_name(aUniversity.getName());		
			
			aCombinedClass.setAggregateClassRating(reviewService.getAggregateClassRatingByClassId(aClass.getId()));
			aCombinedClass.setAggregateProfessorRating(reviewService.getAggregateProfessorRatingByClassId(aClass.getId()));
			aCombinedClass.setAggregateCount(reviewService.getRatingCountByClassId(aClass.getId()));
			
			combinedclasses.add(aCombinedClass);		
		}
        return new ResponseEntity<ArrayList<CombinedClass>>(combinedclasses, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return new ResponseEntity<List<Class>>(classes, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/classesbyprof/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesByProf(@PathVariable("id") Integer instructorId) {
        List<Class> aClass = classService.getAllClassesByProf(instructorId);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/classesbysubject/{subject}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesBySubject(@PathVariable("subject") String name) {
        List<Class> aClass = classService.getAllClassesBySubject(name);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/classesbysubjectsection/{subject}/{section}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesBySubjectSection(@PathVariable("subject") String name, @PathVariable("section") Integer section) {
        List<Class> aClass = classService.getAllClassesBySubjectSection(name, section);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	
	@RequestMapping(value= "/class/{id}", method = RequestMethod.GET)
    public ResponseEntity<Class> getClassById(@PathVariable("id") Integer id) {
        Class aClass = classService.getClassById(id);
        return new ResponseEntity<Class>(aClass, HttpStatus.OK);
    }
		
	@RequestMapping(value= "/addclass", method = RequestMethod.POST)
    public ResponseEntity<Void> addClass(@RequestBody Class aClass) {
		Class newclass = new Class();
		newclass.setName(aClass.getName());
		newclass.setProfessor_id(aClass.getProfessor_id());
		newclass.setUniversity_id(aClass.getUniversity_id());
		newclass.setSection(aClass.getSection());
		System.out.println("Instantiated:" + newclass);

        boolean condition = classService.addClass(newclass);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updateclass", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClass(@RequestBody Class aClass) {
        classService.updateClass(aClass);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
