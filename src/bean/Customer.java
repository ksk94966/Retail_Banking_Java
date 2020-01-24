package bean;

public class Customer {

	
	private int ssnId;
	private int customerId;
	private String name;
	private int age;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String status;
	private String message;
	private String lastUpdated;
	public Customer(int ssnId2, String custName, int age2, String addressLine1,
			String addressLine2, String city2, String state2) {
		
		this.address1=addressLine1;
		this.address2=addressLine2;
		this.age=age2;
		this.city=city2;
		this.state=state2;
		this.ssnId=ssnId2;
		this.name=custName;
				
		
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	public Customer(int ssnId2, String custName, int customerid2, int age2,
			String addressLine1, String addressLine2, String city2,
			String state2) {
		
		this.address1=addressLine1;
		this.address2=addressLine2;
		this.age=age2;
		this.city=city2;
		this.state=state2;
		this.ssnId=ssnId2;
		this.name=custName;
		this.customerId=customerid2;	
		
	}
	public Customer() {
		this.address1="";
		this.address2="";
		this.age=0;
		this.city="";
		this.state="";
		this.ssnId=0;
		this.name="";
		this.customerId=0;
	}
	public int getSsnId() {
		return ssnId;
	}
	public void setSsnId(int ssnId) {
		this.ssnId = ssnId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Customer(int ssnId, int customerId, String status, String lastUpdated) {
		super();
		this.ssnId = ssnId;
		this.customerId = customerId;
		this.status = status;
		this.lastUpdated = lastUpdated;
	}
	
	
	
	
	
}
