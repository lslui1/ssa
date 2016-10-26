package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Professor;

@Transactional
@Repository
public class ProfessorDAO implements IProfessorDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getAllProfessors() {
	    String hql = "FROM Professor as p ORDER BY p.id";
	    return (List<Professor>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> searchProfessorByProfessorLastName(String last_name) {
		 String hql = "FROM Professor as p where p.last_name like '%" + last_name + "%' ORDER BY p.id";
		 return (List<Professor>) hibernateTemplate.find(hql);
	}
	
	@Override
	public Professor getProfessorById(int professorId) {
	    return (Professor) hibernateTemplate.get(Professor.class, professorId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getProfessorByFnameLname(String fname, String lname) {
		String hql = "FROM Professor as p where p.first_name = '" + fname + "' " +
				"and p.last_name = '" + lname + "' " +
				" ORDER BY p.id";
		return (List<Professor>) hibernateTemplate.find(hql);
	}
	
	@Override
	public boolean addProfessor(Professor professor) {
		try {
			hibernateTemplate.saveOrUpdate(professor);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}
	
}
