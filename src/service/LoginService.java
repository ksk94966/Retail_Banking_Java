package service;

import DAO.Dao;

public class LoginService {

	public String authenticate(String username, String password) {
	 Dao dao=new Dao();
	 String utype=dao.chkLogin(username,password);
	 return utype;
	 
		
	}

}
