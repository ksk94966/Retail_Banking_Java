package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerDAO;
import bean.Customer;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO dao=new CustomerDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		
		if (action.equalsIgnoreCase("AddCustomer")) {
			int ssnId = Integer.parseInt(request.getParameter("ssnId"));
			System.out.println(ssnId);
			String custName = request.getParameter("custName");	
			System.out.println(custName);
			int age = Integer.parseInt(request.getParameter("age"));
			System.out.println(age);
			String addressLine1 = request.getParameter("addressLine1");
			System.out.println(addressLine1);
			String addressLine2 = request.getParameter("addressLine2");
			System.out.println(addressLine2);
			String city = request.getParameter("city");
			System.out.println(city);
			String state = request.getParameter("state");
			System.out.println(state);
			
			Customer c=new Customer(ssnId, custName, age, addressLine1, addressLine2, city, state);
			String msg=null;
			try {
				msg = dao.addCustomer(c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("successaddingcustomer.jsp");
				request.setAttribute("msg",msg);
				rd.forward(request, response);
			}
			
		}

		if(action.equalsIgnoreCase("edit"))
		{
			int cid=Integer.parseInt(request.getParameter("cid"));
			try {
				Customer customer=dao.getCustomerDetails(cid);
				request.setAttribute("customer", customer);
				System.out.println(customer.getAddress1());
				System.out.println(customer.getAddress2());
				System.out.println(customer.getAge());
				System.out.println(customer.getCity());
				System.out.println(customer.getState());
				
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("editcustomer.jsp");
			rd.forward(request, response);
		}
		if(action.equalsIgnoreCase("delete"))
		{
			int cid=Integer.parseInt(request.getParameter("cid"));
			try {
				Customer customer=dao.getCustomerDetails(cid);
				request.setAttribute("customer", customer);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
		}
		if(action.equalsIgnoreCase("confirm"))
		{
			String msg=null;
			int cid=Integer.parseInt(request.getParameter("cid"));
			System.out.println(cid);
			try {
				msg=dao.confirmdelete(cid);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("viewcustomer.jsp");
				rd.forward(request, response);
			}
		}
		if(action.equalsIgnoreCase("update"))
		{
			
			int ssnId=Integer.parseInt(request.getParameter("ssnId"));
			String custName = request.getParameter("custName");
			int customerid = Integer.parseInt(request.getParameter("cid"));
			int age = Integer.parseInt(request.getParameter("age"));
			String addressLine1 = request.getParameter("addressline1");
			String addressLine2 = request.getParameter("addressline2");
            String city=request.getParameter("city");
            String state=request.getParameter("state");
            
            Customer c=new Customer(ssnId, custName, customerid, age, addressLine1, addressLine2, city, state);
            try {
				dao.updatecustomer(c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RequestDispatcher rd=request.getRequestDispatcher("viewcustomer.jsp");
			rd.forward(request, response);
            
			
		}
		else if(action.equals("customerStatus"))
		{
			ArrayList<Customer>al=new ArrayList<Customer>();
			al=dao.viewAccountStatus();
			request.setAttribute("al",al);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerStatusResult.jsp");
			rd.forward(request,response);
		}
		else if(action.equals("refresh"))
		{
			System.out.println("in refresh");
			int ssnId=Integer.parseInt(request.getParameter("ssnId")) ;
			System.out.println(ssnId);
			
			int custId=Integer.parseInt(request.getParameter("custId")) ;
			System.out.println(custId);
			int a=dao.updateStatus(ssnId,custId);
			System.out.println("inside controller a="+a);
			
			ArrayList<Customer>al=new ArrayList<Customer>();
			al=dao.viewAccountStatus();
			request.setAttribute("al",al);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerStatusResult.jsp");
			rd.forward(request,response);
			
		}
	
	}
}