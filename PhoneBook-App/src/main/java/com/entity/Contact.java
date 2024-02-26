package com.entity;

public class Contact {

	private int id;
	private String name;
	private String email;
	private String phonenumber;
	private String about;
	private int userId;
	
	public Contact() {
		
	}

	public Contact(String name, String email, String phonenumber, String about, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.about = about;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + ", about="
				+ about + ", userId=" + userId + "]";
	}
	
	
}

