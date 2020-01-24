package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import service.*;

/**
 *  implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside create account");
		int rows=0;
		String action=request.getParameter("action");
		System.out.println(action);
		if("login".equals(action)){
			
		}else 
			
			if("addAccount".equals(action)){
			Account acc=new Account(Integer.parseInt(request.getParameter("CustID")),request.getParameter("AType"),Integer.parseInt(request.getParameter("DepAmt")));
			System.out.println("cust id"+Integer.parseInt(request.getParameter("CustID")));
			System.out.println("type"+request.getParameter("AType"));
			System.out.println("dep amt"+request.getParameter("DepAmt"));
			AccountService aSer = new AccountService();
			try {
				rows=aSer.addAccount(acc);
			}catch(NumberFormatException n) 
			{
				System.out.println(n);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (rows>0){
				request.setAttribute("rows",rows);

				RequestDispatcher reqD=request.getRequestDispatcher("accCreationSuccessful.jsp");
				reqD.forward(request, response);}
			else{
				request.setAttribute("rows",rows);
				RequestDispatcher reqD=request.getRequestDispatcher("accCreationError.jsp");
				reqD.forward(request, response);
			}
		}else if(action.equals("viewdeleteAccount"))
		{
			try{
		int customerId=Integer.parseInt(request.getParameter("custId"));
		int ssnId=Integer.parseInt(request.getParameter("ssnId"));
		
		AccountService service=new AccountService();
		ArrayList<Account>al=new ArrayList<Account>();
		al=service.viewDeleteAccount(customerId,ssnId);
		request.setAttribute("al",al);
		RequestDispatcher rd=request.getRequestDispatcher("viewDeleteAccount.jsp");
		rd.forward(request, response);
			}
			catch(NumberFormatException n)
			{
				n.printStackTrace();
			}
		}
		
	//delete the selected account	
		else if(action.equals("deleteAccount"))
		{
			int c_id=Integer.parseInt(request.getParameter("custId"));
			int a_id=Integer.parseInt(request.getParameter("accntId"));
			System.out.println(c_id);
			System.out.println(a_id);
			AccountService service=new AccountService();
			int a=service.deleteAccount(c_id,a_id);
			if(a>=1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("deleteAccountSuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("deleteAccountFailure.jsp");
			rd.forward(request, response);
				
			}
	
		}
		
		//view account status
		else if(action.equals("accountStatus"))
		{
			ArrayList<Account>al=new ArrayList<Account>();
			AccountService service=new AccountService();
			al=service.viewAccountStatus();
			request.setAttribute("al",al);
			RequestDispatcher rd=request.getRequestDispatcher("AccountStatusResult.jsp");
			rd.forward(request,response);
		}
		else if(action.equals("refresh"))
		{
			System.out.println("bhjd");
			int cusId=Integer.parseInt(request.getParameter("custId")) ;
			System.out.println(cusId);
			ArrayList<Account>al=new ArrayList<Account>();
			int accId=Integer.parseInt(request.getParameter("accId")) ;
			System.out.println(accId);
			AccountService service=new AccountService();
			int a=service.updateStatus(cusId, accId);
			System.out.println("back after");
			if(a>=0)
			{
				al=service.viewAccountStatus(cusId,accId);
			 request.setAttribute("al",al);
			 for(Account b:al)
			 {
				 System.out.println(b.getAccountId());
			 }
				RequestDispatcher rd=request.getRequestDispatcher("StatusResult.jsp");
				rd.forward(request,response);
			
		}
	}

}
}