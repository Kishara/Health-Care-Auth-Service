package com.auth.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.auth.model.Doctor;
import com.auth.model.User;
import com.auth.service.DoctorService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("/doctors")
public class DoctorResource {

	DoctorService doctorService = new DoctorService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Doctor> getDoctors() {
//		return userService.getAlldoctors();
//	}
	
	

/* User type - Doctor */
	
//	Insert doctor
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(@FormParam("type") String type,
							 @FormParam("email") String email,
							 @FormParam("password") String password,
							 @FormParam("contactNo") String contactNo,
							 @FormParam("firstName") String firstName,
							 @FormParam("lastName") String lastName,
							 @FormParam("NIC") String NIC,
							 @FormParam("sex") String sex,
							 @FormParam("specialization") String specialization) {
		String output = doctorService.insertDoctor(type, email, password, contactNo, firstName, lastName, NIC, sex, specialization);
		return output;
	}
	
	
	//Read doctor list	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		return doctorService.readDoctor();
	}

	
//	Doctor update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object
		String ID = doctorObject.get("ID").getAsString();
//		String password = doctorObject.get("password").getAsString();
		String contactNo = doctorObject.get("contactNo").getAsString();
		
		String output = doctorService.updateDoctor(ID, contactNo);
		return output;
	}
	
	
//Delete existing doctor
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String doctorData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());


		String id = doc.select("id").text();
		String output = doctorService.deleteDoctor(id);
		return output;
	}
	
	
	
//	Retrieve  single doctor
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctorDetails(@PathParam("id") String id) {
		Doctor doctor = doctorService.getDoctorDetails(id);
		return doctor;
	}

	

}
