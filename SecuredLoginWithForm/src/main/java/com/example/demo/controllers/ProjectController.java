package com.example.demo.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@GetMapping("/first")
	@Secured(value="ROLE_USER")
	public String getSecuredMessage(Principal user) {
		
		return "Welcome to Secured Page"+user.getName();
	}
	
	@GetMapping("/second")
   public String getUnSecuredMessage() {
		
		return "Welcome to UN-Secured Page";
	}
	
	
	@GetMapping("/exit")
	public String mycustomLogout(HttpServletRequest request) {
		
		 HttpSession session = request.getSession(false);

     if (session != null) {


         session.invalidate();
     }


     SecurityContextHolder.clearContext();
     return "Hello World";

		
	}
	
}
