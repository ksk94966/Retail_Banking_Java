   package DAO;
import java.sql.*;
public class DBConnection {
private static final String url="jdbc:oracle:thin:@172.24.137.13:1521:XE";
private static final String user="EJ1334820";
private static final String password="EJ1334820";
private static final String driver="oracle.jdbc.driver.OracleDriver";
public static Connection getConnection()throws ClassNotFoundException,SQLException
{
	Connection con=null;
	Class.forName(driver);
	con=DriverManager.getConnection(url, user, password);
	return con;
	
}
/*public void closeConnection(Connection con)throws ClassNotFoundException,SQLException
{
	con.close();
}*/

}
