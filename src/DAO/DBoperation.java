package DAO;

import java.sql.*;
import java.util.ArrayList;
import bean.Account;
import bean.Customer;
import bean.LoginBody;


public class DBoperation 
{
	private String un="EJ1334820";
	private String pw="EJ1334820";
	private String url="jdbc:oracle:thin:@172.24.137.13:1521:XE";
	Connection con=null;

	ArrayList<Integer> al = new ArrayList<Integer>();
	
	public Connection getConnection()
	{
		try
		{
			con=DriverManager.getConnection(this.url, this.un, this.pw);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
	public static java.sql.Date getCurrentDate() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getDate());

	}
	
	
	//METHOD 0


	public int validateAccountId(int x) throws SQLException
	{

		con = getConnection();
		
		PreparedStatement ps2 = con.prepareStatement("select accountId from accountDetails");
		ResultSet rs2 = ps2.executeQuery();
		while(rs2.next())
		{
			al.add(rs2.getInt(1));
		}
		
		for(Integer aa:al)
		{
			if(aa==x)
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	
	//METHOD 1
	

	public int loginvalidate(LoginBody l)
	{
		con=getConnection();
		
		int n=0;
		ArrayList<String> un=new ArrayList<String>();
		
		String p=null;
		
		try
		{
			PreparedStatement ps = con.prepareStatement("select login_id from Login");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				un.add(rs.getString(1));
			for(String s:un)
			{
				if(s.equals(l.getLoginid()))
				{
					PreparedStatement ps1 = con.prepareStatement("select password from Login where login_id=?");
					ps1.setString(1, l.getLoginid());
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
						p=rs1.getString(1);
					if(p.equals(l.getPassword()))
					{
						n=2;
					}
					else
						n=1;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection(con);
		}
		return n;
	}
	
	//METHOD 2
	
	public int deposit(int x,int y) throws SQLException
	{
		con = getConnection();
		
		int bal =0;
		
		int valiate = validateAccountId(x);
		System.out.println("validate---");System.out.println(valiate);
		
		if(valiate==1)
		{
			System.out.println("inside if in dao");
		String sql = "update accountDetails set amount = (amount+?) where accountId= ?";
		String sql1 = "select amount from accountDetails where accountId = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, y);
		ps.setInt(2, x);
		
		
		
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, x);
		
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			bal = rs.getInt(1);
			
			
		}
		
	
		ps.executeQuery();
		
		transactionUpdate(x, bal);
		return bal;
		}
		
	return -1;
		
	}
	
	//METHOD 3
	
	public int getSourceBalance(int x) throws SQLException
	{
		con = getConnection();
		
		int bal =0;
			
		String sql = "select amount from accountDetails where accountId = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, x);
		
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next())
		{
			bal = rs.getInt(1);
			
		}
		
		
		return bal;
		
		

		
	}
	
	//METHOD 4
	
	public int withdraw(int x,int y) throws SQLException
	
	{
		con = getConnection();
		
		int bal =0;
		

		int valiate = validateAccountId(x);
		
		if(valiate==1)
		{
			
		
		String sql = "update accountDetails set amount = (amount-?) where accountId= ?";
		String sql1 = "select amount from accountDetails where accountId = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, y);
		ps.setInt(2, x);
		
		
		
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, x);
		
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			bal = rs.getInt(1);
			
		}
		if(bal<y)
		{
			return -1;
		}
		
		ps.executeQuery();

		
		transactionUpdate(x, bal);
		
		return bal;
		}
		
