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

import com.auth.model.Hospital;
import com.auth.service.HospitalService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/hospital")
public class HospitalResource {

	HospitalService hospitalService = new HospitalService();

	/* User type - Hospital */

//Insert Hospital
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("type") String type, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("contactNo") String contactNo,
			@FormParam("name") String name, @FormParam("address") String address) {
		String output = hospitalService.insertHospital(type, email, password, contactNo, name, address);
		return output;
	}

//Read hospital list	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital() {
		return hospitalService.readHospital();
	}

//Hospital update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {

		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject();

		String ID = hospitalObject.get("ID").getAsString();
		String contactNo = hospitalObject.get("contactNo").getAsString();

		String output = hospitalService.updateHospital(ID, contactNo);
		return output;
	}

//Delete existing hospital
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) {

		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

		String id = doc.select("id").text();

		String output = hospitalService.deleteHospital(id);
		return output;
	}

//Retrieve  single hospital
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospitalDetails(@PathParam("id") String id) {
		Hospital hospital = hospitalService.getHospitalDetails(id);
		return hospital;
	}

}
