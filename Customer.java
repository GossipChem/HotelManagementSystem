package model;

import model.Enums.GENDER;

public class Customer extends Account {
	
	private String nickname;
	private GENDER gender;
	private String birthday;
	private String address;
	private String email;
	
	public Customer(String username, String password, 
			String phone, String nickname, GENDER gender,
			String birthday, String address, String email) {
		super(username, password, phone);
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
