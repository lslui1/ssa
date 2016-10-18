package ssa.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssa.entity.University;

@Transactional
@Repository
public class UniversityDAO implements IUniversityDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<University> getAllUniversities() {
	    String hql = "FROM University as u ORDER BY u.id";
	    return (List<University>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<University> getUniversityByName(String name) {
		 String hql = "FROM University as u where u.name = '" + name + "' ORDER BY u.id";
	    return (List<University>) hibernateTemplate.find(hql);
	}
	
	@Override
	public University getUniversityById(int universityId) {
	    return (University) hibernateTemplate.get(University.class, universityId);
	}


}
