package com.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private Integer ID;
	private String type;
	private String email;
	private String password;
	private String contactNo;

	public User() {
		super();
	}

	public User(Integer iD, String type, String email, String password, String contactNo) {
		super();
		ID = iD;
		this.type = type;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", type=" + type + ", email=" + email + ", password=" + password + ", contactNo="
				+ contactNo + "]";
	}

}
