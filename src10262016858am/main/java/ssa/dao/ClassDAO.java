package ssa.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Class;
import ssa.service.IClassService;
import ssa.service.IReviewService;

@Transactional
@Repository
public class ClassDAO implements IClassDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private IClassService classService;
	
	@Autowired
	private IReviewService reviewService;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClasses() {
	    String hql = "FROM Class as c ORDER BY c.id";
	    return (List<Class>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClassesByProf(Integer instructorId) {
	    String hql = "FROM Class as c where c.professor_id = " + instructorId + " ORDER BY c.id";
	    return (List<Class>) hibernateTemplate.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClassesBySubject(String name) {
	    String hql = "FROM Class as c where c.name = '" + name + "' ORDER BY c.id";
	    return (List<Class>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClassesBySubjectSection(String name, Integer section) {
	    String hql = "FROM Class as c where c.name = '" + name + "' " +
	    				"and c.section = " + section +
	    				" ORDER BY c.id";
	    return (List<Class>) hibernateTemplate.find(hql);
	}
	
	@Override
	public Class getClassById(int aClassId) {
	    return (Class) hibernateTemplate.get(Class.class,aClassId);
	}

	@Override
	public boolean addClass(Class aClass) {
		try {
			hibernateTemplate.saveOrUpdate(aClass);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public void updateClass(Class aClass) {
		hibernateTemplate.saveOrUpdate(aClass);
	}

	@Override
	public int getAlternativeClassCountByClassId(Integer classId) {
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

}
