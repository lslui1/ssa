package ssa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssa.dao.IClassDAO;
import ssa.entity.Class;

@Service
public class ClassService implements IClassService{

	@Autowired
	private IClassDAO ClassDAO;

	@Override
	public List<Class> getAllClasses() {
		return ClassDAO.getAllClasses();
	}
	
	@Override
	public List<Class> getAllClassesByProf(Integer instructorId) {
		return ClassDAO.getAllClassesByProf(instructorId);
	}

	@Override
	public List<Class> getAllClassesBySubject(String name) {
		return ClassDAO.getAllClassesBySubject(name);
	}
	
	@Override
	public List<Class> getAllClassesBySubjectSection(String name, Integer section) {
		return ClassDAO.getAllClassesBySubjectSection(name, section);
	}
	
	@Override
	public Class getClassById(int aClassId) {
		return ClassDAO.getClassById(aClassId);
	}

	@Override
	public boolean addClass(Class aClass) {
		return ClassDAO.addClass(aClass);
	}

	@Override
	public void updateClass(Class aClass) {
		ClassDAO.updateClass(aClass);
	}

}
