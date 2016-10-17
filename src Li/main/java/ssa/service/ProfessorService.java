package ssa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssa.dao.IProfessorDAO;
import ssa.entity.Professor;

@Service
public class ProfessorService implements IProfessorService{

	@Autowired
	private IProfessorDAO ProfessorDAO;
	
	@Override
	public List<Professor> getAllProfessors() {
		return ProfessorDAO.getAllProfessors();
	}
	
	@Override
	public Professor getProfessorById(int professorId) {
		return ProfessorDAO.getProfessorById(professorId);
	}

	@Override
	public List<Professor> getProfessorByFnameLname(String fname, String lname) {
		return ProfessorDAO.getProfessorByFnameLname(fname, lname);
	}
	
	@Override
	public boolean addProfessor(Professor professor) {
		return ProfessorDAO.addProfessor(professor);
	}
	
}
