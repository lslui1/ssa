package ssa.service;

import java.util.List;

import ssa.entity.Class;

public interface IClassService {

	Class getClassById(int aClassId);
	boolean addClass(Class aClass);
	void updateClass(Class aClass);
	List<Class> getAllClassesByProf(Integer instructorId);
	List<Class> getAllClassesBySubject(String name);
	List<Class> getAllClassesBySubjectSection(String name, Integer section);

}
