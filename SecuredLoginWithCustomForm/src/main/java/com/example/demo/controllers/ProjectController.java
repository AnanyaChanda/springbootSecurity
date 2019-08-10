package com.example.demo.controllers;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@GetMapping("/first")
	public String getSecuredMessage(Principal user) {
		
		return "Welcome to Secured Page"+user.getName();
	}
	
	@GetMapping("/second")

   public String getUnSecuredMessage() {
		
		return "Welcome to UN-Secured Page";
	}
}
