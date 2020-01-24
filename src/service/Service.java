package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBody;
import DAO.DBoperation;

public class Service 
{
	
	DBoperation db = new DBoperation();
	
	public Service()
	{
	
	}
		
	public int loginvalidate(LoginBody l)
	{
		return db.loginvalidate(l);
	}
	
	
	public int deposit(int x,int y) throws SQLException
	{
		return db.deposit(x, y);
	}
	
	public int withdraw(int x,int y) throws SQLException
	{
		return db.withdraw(x, y);
	}
	
	public int getSourceBalance(int x) throws SQLException
	{
		return db.getSourceBalance(x);
	}
	
	public ResultSet getStatement(int ac,int tr) throws SQLException
	{
		return db.getStatement(ac, tr);
	}
	
	
	public ResultSet getStatementByDate(int ac,String sdate,String edate) throws SQLException
	{
		return db.getStatementByDate(ac, sdate, edate);
	}
}
