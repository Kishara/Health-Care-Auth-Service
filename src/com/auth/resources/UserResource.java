package com.auth.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.auth.model.Doctor;
import com.auth.service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/doctors")
public class UserResource {

	UserService userService = new UserService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Doctor> getDoctors() {
//		return userService.getAlldoctors();
//	}
	
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
		String output = userService.insertDoctor(type, email, password, contactNo, firstName, lastName, NIC, sex, specialization);
		return output;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		return userService.readDoctor();
	}

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
		
		String output = userService.updateDoctor(ID, contactNo);
		return output;
	}
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String doctorData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());


		String id = doc.select("id").text();
		String output = userService.deleteDoctor(id);
		return output;
	}
}
