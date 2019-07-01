package model;

public class Account {
	/**
	 * This class is used to store 
	 * the basic info of an account
	 */
	private String username;
	private String password;
	private String phone;
	
	
	
	public Account(String username, String password, String phone) {
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
