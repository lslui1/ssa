package ssa.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Class;

@Transactional
@Repository
public class ClassDAO implements IClassDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
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

}
