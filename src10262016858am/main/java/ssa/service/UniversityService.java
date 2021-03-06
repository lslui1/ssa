package ssa.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssa.dao.IUniversityDAO;
import ssa.entity.University;

@Service
public class UniversityService implements IUniversityService{

	@Autowired
	private IUniversityDAO UniversityDAO;
	
	@Override
	public University getUniversityById(int universityId) {
		return UniversityDAO.getUniversityById(universityId);
	}

	@Override
	public List<University> getUniversityByName(String name) {
		return UniversityDAO.getUniversityByName(name);
	}
	
	@Override
	public List<University> getAllUniversities() {
		return UniversityDAO.getAllUniversities();
	}
}
