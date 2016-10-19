package ssa.service;

import java.util.List;

import ssa.entity.Login;

public interface ILoginService {

	Login getLoginById(String user_name);
	Login getLoginByDatabaseId(Integer id);
	boolean doesLoginExist(String user_name);
	void deleteLogin(Integer id);
	void insertLogin(Login login);
	void changePassword(Login login);
}
