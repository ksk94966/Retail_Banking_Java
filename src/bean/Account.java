package bean;

public class Account {

	private int customerId;
	private int accountId;
	private String accountType;
	private String status;
	private String message;
	private int accountBalance;
	private String lastUpdated;
	
	
	public Account(int accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public Account()
	{
		super();
	}

	public Account(int c_id, int a_id, String type, String status2, String msg,
			String updated) {
		
		this.customerId=c_id;
		this.accountId=a_id;
		this.accountType=type;
		this.status=status2;
		this.message=msg;
		this.lastUpdated=updated;
		
		
		
		
	}


	public Account(int customerId2, int acntId, String type, int amnt) {
	this.customerId=customerId2;
	this.accountId=acntId;
	this.accountType=type;
	this.accountBalance=amnt;
		
		
	}


	public Account(int custid, String acctype, int deposit) {
		this.customerId=custid;
		this.accountType=acctype;
		this.accountBalance=deposit;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
}
