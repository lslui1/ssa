package ssa.dao;

import java.util.List;
import ssa.entity.Professor;

public interface IProfessorDAO {

	List<Professor> getAllProfessors();
	Professor getProfessorById(int professorId);
	List<Professor> getProfessorByFnameLname(String fname, String lname);
}
