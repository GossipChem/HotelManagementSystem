package model;

import model.Enums.POST;

public class Staff extends Account {

	private String name; 
	private String id; // Identity code can't change
	private String email;
	private POST post;
	
	public Staff(String username, String password, String phone, 
			String name, String id, String email, POST post) {
		super(username, password, phone);
		this.name = name;
		this.id = id;
		this.email = email;
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public POST getPost() {
		return post;
	}

	public void setPost(POST post) {
		this.post = post;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
	
}
