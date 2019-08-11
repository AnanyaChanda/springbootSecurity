package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Product;

@Configuration
public class AppConfig {

	
	@Bean
	public Product tv() {
	
		return new Product(101,"Sony Tv",45000);
	}
	
	@Bean
	public Product laptop() {
	
		return new Product(102,"Lenova Laptop",56000);
	}
	
	@Bean
	public Product printer() {
	
		return new Product(103,"Hp Printer",12000);
	}
}
