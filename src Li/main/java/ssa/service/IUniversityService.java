package ssa.service;

import java.util.List;
import ssa.entity.University;

public interface IUniversityService {

	University getUniversityById(int universityId);
	List<University> getAllUniversities();
}
