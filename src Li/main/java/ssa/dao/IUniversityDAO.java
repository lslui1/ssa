package ssa.dao;

import java.util.List;
import ssa.entity.University;

public interface IUniversityDAO {

	University getUniversityById(int universityId);
	List<University> getAllUniversities();
}
