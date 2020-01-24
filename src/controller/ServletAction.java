package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Customer;
import bean.LoginBody;
import service.Service;
import DAO.DBoperation;

import java.text.SimpleDateFormat; 


/**
 *  implementation class ServletAction
 */
public class ServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		String s=(String)request.getParameter("action");
		System.out.println(s);
		
		
		
		int n,m;
		ArrayList<Account> al = new ArrayList<Account>();
		//ArrayList<Integer> all = new ArrayList<Integer>();
		int[] array=new int[3];
		PrintWriter out=response.getWriter();
		DBoperation d=new DBoperation();
		Service ser = new Service();
		
		
		//LOGIN
		
		if(s.equalsIgnoreCase("Login"))
		{
			LoginBody l=new LoginBody();
			l.setLoginid(request.getParameter("loginid"));
			l.setPassword(request.getParameter("password"));
			n=ser.loginvalidate(l);
			if(n==2)
				response.sendRedirect("searchhome.jsp");
			else if(n==1)
				out.print("Incorrect password");
			else
				out.print("norecord found");
		}
		
		
		//DEPOSIT

		else if(s.equalsIgnoreCase("deposit"))
		{
			
			int amount = Integer.parseInt(request.getParameter("amount"));
			System.out.println(amount);
			int accId = Integer.parseInt(request.getParameter("accountId"));
			
			System.out.println(accId);
			try
			{
				int newBal = ser.deposit(accId, amount);
				
				if(newBal == -1)
				{
					/*out.write("<body bgcolor=#FFF8DC>");
					out.write("<font size=20>invalid accountId</font><br><br>");
					out.write("<a href=refer.jsp>Home</a>");*/
					RequestDispatcher rd=request.getRequestDispatcher("traninvalidaccount.jsp");
					rd.forward(request, response);	
				}
				else
				{
					//all.add(newBal);
					//all.add(newBal+amount);
					array[0]=newBal;
					array[1]=(newBal+amount);
					request.setAttribute("list", array);
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
					/*
				out.write("<body bgcolor=#FFF8DC>");
				out.write("<font size=4>old balance is:</font>"+newBal+"<br>");
				out.write("<br>");
				out.write("<font size=4>new balance is:</font>"+(newBal + amount)+"<br>");
				
				out.write("<br><br>");
				out.write("<a href=refer.jsp>Home</a>");
				*/
				}
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		
		//WITHDRAW
		
		else if(s.equalsIgnoreCase("withdraw"))
		{
			
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			int accId = Integer.parseInt(request.getParameter("accountId"));
			
			try
			{
				int newBal = ser.withdraw(accId, amount);
				System.out.println(newBal);
				

				if(newBal == -2)
				{
					/*out.write("<body bgcolor=#FFF8DC>");
					out.write("<font size=20>invalid accountId</font><br><br>");
					out.write("<a href=refer.jsp>Home</a>");
					
					*/
					RequestDispatcher rd=request.getRequestDispatcher("traninvalidaccount.jsp");
					rd.forward(request, response);		
				}
				else if(newBal==-1)
				{
					//out.write("<body bgcolor=#FFF8DC>");
										

					/*out.print("<font size=10>insufficient balance.Please enter lesser amount</font>");
					out.write("<br><br>");
					
					out.write("<a href=refer.jsp>Home</a>");*/
					
					RequestDispatcher rd=request.getRequestDispatcher("traninvalidbal.jsp");
					rd.forward(request, response);	
					
				}
				
				
				else
				{
					
				/*out.write("<body bgcolor=#FFF8DC>");
				
				out.write("<font size=4>new balance is:"+(newBal - amount)+"</font><br><br>");
				out.write("<font size=4>old balance is:"+(newBal)+"</font><br><br>");
				out.write("<br><br>");
				
				out.write("<a href=refer.jsp>Home</a>");*/
				
				
				array[0]=newBal;
				array[1]=(newBal-amount);
				request.setAttribute("list", array);
				RequestDispatcher rd=request.getRequestDispatcher("Success1.jsp");
				rd.forward(request, response);
				
				}
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
				
		}
		
		
		//TRANSFER
		
		
		else if(s.equalsIgnoreCase("transfer"))
		{
			
			int targetbal = 0;
			int sourcebal = 0;
			
			int checkbal = 0;
			
			int sid = 2;
			int tid = 2;
			
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			int accId = Integer.parseInt(request.getParameter("sid"));
			int t_accId = Integer.parseInt(request.getParameter("tid"));
			
			
			try {
				 sid = d.validateAccountId(accId);
				 tid = d.validateAccountId(t_accId);
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			if((sid==1)&&(tid==1))
			{
			
			try 
			{
				checkbal = ser.getSourceBalance(accId);
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(checkbal<amount)
			{
				/*out.write("<body bgcolor=#FFF8DC>");
				

				out.print("<font size=10>insufficient balance.Please enter lesser amount to transfer</font>");
				out.write("<br><br>");
				
				out.write("<a href=refer.jsp>Home</a>");*/
				
				
				RequestDispatcher rd=request.getRequestDispatcher("traninvalidbal.jsp");
				rd.forward(request, response);	
			}
			else
			{
			try
			{
				
				targetbal = ser.deposit(t_accId, amount);
				sourcebal = ser.withdraw(accId, amount);
				
				/*out.write("<body bgcolor=#FFF8DC>");
				out.write("<table border=1");
				out.write("<tr>");
				out.write("<td colspan=2>"+"Source Account"+"</td>"+"<td colspan=2>"+"Target Account"+"</td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td>"+"Old Balance"+"</td>"+"<td>"+"New Balance"+"</td>"+"<td>"+"Old Balance"+"</td>"+"<td>"+"New Balance"+"</td>");
				out.write("</tr>");
				out.write("<tr>");
				out.write("<td>"+sourcebal+"</td>"+"<td>"+(sourcebal-amount)+"</td>"+"<td>"+targetbal+"</td>"+"<td>"+(targetbal+amount)+"</td>");
				out.write("</tr>");
				
				out.write("<a href=refer.jsp>Home</a>");*/
				
				
				array[0]=sourcebal;
				array[1]=targetbal;
				array[2]=amount;
				request.setAttribute("list", array);
				RequestDispatcher rd=request.getRequestDispatcher("Success2.jsp");
				rd.forward(request, response);
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			}
			}
			else if((sid==0)||(tid==0))
			{
	/*			out.write("<body bgcolor=#FFF8DC>");
				out.write("<font size=20>invalid accountId</font><br><br>");
				out.write("<a href=refer.jsp>Home</a>");*/
			
				RequestDispatcher rd=request.getRequestDispatcher("traninvalidaccount.jsp");
				rd.forward(request, response);		
			}
			
		}
		
		
		//MINI-STATEMENT (1)
		
		else if(s.equalsIgnoreCase("get"))
		{
			int validate = 0;
			
			int no_of_trans = Integer.parseInt(request.getParameter("trans"));
			
			int accId = Integer.parseInt(request.getParameter("id"));
			
			try {
				validate = d.validateAccountId(accId);
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(validate == 1)
			{
			ResultSet rs=null;
			int i=0;
			try
			{
				rs=ser.getStatement(accId, no_of_trans);
				/*out.write("<body bgcolor=#FFF8DC>");
				out.write("<table border=1");
				out.write("<tr>");
				out.write("<td>"+"Trans_Id"+"</td>"+"<td>"+"Date and Time"+"</td>"+"<td>"+"Trans_Type"+"</td>"+"<td>"+"Account_Id"+"</td>"+"<td>"+"Balance"+"</t>");
				out.write("</tr>");
				while(rs.next())
				{
					i++;
				out.write("<tr>");
				out.write("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getTimestamp(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getInt(4)+"</td>"+"<td>"+rs.getInt(5)+"</td>");
				out.write("</tr>");
				if(i>=no_of_trans)
					break;
				}
				
				out.write("<a href=refer.jsp>Home</a>");*/
				
				
				request.setAttribute("list", rs);
				request.setAttribute("tran_num", no_of_trans);
				RequestDispatcher rd=request.getRequestDispatcher("Success3.jsp");
				rd.forward(request, response);
				
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
			
			else
			{
				/*out.write("<body bgcolor=#FFF8DC>");
				out.write("<font size=20>invalid accountId</font><br><br>");
				out.write("<a href=refer.jsp>Home</a>");*/
				
				RequestDispatcher rd=request.getRequestDispatcher("traninvalidaccount.jsp");
				rd.forward(request, response);		
			}
			
			
		}
		
		
		//MINI-STATEMENT (2)
		
		else if(s.equalsIgnoreCase("getStatement"))
		{
			
			int validate = 0;
		
			System.out.println("servletaction");
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			int accId = Integer.parseInt(request.getParameter("aid"));
			String sdate=null;
			sdate = request.getParameter("sd");  	
			String edate = null;
			edate =  request.getParameter("ed"); 
			
			//int accId = Integer.parseInt(request.getParameter("id"));
			ResultSet rs=null;
			

			try {
				validate = d.validateAccountId(accId);
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(validate == 1)
			{
			
			try
			{
				rs=ser.getStatementByDate(accId, sdate, edate);
				/*out.write("<body bgcolor=#FFF8DC>");
				out.write("<table border=1");
				out.write("<tr>");
				out.write("<td>"+"Trans_Id"+"</td>"+"<td>"+"Date and Time"+"</td>"+"<td>"+"Trans_Type"+"</td>"+"<td>"+"Account_Id"+"</td>"+"<td>"+"Balance"+"</td>");
				out.write("</tr>");
				while(rs.next())
				{
				
				out.write("<tr>");
				out.write("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getTimestamp(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getInt(4)+"</td>"+"<td>"+rs.getInt(5)+"</td>");
				out.write("</tr>");
				
					
				}
				
				*/
				
				request.setAttribute("list", rs);
				RequestDispatcher rd=request.getRequestDispatcher("Success4.jsp");
				rd.forward(request, response);
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
			
			else
			{
				/*out.write("<body bgcolor=#FFF8DC>");
				out.write("<font size=20>invalid accountId</font><br><br>");
				out.write("<a href=refer.jsp>Home</a>");*/
				
				RequestDispatcher rd=request.getRequestDispatcher("traninvalidaccount.jsp");
				rd.forward(request, response);		
			}
			
		}
		
		
		//VIEW ACCOUNT
		
		else if(s.equalsIgnoreCase("view"))
		{
			
			int accId = Integer.parseInt(request.getParameter("cId"));
			try {
			ResultSet rs=d.viewCustomer(accId);
			request.setAttribute("rs1", rs);
			RequestDispatcher rd=request.getRequestDispatcher("DeleteCustomer.jsp");
			rd.forward(request, response);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//DELETE ACCOUNT
		
		else if(s.equalsIgnoreCase("delete"))
		{
			//System.out.print("welcome here hello");
			int accId = Integer.parseInt(request.getParameter("del"));
			try {
				n=d.deleteCustomer(accId);
				System.out.println("hello");
				if(n==1)
					out.print("Account with id "+accId+" is successfully deleted");
				else
					out.print("not deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		//------------------------------------------------------------//
		
		
		
		
							//SUPPORTING CASES//


		//------------------------------------------------------------//
		
		
		
		
		
		
		
		
		
		
		
		else if(s.equalsIgnoreCase("add"))
		{
			Customer t=new Customer();
			t.setSsnId(Integer.parseInt(request.getParameter("id")));
			t.setName(request.getParameter("name"));
			t.setAddress1(request.getParameter("line1"));
			t.setAddress2(request.getParameter("line2"));
			t.setCity(request.getParameter("city"));
			t.setState(request.getParameter("state"));
			n=d.addCustoemr(t);
			if(n==1)
			{
				out.print("success");
				m=d.UpdateCustomerStaus(t);
				if(m==1)
					out.print("status updated");
				else
					out.print("status not updated"); 
			}
			else
				response.sendRedirect("failure1.jsp");
		}
		else if(s.equalsIgnoreCase("create"))
		{
			n=d.accountCreation(Integer.parseInt(request.getParameter("id")),request.getParameter("type"),Integer.parseInt(request.getParameter("amount")));
			if(n==1)
			{
				out.print("created");
			}
			else
				out.print("not created");
		}
		
		else if(s.equalsIgnoreCase("displayaccount"))
		{
			al = d.displayDetails(Integer.parseInt(request.getParameter("accountid")));
			/*request.setAttribute("name", al);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);*/
			//out.write("hello");
			out.write("<table border=1>");
			for(Account t1:al)
			{
			out.write("<tr>");
			out.write("<td>"+"hello"+"</td>"+"<td>"+t1.getAccountBalance()+"</td>"+"<td>"+t1.getStatus()+"</td>"+"<td>"+t1.getAccountType()+"</td>"+"<td>"+t1.getAccountId()+"</td>");
			out.write("</tr>");
			}
			out.write("</table>");
			
			//response.sendRedirect("success.jsp");
		}
		
		
		
	}
	
}
