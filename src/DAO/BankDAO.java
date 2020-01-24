package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Account;
import bean.Customer;

public class BankDAO {

	public ArrayList<Customer> searchCustomer(int ssn_id,int cust_id)
	{
		ArrayList<Customer> custlist=new ArrayList<>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select ssnId,customerId,customerName,age,concat((concat((concat(addressLine1,', ')),(concat(addressLine2,', ')))),city) as address from customerDetails where ssnId=? and customerId=?");
			ps.setInt(1, ssn_id);
			
			ps.setInt(2, cust_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Customer cus=new Customer();
				cus.setSsnId(rs.getInt(1));
				System.out.println(cus.getSsnId());
				cus.setCustomerId(rs.getInt(2));
				System.out.println(cus.getCustomerId());
				cus.setName(rs.getString(3));
				cus.setAge(rs.getInt(4));
				cus.setAddress1(rs.getString(5));
				custlist.add(cus);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return custlist;
	}

	public ArrayList<Customer> searchCustomer(int ssn_id) {

		ArrayList<Customer> custlist=new ArrayList<>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select ssnId,customerId,customerName,age,concat((concat((concat(addressLine1,', ')),(concat(addressLine2,', ')))),city) as address from customerDetails where ssnId=?");
			ps.setInt(1, ssn_id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Customer cus=new Customer();
				cus.setSsnId(rs.getInt(1));
				cus.setCustomerId(rs.getInt(2));
				cus.setName(rs.getString(3));
				cus.setAge(rs.getInt(4));
				cus.setAddress1(rs.getString(5));
				custlist.add(cus);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return custlist;
	}

	public ArrayList<Customer> searchCustomerbyId(int cusid) {

		ArrayList<Customer> custlist=new ArrayList<>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select ssnId,customerId,customerName,age,concat((concat((concat(addressLine1,', ')),(concat(addressLine2,', ')))),city) as address from customerDetails where customerId=?");
			ps.setInt(1, cusid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Customer cus=new Customer();
				cus.setSsnId(rs.getInt(1));
				cus.setCustomerId(rs.getInt(2));
				cus.setName(rs.getString(3));
				cus.setAge(rs.getInt(4));
				cus.setAddress1(rs.getString(5));
				custlist.add(cus);
				System.out.println(custlist);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return custlist;
	}
public ArrayList<Account> searchAccount(int ssnid,int custid,String type) {
		
		ArrayList<Account> acctlist=new ArrayList<>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select a.customerId,a.accountId,a.accountType,a.amount from accountDetails a join customerStatus c on a.customerId=c.customerId where c.ssnId=? and a.customerId=? and a.accountType=?");
			ps.setInt(1, ssnid);
			ps.setInt(2, custid);
			ps.setString(3, type);
		    ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Account acc=new Account();
				
				acc.setCustomerId(rs.getInt(1));
				acc.setAccountId(rs.getInt(2));
				acc.setAccountType(rs.getString(3));
				acc.setAccountBalance(rs.getInt(4));
				acctlist.add(acc);
				System.out.println(acctlist);
		 
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return acctlist;
	}
public ArrayList<Account> searchAccountbySsnId(int ssnid,String type) {
	
	ArrayList<Account> acctlist=new ArrayList<>();
	try
	{   
		System.out.println("inside dao");
		Connection con=DBConnection.getConnection();
		String query="select a.customerId,a.accountId,a.accountType,a.amount from accountDetails a join customerStatus c on a.customerId=c.customerId where c.ssnId=? and a.accountType=?";
		PreparedStatement ps1=con.prepareStatement(query);
		ps1.setInt(1, ssnid); 
		ps1.setString(2, type);
		System.out.println(ssnid);
		System.out.println(type);
		ResultSet rs1=ps1.executeQuery();
		System.out.println(rs1);
		while(rs1.next())
		{
			System.out.println("inside dao");
			Account acc=new Account();
			acc.setCustomerId(rs1.getInt(1));
			acc.setAccountId(rs1.getInt(2));
			acc.setAccountType(rs1.getString(3));
			acc.setAccountBalance(rs1.getInt(4));
			acctlist.add(acc);
			System.out.println(acctlist);
	 
		}

	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch(ClassNotFoundException e1)
	{
		e1.printStackTrace();
	
	}
	return acctlist;
}
public ArrayList<Account> searchAccountbyCustId(int custid,String acct) {
	
	ArrayList<Account> acctlist=new ArrayList<>();
	try
	{   System.out.println(custid);
	System.out.println(acct);
		System.out.println("inside dao");
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select customerId,accountId,accountType,amount from accountDetails where customerId=? and accountType=?");
		ps.setInt(1, custid); 
		ps.setString(2, acct);
		System.out.println(acct);
	    ResultSet rs=ps.executeQuery();
	    System.out.println(rs);
		while(rs.next())
		{
			System.out.println("inside dao");
			Account acc=new Account();
			acc.setCustomerId(rs.getInt(1));
			acc.setAccountId(rs.getInt(2));
			acc.setAccountType(rs.getString(3));
			acc.setAccountBalance(rs.getInt(4));
			acctlist.add(acc);
			System.out.println(acctlist);
	 
		}

	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch(ClassNotFoundException e1)
	{
		e1.printStackTrace();
	
	}
	return acctlist;
}

	public ArrayList<Account> searchCustomerbyAccId(int accid) {
		
		ArrayList<Account> acctlist=new ArrayList<>();
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select customerId,accountId,accountType,amount from accountDetails  where accountId="+accid+"");
		    ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Account acc=new Account();
				acc.setCustomerId(rs.getInt(1));
				acc.setAccountId(rs.getInt(2));
				acc.setAccountType(rs.getString(3));
				acc.setAccountBalance(rs.getInt(4));
				acctlist.add(acc);
		 
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return acctlist;
	}
	public ArrayList<Account> searchAccountWithAccSsnId(int accid, int ssnid) 
	{
		ArrayList<Account> acctlist=new ArrayList<>();
		try
		{
			System.out.println("inside dao");
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select a.customerId,a.accountId,a.accountType,a.amount from accountDetails a join customerStatus c on a.customerId=c.customerId where c.ssnId=? and a.accountId=?");
			ps.setInt(1, ssnid); 
			ps.setInt(2,accid);
		    ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Account acc=new Account();
				acc.setCustomerId(rs.getInt(1));
				acc.setAccountId(rs.getInt(2));
				acc.setAccountType(rs.getString(3));
				acc.setAccountBalance(rs.getInt(4));
				acctlist.add(acc);
				System.out.println(acctlist);
		 
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return acctlist;
	}
	

	public ArrayList<Account> searchAccountbyId(int accid,int custid) {
		ArrayList<Account> acctlist=new ArrayList<>();
		try
		{
			System.out.println("inside dao");
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select customerId,accountId,accountType,amount from accountDetails where customerId=? and accountId=?");
			ps.setInt(1, custid); 
			ps.setInt(2,accid);
		    ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("inside dao");
				Account acc=new Account();
				acc.setCustomerId(rs.getInt(1));
				acc.setAccountId(rs.getInt(2));
				acc.setAccountType(rs.getString(3));
				acc.setAccountBalance(rs.getInt(4));
				acctlist.add(acc);
				System.out.println(acctlist);
		 
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		
		}
		return acctlist;
	}

}