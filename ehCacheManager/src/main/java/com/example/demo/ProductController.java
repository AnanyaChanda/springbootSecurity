package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/getById/{id}")
	public Product findById(@PathVariable("id") long id) throws InterruptedException{
		
		return this.service.getProductById(id);
	}
	
	
	@GetMapping("/getById/{id}/{rpu}")
	public Product updateRpu(@PathVariable("id") long id,@PathVariable("rpu") double ratePerUnit) throws InterruptedException{
		
		return this.service.updateProductById(id, ratePerUnit);
	}
	
}
