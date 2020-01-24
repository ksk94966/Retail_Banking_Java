package service;

import java.util.ArrayList;

import bean.Account;
import bean.Customer;

import DAO.BankDAO;

public class customerService {
	BankDAO dao=new BankDAO();
	public ArrayList<Customer> searchCustomer(int ssn_id,int cust_id) 
	{
		System.out.println("inside service");
		ArrayList<Customer> cuslist=dao.searchCustomer(ssn_id, cust_id);
		return cuslist;
	}
	public ArrayList<Customer> searchCustomer(int ssn_id) 
	{
		System.out.println("inside service");
		ArrayList<Customer> cuslist=dao.searchCustomer(ssn_id);
		for(Customer c:cuslist)
			System.out.println(c.getName());
		return cuslist;
	}
	public ArrayList<Customer> searchCustomerbyId(int cusid) {
		System.out.println("inside service");
		ArrayList<Customer> cuslist=dao.searchCustomerbyId(cusid);
		return cuslist;
	}
	public ArrayList<Account> searchAccount(int ssnid,int custid,String type){
		System.out.println("insi service");
		ArrayList<Account> acctlist=dao.searchAccount(ssnid,custid,type);
		return acctlist;
	}
	public ArrayList<Account> searchAccountbySsnId(int ssnid,String type){
		System.out.println("service");
		System.out.println(ssnid);
		ArrayList<Account> cuslist=dao.searchAccountbySsnId(ssnid,type);
		return cuslist;
	}
	public ArrayList<Account> searchAccountbyCustId(int custid,String type)
	{
		System.out.println("inside service");
		ArrayList<Account> cuslist=dao.searchAccountbyCustId(custid,type);
		return cuslist;
	}
	public ArrayList<Account> searchCustomerbyAccId(int accid)
	{
		System.out.println("inside service");
		ArrayList<Account> acclist=dao.searchCustomerbyAccId(accid);
		return acclist;
	}
	public ArrayList<Account> searchAccountbyId(int accid, int custid) {
		System.out.println("inside service");
		ArrayList<Account> acclist=dao.searchAccountbyId(accid,custid);
		return acclist;
	}
	public ArrayList<Account> searchAccountWithAccSsnId(int accid, int ssnid) {
		System.out.println("inside service");
		ArrayList<Account> acclist=dao.searchAccountWithAccSsnId(accid, ssnid);
		return acclist;
	}


}
