package ssa.dao;

import java.util.List;

import ssa.entity.Professor;

public interface IProfessorDAO {

	boolean addProfessor(Professor professor);
	List<Professor> getAllProfessors();
	Professor getProfessorById(int professorId);
	List<Professor> getProfessorByFnameLname(String fname, String lname);
	List<Professor> searchProfessorByProfessorLastName(String last_name);
}
