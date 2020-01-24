package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Customer;
import DAO.DBUtil;

public class CustomerDAO {
	DBUtil db = new DBUtil();
	Connection conn = null;
	PreparedStatement preparedStatement=null,ps1=null;
	ResultSet resultSet=null;
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int k=0;
		int custID=0;
		String msg=null;
		conn=db.getConnection();
		PreparedStatement preparedStatement1=conn.prepareStatement("select cus_id.nextval from dual");
	resultSet =preparedStatement1.executeQuery();
	System.out.println("after seqyuenve");
	System.out.println(resultSet);
	while(resultSet.next())
	{
		custID=resultSet.getInt(1);
	}
	System.out.println(custID);
		PreparedStatement preparedStatement=conn.prepareStatement("insert into customerDetails values(?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)");
		preparedStatement.setInt(1, customer.getSsnId());
		System.out.println(customer.getSsnId());
		preparedStatement.setInt(3, custID);
		System.out.println(custID);
		preparedStatement.setString(2,customer.getName());
		System.out.println(customer.getName());
		preparedStatement.setInt(4, customer.getAge());
		System.out.println(customer.getAge());
		preparedStatement.setString(5, customer.getAddress1());
		preparedStatement.setString(6, customer.getAddress2());
		preparedStatement.setString(7,customer.getCity());
		preparedStatement.setString(8, customer.getState());
		k =preparedStatement.executeUpdate();
		if(k>0)
		{
			msg="Customer creation Successfully with Customer ID:-"+custID ;
		}
		PreparedStatement preparedStatement2=conn.prepareStatement("insert into customerStatus values(?,?,?,CURRENT_TIMESTAMP)");
		preparedStatement2.setInt(1, customer.getSsnId());
		
		preparedStatement2.setInt(2, custID);
		preparedStatement2.setString(3,"InProgress");
		preparedStatement2.executeUpdate();
		
		
		return msg;
	}
	public Customer getCustomerDetails(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Customer customerobj=null;
		conn=db.getConnection();
    	preparedStatement=conn.prepareStatement("select * from customerDetails where customerId=? ");
    	preparedStatement.setInt(1, customerId);
    	
    	resultSet=preparedStatement.executeQuery();
    	while(resultSet.next())
    	{
    		customerobj=new Customer(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3), resultSet.getInt(4),resultSet.getString(5) ,resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
    	}
    	
		return customerobj;
	}
	
	 public String confirmdelete(int id) throws SQLException, ClassNotFoundException{
	    	
	    	int rowsDeleted=0,rs=0;
	    	String message="Error in deleting customer";
	    	try {
				conn=db.getConnection();
			    ps1=conn.prepareStatement("delete from customerStatus where customerId=?");
				preparedStatement=conn.prepareStatement("delete from customerDetails where customerId=?");
			    ps1.setInt(1, id);
			    preparedStatement.setInt(1, id);
			    rs=ps1.executeUpdate();
		    	rowsDeleted=preparedStatement.executeUpdate();
		    	
	    	}
	    	finally{
	    		db.closeConnection(conn);
	    	}
	    	if(rowsDeleted==1){
	    		message="Deleted Successfully";
	    	}
			return message;
	    	
	    }
	 public String updatecustomer(Customer customer) throws ClassNotFoundException, SQLException
	    {
	    	int rowsUpdated=0;
	    	String message="Error in updating Customer";

	    	conn=db.getConnection();
	    	preparedStatement=conn.prepareStatement("update customerDetails set customerName=?,age=?,addressLine1=?,addressLine2=?,city=?,state=? where customerId=?");
	        preparedStatement.setString(1,customer.getName() );
	        preparedStatement.setInt(2, customer.getAge());
	        preparedStatement.setString(3, customer.getAddress1());
	        preparedStatement.setString(4, customer.getAddress2());
	        preparedStatement.setString(5, customer.getCity());
	        preparedStatement.setString(6, customer.getState());
	        preparedStatement.setInt(7, customer.getCustomerId());
	        rowsUpdated=preparedStatement.executeUpdate();
	        if(rowsUpdated>0)
	        {
	        	message="Successfully updated";
	        }
			return message;
	    }
	 public ArrayList<Customer> viewAccountStatus() {
			ArrayList<Customer> al=new ArrayList<Customer>();
			DBUtil db=new DBUtil();
			  Connection con=db.getConnection();
			  Statement st=null;
			  ResultSet rs=null;
			  String query="select * from customerStatus";
			  try {
				st=con.createStatement();
				rs=st.executeQuery(query);
				while(rs.next())
				{
					int s_id=rs.getInt("ssnId");
					int c_id=rs.getInt("customerId");
					String updated=rs.getString("lastUpdated");
					String status=rs.getString("customerStatus");
					Customer c=new Customer(s_id, c_id, status, updated);
				
					al.add(c);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
	 public int updateStatus(int ssnId,int custId) {
			int a=0;
			DBUtil db=new DBUtil();
			Connection con=db.getConnection();
			PreparedStatement pst=null;
			PreparedStatement pst1=null;
			ResultSet rs=null;
			String q1="select extract(hour from (current_timestamp-lastUpdated))hrs from customerDetails where ssnID=?";
	        try {
				pst=con.prepareStatement(q1);
				pst.setInt(1,ssnId);
				rs=pst.executeQuery();
				while(rs.next())
				{
					int hr=rs.getInt(1);
					System.out.println(hr);
					if(hr>=1)
					{
						String q2="update customerStatus set customerStatus='Activated' where ssnId=? and customerId=?";
						pst1=con.prepareStatement(q2);
						pst1.setInt(1,ssnId);
						pst1.setInt(2,custId);
						a=pst1.executeUpdate();
						
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return a;
			
		}


}
