package com.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor extends User {

	private String firstName;
	private String lastName;
	private String NIC;
	private String sex;
	private String specialization;

	public Doctor() {
		super();
	}

	public Doctor(Integer iD, String contactNo, String email, String password, String type, String nIC,
			String firstName, String lastName, String sex, String specialization) {
		super(iD, type, email, password, contactNo);
		this.firstName = firstName;
		this.lastName = lastName;
		this.NIC = nIC;
		this.sex = sex;
		this.specialization = specialization;
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

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [firstName=" + firstName + ", lastName=" + lastName + ", NIC=" + NIC + ", sex=" + sex
				+ ", specialization=" + specialization + "]";
	}

}
