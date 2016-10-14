package ssa.dao;

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
	
	@Override
	public Professor getProfessorById(int professorId) {
	    return (Professor) hibernateTemplate.get(Professor.class, professorId);
	}


}
