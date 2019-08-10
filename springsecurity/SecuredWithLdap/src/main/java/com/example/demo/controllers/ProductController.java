package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	
	@GetMapping("/first")
	public String secured() {
		
		return "secred with ldap";
	}
}
