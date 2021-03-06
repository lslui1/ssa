package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.ILoginDAO;
import ssa.entity.Login;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	private ILoginDAO loginDAO;


	@Override
	public Login getLoginById(String user_name) {
		return loginDAO.getLoginById(user_name);
		}
	
	@Override
	public Login getLoginByDatabaseId(Integer id) {
		return loginDAO.getLoginByDatabaseId(id);
	}
	
	@Override
	public boolean doesLoginExist(String user_name) {
		return loginDAO.doesLoginExist(user_name);
	}
	
	@Override
	public void deleteLogin(Integer id) {
		loginDAO.deleteLogin(id);
	}
	
	@Override
	public void insertLogin(Login login) {
		loginDAO.insertLogin(login);
	}
	
	@Override
	public void changePassword(Login login) {
		loginDAO.changePassword(login);
	}

}
