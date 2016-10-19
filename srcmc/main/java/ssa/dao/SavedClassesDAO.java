package ssa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssa.entity.Class;
import ssa.entity.CombinedClass;
import ssa.entity.Professor;
import ssa.entity.Review;
import ssa.entity.SavedClasses;
import ssa.entity.University;
import ssa.service.IClassService;
import ssa.service.IProfessorService;
import ssa.service.IUniversityService;
import ssa.service.IReviewService;

@Transactional
@Repository
public class SavedClassesDAO implements ISavedClassesDAO {

	@Autowired
	private IClassService classService;
	@Autowired
	private IProfessorService professorService;
	@Autowired
	private IUniversityService universityService;
	@Autowired
	private IReviewService reviewService;
	
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked"
    		)
    @Override
	public List<CombinedClass> getSavedClassesById(int login_id) {
		 String hql = "FROM SavedClasses where login_id = '" + login_id + "'";
	     List<SavedClasses> savedClasses = (List<SavedClasses>) hibernateTemplate.find(hql);
	     ArrayList<CombinedClass> combinedclasses = new ArrayList<CombinedClass>();
	     for (int i=0; i<savedClasses.size(); i++) {
	    	 int classId = savedClasses.get(i).getClass_id();
	    	 Class aClass = classService.getClassById(classId);
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
	 			aCombinedClass.setAggregateClassScore(reviewService.getAggregateClassRatingByClassId(aClass.getId()));
	 			aCombinedClass.setAggregateProfessorScore(reviewService.getAggregateProfessorRatingByClassId(aClass.getId()));
	 			combinedclasses.add(aCombinedClass);		
	 		}
	         return combinedclasses;
	 	}
	     
	
    
    @Override
    public SavedClasses getSavedClassById(int login_id, int class_id) {
		 String hql = "FROM SavedClasses where login_id = '" + login_id + "' and class_id = '" + class_id + '"';
	     return (SavedClasses) hibernateTemplate.find(hql).get(0);
	}
    
    @Override
    public SavedClasses getSavedClassByDatabaseId(int id) {
		 String hql = "FROM SavedClasses where id = '" + id + "'";
	     return (SavedClasses) hibernateTemplate.find(hql).get(0);
	}
   

	@Override
	public void deleteSavedClass(int id) {
		SavedClasses savedClass = getSavedClassByDatabaseId(id);
	    hibernateTemplate.delete(savedClass);
	}
	
	@Override
	public void insertSavedClass(SavedClasses savedClass) {
	    hibernateTemplate.save(savedClass);
	}
}


