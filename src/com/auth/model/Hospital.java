package com.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital extends User {

	private String name;
	private String address;

	public Hospital() {

	}

	public Hospital(Integer iD, String contactNo, String email, String password, String type, String address,
			String name) {
		super(iD, type, email, password, contactNo);
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
