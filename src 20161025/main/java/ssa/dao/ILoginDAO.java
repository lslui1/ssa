package ssa.dao;

import ssa.entity.Login;

public interface ILoginDAO {
	
	boolean doesLoginExist(String user_name);
	Login getLoginById(String user_name);
	Login getLoginByDatabaseId(Integer id);
	void deleteLogin(Integer id);
	void insertLogin(Login login);
	void changePassword(Login login);

}
