package bean;

public class LoginBody {
	String loginid;
	String password;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginBody(String loginid, String password) {
		super();
		this.loginid = loginid;
		this.password = password;
	}
	public LoginBody() {
		// TODO Auto-generated constructor stub
	}
	

}
