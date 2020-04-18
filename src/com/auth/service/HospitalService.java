package com.auth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.auth.database.DBConnection;
import com.auth.model.Hospital;

public class HospitalService {

	/* User type - Hospital */

//Insert hospital
	public String insertHospital(String type, String email, String password, String contactNo, String name,
			String address) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into hospital (`id`,`type`,`email`,`password`,`contactNo`,`name`,`address`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, type);
			preparedStmt.setString(3, email);
			preparedStmt.setString(4, password);
			preparedStmt.setString(5, contactNo);
			preparedStmt.setString(6, name);
			preparedStmt.setString(7, address);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting the Hospital.";
			System.err.println(e.getMessage());
		}

		return output;
	}

//Read hospital list	
	public String readHospital() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Hospital ID</th><th>User type</th><th>Hospital Email</th><th>Password</th><th>Contact no"
					+ "</th><th>Hospital name</th><th>Hospital address</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from hospital";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("ID"));
				String type = rs.getString("type");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String contactNo = rs.getString("contactNo");
				String name = rs.getString("name");
				String address = rs.getString("address");

				// Add into the html table
				output += "<tr><td>" + ID + "</td>";
				output += "<td>" + type + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + contactNo + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + address + "</td>";

				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"hospital.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"ID\" type=\"hidden\" value=\"" + ID + "\">" + "</form></td></tr>";
			}
			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the hospital.";
			System.err.println(e.getMessage());
		}

		return output;
	}

//Hospital update
	public String updateHospital(String ID, String contactNo) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE hospital SET contactNo=? WHERE ID=?";
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
			output = "Error while updating the hospital.";
			System.err.println(e.getMessage());
		}

		return output;
	}

//Delete existing hospital
	public String deleteHospital(String ID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from hospital where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the hospital.";
			System.err.println(e.getMessage());
		}

		return output;
	}

//	Retrieve  single doctor
	public static Hospital getHospitalDetails(String id) {
		Hospital hospital = null;
		try {

			Connection con = DBConnection.connect();

			String getSql = "SELECT * FROM hospital WHERE id = ? ";

			PreparedStatement ps_getHospitalDetails = con.prepareStatement(getSql);
			ps_getHospitalDetails.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps_getHospitalDetails.executeQuery();

			while (rs.next()) {
				hospital = new Hospital(Integer.parseInt(id), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hospital;
	}

}
