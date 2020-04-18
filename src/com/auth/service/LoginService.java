package com.auth.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.auth.database.DBConnection;
import com.auth.model.Doctor;
import com.auth.model.Hospital;
import com.auth.model.Patient;
import com.auth.model.User;

public class LoginService {

//Doctor login
	public static Doctor loginDoc(String email, String password) {
		Doctor doctor = null;
		try {

			Connection con = DBConnection.connect();

			String getSql = "SELECT * FROM doctor WHERE email = ? AND password = ? ";

			PreparedStatement ps_getDoctorDetails = con.prepareStatement(getSql);
			ps_getDoctorDetails.setString(1, email);
			ps_getDoctorDetails.setString(2, password);

			ResultSet rs = ps_getDoctorDetails.executeQuery();

			while (rs.next()) {

				doctor = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return doctor;
	}

//Patient login
	public static Patient loginPat(String email, String password) {
		Patient patient = null;
		try {

			Connection con = DBConnection.connect();

			String getSql = "SELECT * FROM patient WHERE email = ? AND password = ? ";

			PreparedStatement ps_getPatientDetails = con.prepareStatement(getSql);
			ps_getPatientDetails.setString(1, email);
			ps_getPatientDetails.setString(2, password);

			ResultSet rs = ps_getPatientDetails.executeQuery();

			while (rs.next()) {

				patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return patient;
	}

//Hospital login
	public static Hospital loginHos(String email, String password) {
		Hospital hospital = null;
		try {

			Connection con = DBConnection.connect();

			String getSql = "SELECT * FROM hospital WHERE email = ? AND password = ? ";

			PreparedStatement ps_getHospitalDetails = con.prepareStatement(getSql);
			ps_getHospitalDetails.setString(1, email);
			ps_getHospitalDetails.setString(2, password);

			ResultSet rs = ps_getHospitalDetails.executeQuery();

			while (rs.next()) {

				hospital = new Hospital(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hospital;
	}
}
