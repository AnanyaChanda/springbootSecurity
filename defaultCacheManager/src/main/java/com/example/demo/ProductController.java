package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/getAll")
	public List<Product> findAll(){
		
		return this.service.getAll();
	}
}
