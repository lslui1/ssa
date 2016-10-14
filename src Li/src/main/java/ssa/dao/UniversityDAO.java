package ssa.dao;

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
	
	@Override
	public University getUniversityById(int universityId) {
	    return (University) hibernateTemplate.get(University.class, universityId);
	}


}
