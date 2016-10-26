package ssa.service;

import java.util.List;

import ssa.entity.CombinedClass;
import ssa.entity.SavedClasses;

public interface ISavedClassesService {

	List<CombinedClass> getSavedClassesById(int login_id);
	List<CombinedClass> getSavedClassesByLoginClassId(int login_id, int class_id);
	SavedClasses getSavedClassById(int login_id, int class_id);
	SavedClasses getSavedClassByDatabaseId(int id);
	void deleteSavedClass(int id);
	void insertSavedClass(SavedClasses savedClass);
}
