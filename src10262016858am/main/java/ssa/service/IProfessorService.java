package ssa.service;

import java.util.List;

import ssa.entity.Professor;

public interface IProfessorService {

	Professor getProfessorById(int professorId);
	List<Professor> getAllProfessors();
	List<Professor> getProfessorByFnameLname(String fname, String lname);
	boolean addProfessor(Professor professor);
	List<Professor> searchProfessorByProfessorLastName(String last_name);
}