		return -2;
		
	}
	
	//METHOD 5
	public ResultSet getStatement(int ac,int tr) throws SQLException
	
	{
		con = getConnection();
		
		
		String sql="select * from transactionDetails where accountId=? order by DandT desc";
		//String sql1 = "select * from transactionDetails where accountId=1001 and DandT>=to_timestamp('19-12-2017 13:24:00', 'dd-mm-yyyy hh24:mi:ss') and DandT<to_timestamp('19-12-2017 15:24:00', 'dd-mm-yyyy hh24:mi:ss');";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ac);
		//ps.setTimestamp(2, getCurrentTimeStamp());
		
		ps.executeQuery();
		
		
		ResultSet rs = ps.executeQuery();
		//while(rs.next())
		//	System.out.println(rs.getInt(1)+" "+rs.getTimestamp(2));
		return rs;
		
	}
	
	//METHOD 6
	
	public ResultSet getStatementByDate(int ac,String sdate,String edate) throws SQLException
	
	{
		con = getConnection();
		
		
		String sql="select * from transactionDetails where accountId=? and DandT > TO_DATE(?, 'mm-dd-yyyy') and DandT < TO_DATE(?, 'mm-dd-yyyy')";
		//String sql1 = "select * from transactionDetails where accountId=1001 and DandT>=to_timestamp('19-12-2017 13:24:00', 'dd-mm-yyyy hh24:mi:ss') and DandT<to_timestamp('19-12-2017 15:24:00', 'dd-mm-yyyy hh24:mi:ss');";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ac);
		ps.setString(2, sdate);
		ps.setString(3, edate);		
		
		ps.executeQuery();
		
		ResultSet rs = ps.executeQuery();
		//while(rs.next())
		//	System.out.println(rs.getInt(1)+" "+rs.getTimestamp(2));
		return rs;
		
	}
	
	//METHOD 7
	
	public void transactionUpdate(int x,int y) throws SQLException
	
	{
		con = getConnection();
		
		String sql = "insert into transactionDetails values(transac_id.nextval,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setTimestamp(1, getCurrentTimeStamp());
		ps.setString(2, "credit");
		ps.setInt(3, x);
		ps.setInt(4, y);
		
		ps.executeUpdate();
		
		
		
	}
	
	//METHOD 8
	
	public void transactionUpdate1(int x,int y) throws SQLException
	
	{
		con = getConnection();
		
		String sql = "insert into transactionDetails values(transac_id.nextval,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setTimestamp(1, getCurrentTimeStamp());
		ps.setString(2, "debit");
		ps.setInt(3, x);
		ps.setInt(4, y);
		
		ps.executeUpdate();
		
	}
	
	//------------------------------------------------------------//
	
	
	
	
						//SUPPORTING METHODS
	
	
	//------------------------------------------------------------//
	
	
	
	
	
	
	
	public ResultSet viewCustomer(int id) throws SQLException
	
	{
		//ArrayList<Integer> al=new ArrayList<Integer>();
		con=getConnection();
		ResultSet rs=null;
		
			PreparedStatement ps = con.prepareStatement("select accountId,accountType,amount from accountDetails where customerId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
		
		return rs;
	}
	public int deleteCustomer(int id) throws SQLException
	
	{
		
		con=getConnection();
		int n=0;
		
			PreparedStatement ps = con.prepareStatement("delete from transactionDetails where accountId=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("delete from accountDetails where accountId=?");
			ps1.setInt(1, id);
			n=ps1.executeUpdate();
		
		return n;
	}
	
	
	public int addCustoemr(Customer t)
	{
		con=getConnection();
		int n=0;
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into customerDetails values(?,?,?,?,?,?,?)");
			ps.setInt(1, t.getSsnId());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getAge());
			ps.setString(4, t.getAddress1());
			ps.setString(5, t.getAddress2());
			ps.setString(6, t.getCity());
			ps.setString(7, t.getState());
			n=ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection(con);
		}
		return n;
	}
	public int UpdateCustomerStaus(Customer t)
	{
		con=getConnection();
		int n=0;
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into customerStatus values(?,cus_id.nextval,?,?,?)");
			ps.setInt(1, t.getSsnId());
			ps.setString(2, "active");
			ps.setString(3, "message updated");
			ps.setTimestamp(4, getCurrentTimeStamp());
			n=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection(con);
		}
		return n;
	}
	public int accountCreation(int x,String y,int z)
	{
		con=getConnection();
		int n=0;
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into accountDetails values(?,acc_id.nextval,?,?,?,?,?)");
			ps.setInt(1, x);
			ps.setString(2, y);
			ps.setString(3, "active");
			ps.setString(4, "message updated...");
			ps.setInt(5, z);
			ps.setTimestamp(6, getCurrentTimeStamp());
			n=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection(con);
		}
		return n;
	}
	
	public ArrayList<Account> displayDetails(int x)
	{
		ArrayList<Account> al = new ArrayList<Account>();
		con=getConnection();
		
		//ResultSet s = null;
		
		try
		{
			PreparedStatement ps = con.prepareStatement("select customerId,accountId,accontType,amount from accountDetails where accountId = ?");
			ps.setInt(1, x);
		
		 ResultSet rs = ps.executeQuery();
		// s = rs;	
		 while(rs.next())
		 {
			 al.add(new Account(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4)));
		 }
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection(con);
		}
		return al;
	}
	
}
