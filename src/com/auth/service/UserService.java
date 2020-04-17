package com.auth.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.auth.database.DBConnection;
import com.auth.model.Doctor;


public class UserService {

//	
//	public List<Doctor> getAlldoctors(){
//		Doctor d1 = new Doctor(1,"Doctor", "kisha@gmail.com", "kisha@123", "0112781311", "Kishara", "Buddika", "983132030V", "Male", "ENT");
//		Doctor d2 = new Doctor(2,"Doctor", "Dili@gmail.com", "dili@123", "0719742474", "Dilhani", "Samarakonn", "983132054V", "Female", "HeartSpecialist");
//		List<Doctor> list =new ArrayList<>();
//		list.add(d1);
//		list.add(d2);
//		
//		return list;
//	}
	
	
	
	public String insertDoctor(String type, String email, String password, String contactNo, String firstName, String lastName, String NIC, String sex, String specialization) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			
			
			// create a prepared statement
			String query = " insert into doctor (`id`,`type`,`email`,`password`,`contactNo`,`firstName`,`lastName`,`NIC`,`sex`,`specialization`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, password);
			preparedStmt.setString(5, contactNo);
			preparedStmt.setString(6, firstName);
			preparedStmt.setString(7, lastName);
			preparedStmt.setString(8, NIC);
			preparedStmt.setString(9, sex);
			preparedStmt.setString(10, specialization);

			
			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readDoctor() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Doctor ID</th><th>User type</th><th>Doctor Email</th><th>Password</th><th>Contact no"
					+ "</th><th>First name</th><th>Last name</th><th>NIC</th><th>Sex</th><th>Specialization</th><th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from doctor";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("ID"));
				String type = rs.getString("type");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contactNo = rs.getString("contactNo");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String NIC = rs.getString("NIC");
				String sex = rs.getString("sex");
				String specialization = rs.getString("specialization");
				
				// Add into the html table
				output += "<tr><td>" + ID + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + contactNo + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + NIC + "</td>";
				output += "<td>" + sex + "</td>";
				output += "<td>" + specialization + "</td>";
				
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"doctor.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + ID + "\">" + "</form></td></tr>";
			}
			con.close();
			
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the doctor.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updateDoctor(String ID, String contactNo) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			
			
			// create a prepared statement
			String query = "UPDATE doctor SET contactNo=? " 
			+ "WHERE ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
//			preparedStmt.setString(1, password);
			preparedStmt.setString(1, contactNo);
			preparedStmt.setInt(2, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String deleteDoctor(String ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			
			// create a prepared statement
			String query = "delete from doctor "
					+ "where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));
			
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
