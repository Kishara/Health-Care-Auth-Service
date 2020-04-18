package com.auth.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.auth.model.Patient;
import com.auth.service.PatientService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/patients")
public class PatientResource {

	PatientService patientService = new PatientService();

	/* User type - Patient */

//Insert Patient
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(@FormParam("type") String type, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("contactNo") String contactNo,
			@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@FormParam("DOB") String DOB, @FormParam("age") String age, @FormParam("sex") String sex,
			@FormParam("NIC") String NIC, @FormParam("address") String address) {
		String output = patientService.insertPatient(type, email, password, contactNo, firstName, lastName, DOB, age,
				sex, NIC, address);
		return output;
	}

//Read Patient list	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPatients() {
		return patientService.readPatient();
	}

//Patient update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String patientData) {

		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject();

		String ID = patientObject.get("ID").getAsString();
		String contactNo = patientObject.get("contactNo").getAsString();
		String address = patientObject.get("address").getAsString();

		String output = patientService.updatePatient(ID, contactNo, address);
		return output;
	}

//Delete existing patient
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData) {

		Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());

		String id = doc.select("id").text();

		String output = patientService.deletePatient(id);
		return output;
	}

//Retrieve  single doctor
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatientDetails(@PathParam("id") String id) {
		Patient patient = patientService.getPatientDetails(id);
		return patient;
	}

}
