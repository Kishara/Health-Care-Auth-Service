package com.auth.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.auth.model.Doctor;
import com.auth.model.Hospital;
import com.auth.model.Patient;
import com.auth.service.LoginService;

@Path("/login")
public class LoginResource {

	LoginService loginService = new LoginService();

//	@GET
//	@Path("/authenticate/{email}/{password}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String authenticate(@PathParam("email") String email, @PathParam("password") String password) {
//		Doctor doctor = loginService.login(email,password);
//		System.out.println(email + " " + password);
//		
//		if(doctor==null) {
//		      return "Incorrect username or password";
//		}
//		else
//		return "Sucessfully Logged";
//	}

	@GET
	@Path("/authenticateDoc/")
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticateDoc(@QueryParam("email") String email, @QueryParam("password") String password) {
		Doctor doctor = loginService.loginDoc(email, password);
		System.out.println(email + " " + password);
		if (email == null || password == null) {
			return "Please enter user email or password";
		} else if (doctor == null) {
			return "Incorrect username or password";
		} else
			return "Sucessfully Logged";
	}

	@GET
	@Path("/authenticatePat/")
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticatePat(@QueryParam("email") String email, @QueryParam("password") String password) {
		Patient patient = loginService.loginPat(email, password);
		System.out.println(email + " " + password);
		if (email == null || password == null) {
			return "Please enter user email or password";
		} else if (patient == null) {
			return "Incorrect username or password";
		} else
			return "Sucessfully Logged";
	}

	@GET
	@Path("/authenticateHos/")
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticateHos(@QueryParam("email") String email, @QueryParam("password") String password) {
		Hospital hospital = loginService.loginHos(email, password);
		System.out.println(email + " " + password);
		if (email == null || password == null) {
			return "Please enter user email or password";
		} else if (hospital == null) {
			return "Incorrect username or password";
		} else
			return "Sucessfully Logged";
	}

}
