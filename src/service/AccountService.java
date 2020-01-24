package service;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.Account;
import DAO.Dao;


public class AccountService {
	public int addAccount(Account acc) throws SQLException{
		int rowsAffected=0;
		try{
		System.out.println("inside service");
		Dao dao=new Dao();
		rowsAffected = dao.addAccount(acc);
		}catch(SQLException e){
			e.printStackTrace();
	}
		return rowsAffected;
	}
	public ArrayList<Account> viewDeleteAccount(int custId,int ssnId)
	{
		Dao dao=new Dao();
		ArrayList<Account> al=new ArrayList<Account>();
		try {
			al=dao.viewDeleteAccount(custId,ssnId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	public int deleteAccount(int cusId,int acntId)
	{
		System.out.println("inside service");
		System.out.println(cusId);
		System.out.println(acntId);
		Dao dao=new Dao();
		int a=dao.deleteAccount(cusId,acntId);
		return a;
	}
	public ArrayList<Account>viewAccountStatus()
	{
		Dao dao=new Dao();
		ArrayList<Account> al=new ArrayList<Account>();
	    al=dao.viewAccountStatus();
	    return al;
	}
	public int updateStatus(int cusId,int accId) {
		Dao dao=new Dao();
       int a=dao.updateStatus(cusId,accId);
		return a;
	}
	public String chkLogin(String username, String password) {
		// TODO Auto-generated method stub
		Dao dao=new Dao();
		String bool=dao.chkLogin(username,password);
		return bool;
	}
	public ArrayList<Account> viewAccountStatus(int cusId, int accId) {
		Dao dao=new Dao();
		ArrayList<Account> al=new ArrayList<Account>();
	    al=dao.viewAccountStatus(cusId,accId);
	    return al;
	}
}
