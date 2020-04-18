package com.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient extends User {

	private String firstName;
	private String lastName;
	private String DOB;
	private String age;
	private String sex;
	private String NIC;
	private String address;

	public Patient() {
		super();
	}

	public Patient(Integer iD, String contactNo, String email, String password, String type, String dOB, String nIC,
			String address, String age, String firstName, String lastName, String sex) {
		super(iD, type, email, password, contactNo);
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = dOB;
		this.age = age;
		this.sex = sex;
		this.NIC = nIC;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB + ", age=" + age + ", sex="
				+ sex + ", NIC=" + NIC + ", address=" + address + "]";
	}

}
