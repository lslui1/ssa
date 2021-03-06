package ssa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Login;

@Transactional
@Repository
public class LoginDAO implements ILoginDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
	public boolean doesLoginExist(String user_name) {
    	boolean loginCheck = false;
		 String hql = "FROM Login where user_name = '" + user_name + "'";
		 hibernateTemplate.find(hql);
		 if (hibernateTemplate.find(hql).size() > 0) {
			 loginCheck = true;
		 }
    		return loginCheck; 
    }
    @Override
	public Login getLoginById(String user_name) {
		 String hql = "FROM Login where user_name = '" + user_name + "'";
	     return (Login) hibernateTemplate.find(hql).get(0);
	}
    
    @Override
 	public Login getLoginByDatabaseId(Integer id) {
 		 String hql = "FROM Login where id = '" + id+ "'";
 	     return (Login) hibernateTemplate.find(hql).get(0);
 	}
	
	@Override
	public void deleteLogin(Integer id) {
		Login login = getLoginByDatabaseId(id);
	    hibernateTemplate.delete(login);
	}
	
	@Override
	public void insertLogin(Login login) {
	    hibernateTemplate.save(login);
	}
	
	@Override
	public void changePassword(Login login) {
	    hibernateTemplate.update(login);
	}

}


