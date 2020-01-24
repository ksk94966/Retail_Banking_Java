package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Customer;
import service.customerService;

/**
 *implementation class CustomerController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		System.out.println(action);
		customerService cs=new customerService();
	if("searchCustomer".equalsIgnoreCase(action))
		{
		PrintWriter out = response.getWriter();
			System.out.println("inside controller");
			if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))==""))
			{
				try
				{
			int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
			System.out.println("the ssnid is"+ ssnid);
			ArrayList<Customer> cuslist=cs.searchCustomer(ssnid);
			if(cuslist.isEmpty())
			{
				RequestDispatcher rd=request.getRequestDispatcher("errorcustomer.jsp");
				rd.forward(request, response);
			}
			else
			{
			request.setAttribute("cuslist", cuslist);	
			RequestDispatcher rd=request.getRequestDispatcher("viewResult.jsp");
			rd.forward(request, response);
			}
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			}
			else if(((request.getParameter("ssnid"))=="")&&((request.getParameter("custid"))!=""))
			{
				try
				{
				int cusid=Integer.parseInt(request.getParameter("custid").toString());
				System.out.println("the custid is"+ cusid);
				ArrayList<Customer> cuslist=cs.searchCustomerbyId(cusid);
				if(cuslist.isEmpty())
				{

					RequestDispatcher rd=request.getRequestDispatcher("errorcustomer.jsp");
					rd.forward(request, response);
				}
				else
				{
				request.setAttribute("cuslist", cuslist);	
				RequestDispatcher rd=request.getRequestDispatcher("viewResult.jsp");
				rd.forward(request, response);
				}
			}
				catch(NumberFormatException e)
				{
					e.printStackTrace();
				}
			}
			else if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))!=""))
			{
				try
				{
				int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
				System.out.println("the ssnid is"+ ssnid);
				int cusid=Integer.parseInt(request.getParameter("custid").toString());
				System.out.println("the custid is"+ cusid);
				ArrayList<Customer> cuslist=cs.searchCustomer(ssnid,cusid);
				if(cuslist.isEmpty())
				{

					RequestDispatcher rd=request.getRequestDispatcher("errorcustomer.jsp");
					rd.forward(request, response);
				}
				else
				{
				request.setAttribute("cuslist", cuslist);	
				RequestDispatcher rd=request.getRequestDispatcher("viewResult.jsp");
				rd.forward(request, response);
				}
			}
				catch(NumberFormatException e)
				{
					e.printStackTrace();
				}
			}
		
			
		}
	else if("searchTeller".equalsIgnoreCase(action))
		{
		
		PrintWriter out = response.getWriter();
			System.out.println("inside controller");
			 if(((request.getParameter("accid"))!="")&&((request.getParameter("ssnid"))=="")&&((request.getParameter("custid"))==""))
				{
					try{
						int accid=Integer.parseInt(request.getParameter("accid").toString());
						System.out.println("the accid is"+accid);
						ArrayList<Account> acctlist=cs.searchCustomerbyAccId(accid);
						if(acctlist.isEmpty())
						{
							RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
							rd.forward(request, response);
						}
						else
						{
						request.setAttribute("acctlist", acctlist);	
						RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
						rd.forward(request, response);
						}
					}
					catch(NumberFormatException e)
					{
						e.printStackTrace();
					}
				}
			 else if(((request.getParameter("accid"))!="")&&((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))!=""))
			 {
				 	int accid=Integer.parseInt(request.getParameter("accid").toString());
					System.out.println("the accid is"+accid);
					int custid=Integer.parseInt(request.getParameter("custid").toString());
					System.out.println("the custid is"+custid);
					ArrayList<Account> acctlist=cs.searchAccountbyId(accid,custid);
					if(acctlist.isEmpty())
					{
						RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
						rd.forward(request, response);
					}
					else
					{
					request.setAttribute("acctlist", acctlist);	
					RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
					rd.forward(request, response);
					}
			 }
			 else if(((request.getParameter("accid"))!="")&&((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))==""))
			 {
				 	int accid=Integer.parseInt(request.getParameter("accid").toString());
					System.out.println("the accid is"+accid);
					int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
					System.out.println("the ssnid is"+ ssnid);
					ArrayList<Account> acctlist=cs.searchAccountWithAccSsnId(accid, ssnid);
					if(acctlist.isEmpty())
					{
						RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
						rd.forward(request, response);
					}
					else
					{
					request.setAttribute("acctlist", acctlist);	
					RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
					rd.forward(request, response);
					}
			 }
			 else if(((request.getParameter("accid"))!="")&&((request.getParameter("ssnid"))=="")&&((request.getParameter("custid"))!=""))
			 {
				 	int accid=Integer.parseInt(request.getParameter("accid").toString());
					System.out.println("the accid is"+accid);
					int custid=Integer.parseInt(request.getParameter("custid").toString());
					System.out.println("the custid is"+custid);
					ArrayList<Account> acctlist=cs.searchAccountbyId(accid,custid);
					if(acctlist.isEmpty())
					{
						RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
						rd.forward(request, response);
					}
					else
					{
					request.setAttribute("acctlist", acctlist);	
					RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
					rd.forward(request, response);
					}
			 }
			 else if((request.getParameter("accid"))=="")
			 {
				 if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))==""))
				 {
				
			int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
			System.out.println("the ssnid is"+ ssnid);
			request.setAttribute("ssnid", ssnid);
			RequestDispatcher rd=request.getRequestDispatcher("displayAcc1.jsp");
			rd.forward(request, response);
			}
	
			
			else if(((request.getParameter("ssnid"))=="")&&((request.getParameter("custid"))!=""))
			{
				int custid=Integer.parseInt(request.getParameter("custid").toString());
				System.out.println("the custid is"+ custid);
			    request.setAttribute("custid", custid);
				RequestDispatcher rd=request.getRequestDispatcher("displayAcc.jsp");
				rd.forward(request, response);
				
			}
			else if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))!=""))
			{
				int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
				System.out.println("the ssnid is"+ ssnid);
				int custid=Integer.parseInt(request.getParameter("custid").toString());
				System.out.println("the custid is"+ custid);
				request.setAttribute("ssnid", ssnid);
				request.setAttribute("custid", custid);
				RequestDispatcher rd=request.getRequestDispatcher("displayAcc2.jsp");
				rd.forward(request, response);
			}
			

	 
			 }
  
		}
	else if("viewAccount".equalsIgnoreCase(action))
	{
		PrintWriter out = response.getWriter();
		String acctype=request.getParameter("acctype");
		System.out.println(acctype);
		if(((request.getParameter("custid"))!="")&&((request.getParameter("ssnid"))==null))
		{
		int custid=Integer.parseInt(request.getParameter("custid").toString());
		System.out.println("the custid is:"+custid);
		ArrayList<Account> acctlist=cs.searchAccountbyCustId(custid,acctype);
		if(acctlist.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
			rd.forward(request, response);
		}
		else
		{
		request.setAttribute("acctlist", acctlist);	
		RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
		rd.forward(request, response);
		}
		}
		else if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))==null))
		{
			int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
			System.out.println("the ssnid is:"+ssnid);
			ArrayList<Account> acctlist=cs.searchAccountbySsnId(ssnid,acctype);
			if(acctlist.isEmpty())
			{
				RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
				rd.forward(request, response);
			}
			else
			{
			request.setAttribute("acctlist", acctlist);	
			RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
			rd.forward(request, response);
			}
		}
		else if(((request.getParameter("ssnid"))!="")&&((request.getParameter("custid"))!=""))
		{
			int ssnid=Integer.parseInt(request.getParameter("ssnid").toString());
			System.out.println("the ssnid is"+ ssnid);
			int custid=Integer.parseInt(request.getParameter("custid").toString());
			System.out.println("the custid is"+ custid);
			ArrayList<Account> acctlist=cs.searchAccount(ssnid,custid,acctype);
			if(acctlist.isEmpty())
			{
				RequestDispatcher rd=request.getRequestDispatcher("Errorsearch.jsp");
				rd.forward(request, response);
			}
			else
			{
			request.setAttribute("acctlist", acctlist);	
			RequestDispatcher rd=request.getRequestDispatcher("viewAccount.jsp");
			rd.forward(request, response);
			}
		}
	
		
 
	}
	}

}
