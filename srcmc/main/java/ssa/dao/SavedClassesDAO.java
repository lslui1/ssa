package ssa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssa.entity.Class;
import ssa.entity.CombinedClass;
import ssa.entity.Professor;
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
	    	 int savedClassId = savedClasses.get(i).getId();
	    	 Class aClass = classService.getClassById(classId);
	    	 Professor aProfessor = professorService.getProfessorById(aClass.getProfessor_id());
	    	 University aUniversity = universityService.getUniversityById(aClass.getUniversity_id());
	    	 CombinedClass aCombinedClass = new CombinedClass();
	    	 	aCombinedClass.setId(aClass.getId());
	    	 	aCombinedClass.setSavedClassId(savedClassId);
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
				aCombinedClass.setAlternativeCount(classService.getAlternativeClassCountByClassId(classId));
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
		int login_id = savedClass.getLogin_id();
		int class_id = savedClass.getClass_id();
		String hql = "FROM SavedClasses where login_id = '" + login_id + "' and class_id = '" + class_id + "'";
	    if (hibernateTemplate.find(hql).size() == 0) {
	    	hibernateTemplate.save(savedClass);
	    }
	}
}


