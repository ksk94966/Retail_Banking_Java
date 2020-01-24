package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

/**
 * implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String username=request.getParameter("username");
	String password=request.getParameter("password");
	LoginService ls=new LoginService();
	String valid=ls.authenticate(username,password);
	if(valid.equals("invalid credentials"))
	{
		PrintWriter out=response.getWriter();
		out.print("Invalid Credentials");
		
		RequestDispatcher rd=request.getRequestDispatcher("InvalidLogin.jsp"); 
		rd.forward(request, response);
		
	}
	else if(valid.equals("executive"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("Executivehome.jsp"); 
		rd.forward(request, response);
	}
	else 
	{
		RequestDispatcher rd=request.getRequestDispatcher("searchhome.jsp"); 
		rd.forward(request, response);
	}
	
	

	
	
	
	
	
	
	
	
	}

}
