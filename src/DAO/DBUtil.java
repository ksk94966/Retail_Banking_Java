package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
Connection con=null;

	
	public Connection getConnection(){
		System.out.println("inside conn");
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@172.24.137.13:1521:XE", "EJ1334820", "EJ1334820");
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
		
	}
	public void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
