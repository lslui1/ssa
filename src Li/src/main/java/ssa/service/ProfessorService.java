package ssa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IProfessorDAO;
import ssa.entity.Professor;

@Service
public class ProfessorService implements IProfessorService{

	@Autowired
	private IProfessorDAO ProfessorDAO;
	
	@Override
	public Professor getProfessorById(int professorId) {
		return ProfessorDAO.getProfessorById(professorId);
	}

}
