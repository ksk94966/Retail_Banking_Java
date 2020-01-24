package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Account;
import DAO.DBUtil;

public class Dao {
	   Connection con=null;
	   PreparedStatement ps1=null;
	   PreparedStatement ps2 = null;
	   PreparedStatement ps3 = null;
	   ResultSet rs=null;
	   ResultSet rs1=null;
	public int addAccount(Account acc) throws SQLException{
	      int id=0;
		  System.out.println("inside dao");
	       DBUtil dbutil= new DBUtil();
	       String accnt="";
	       int x=0;
	       int rowsAffected=0;
	       String nowType=acc.getAccountType();
	       System.out.println(nowType);
	       con=dbutil.getConnection();
	       String ty="";
	       int a=acc.getCustomerId();
	       String s=acc.getAccountType();
	       System.out.println(ty);
	       String q="select customerId from customerDetails where customerId=?";
	       PreparedStatement ps=con.prepareStatement(q);
	       ps.setInt(1,a);
	       rs=ps.executeQuery();
	       String cust="";
	   while(rs.next())
	   {
	        x=rs.getInt(1);
	      
	       
	   }

	   if(x==0)
	   {
		   
		   return -1;
		   
 	   }
	       else
	       { 
		       String q1="select * from accountDetails where customerId=? and accountType=?";
		       ps1=con.prepareStatement(q1);
		       System.out.println(ps1);
		      System.out.println(a);
		       System.out.println(s);
		       ps1.setInt(1,a);
		       ps1.setString(2,s);
		       rs1=ps1.executeQuery();
		       
		       while(rs1.next())
		       {
		    	    accnt=rs1.getString("accountType");
		    	 cust=rs1.getString("customerId");
		    	   System.out.println(cust);
		    	    System.out.println(accnt);
		       }
		       if(accnt=="")
		       {
		    	   PreparedStatement ps3=con.prepareStatement("select seq_acntId.nextval from dual");
		    	   ResultSet rs3=ps3.executeQuery();
		    	   while(rs3.next())
		    	   {
		    		   id=rs3.getInt(1);
		    		   System.out.println(id);
		    	   }
		    	   ps2=con.prepareStatement("insert into accountDetails values("+acc.getCustomerId()+",?,'"+acc.getAccountType()+"',"+acc.getAccountBalance()+",'In Progress','Account Creation',CURRENT_TIMESTAMP)");
				  ps2.setInt(1,id);
		    	   rowsAffected=ps2.executeUpdate();
					System.out.println("rowsaff"+rowsAffected);
		       }
		       else
		       {
		    	   System.out.println("Account already exists");
		       }
		   
	    	   
	       }
	      
	     
	       
	     
	      return id;
}
	public ArrayList<Account> viewDeleteAccount(int custId,int ssnId) throws SQLException
	{
		ArrayList<Account> al=new ArrayList<Account>();
		DBUtil db=new DBUtil();
		  Connection con=db.getConnection();
		  ResultSet rs=null;
		  PreparedStatement pst=null;
		  String query="select customerId,accountId,accountType,amount from accountDetails where customerId=?";
		  pst=con.prepareStatement(query);
		  pst.setInt(1,custId);
		  rs=pst.executeQuery();
		  while(rs.next())
		  {
			  int customerId=rs.getInt(1);
			  int acntId=rs.getInt(2);
			  String type=rs.getString(3);
			  int amnt=rs.getInt(4);
			  
			  Account ac=new Account(customerId,acntId,type,amnt);
			  al.add(ac);
		  }
	
	  
	  return al;
	  
	}

	public int deleteAccount(int cusId, int acntId) {
		System.out.println("inside dao");
		System.out.println(cusId);
		System.out.println(acntId);
		DBUtil db=new DBUtil();
		int a=0;int b=0;
		  Connection con=db.getConnection();
		  PreparedStatement pst=null;
		  String q="delete from transactionDetails where accountId=?";
		  String query="delete from accountDetails where customerId=? and accountId=?";
		  try {
			  PreparedStatement pst1=con.prepareStatement(q);
			  pst1.setInt(1,acntId);
			 b=pst1.executeUpdate();
			 System.out.println(b);
			pst=con.prepareStatement(query);
			pst.setInt(1, cusId);
			pst.setInt(2, acntId);
			a=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println(a);
		return a;
	}
	public ArrayList<Account> viewAccountStatus() {
		ArrayList<Account> al=new ArrayList<Account>();
		DBUtil db=new DBUtil();
		  Connection con=db.getConnection();
		  Statement st=null;
		  ResultSet rs=null;
		  String query="select * from accountDetails";
		  try {
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				int c_id=rs.getInt("customerId");
				int a_id=rs.getInt("accountId");
				String type=rs.getString("accountType");
				String status=rs.getString("accountStatus");
				String msg=rs.getString("message");
				String updated=rs.getString("lastUpdated");
				Account acc=new Account(c_id,a_id,type,status,msg,updated);
			
				al.add(acc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	public int updateStatus(int cusId,int accId) {
		int a=0;
		ArrayList<Account> al=new ArrayList<Account>();

		DBUtil db=new DBUtil();
		Connection con=db.getConnection();
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		ResultSet rs=null;
		
		String q1="select extract(hour from (current_timestamp-lastUpdated))hrs from ACCOUNTDETAILS where accountId=?";
        try {
			pst=con.prepareStatement(q1);
			pst.setInt(1,accId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				int hr=rs.getInt(1);
				System.out.println(hr);
				if(hr>=1)
				{
					String q2="update accountDetails set accountStatus='Activated' where customerId=? and accountId=?";
					pst1=con.prepareStatement(q2);
					pst1.setInt(1,cusId);
					pst1.setInt(2,accId);
					a=pst1.executeUpdate();
				System.out.println(a);
				}	
					}
				}
			
		
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return a;
		
	}
	public String chkLogin(String username, String password) {
		// TODO Auto-generated method stub
		DBUtil dbutil=new DBUtil();
		Boolean x=false;
		String utype = null;
		try {
			Connection con=dbutil.getConnection();
			String query="select loginId,password from userStore where loginId=? and password=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				System.out.println("Correct credentials");
				x=true;
			}
			if(x==true)
			{
				String querytype="select userType from  userStore where loginId=? ";
				PreparedStatement ps=con.prepareStatement(querytype);
				ps.setString(1, username);
				ResultSet r=ps.executeQuery();
				while(r.next()){
					System.out.println("r.getInt(1)");
					utype= r.getString(1);
				}
				
			}
			else
			{
				
				utype="invalid credentials";
				
			}
	
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stud
		
		return utype;
		
	}
	
	public boolean authenticate(String username, String password) {
		
		
		
		
		
		return false;
	}
	public ArrayList<Account> viewAccountStatus(int cusId, int accId) {
		
		ArrayList<Account> al=new ArrayList<Account>();
		DBUtil db=new DBUtil();
		  Connection con=db.getConnection();
		  PreparedStatement st=null;
		  ResultSet rs=null;
		  System.out.println(cusId);
		  System.out.println(accId);

		  String query="select * from accountDetails where customerId=? and accountId=?";
		  try {
			st=con.prepareStatement(query);
		    st.setInt(1,cusId);
		    st.setInt(2,accId);
			rs=st.executeQuery();
			while(rs.next())
			{
				int c_id=rs.getInt("customerId");
				int a_id=rs.getInt("accountId");
				String type=rs.getString("accountType");
				String status=rs.getString("accountStatus");
				String msg=rs.getString("message");
				String updated=rs.getString("lastUpdated");
				Account acc=new Account(c_id,a_id,type,status,msg,updated);
			
				al.add(acc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
}
