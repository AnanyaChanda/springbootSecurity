package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.*;

@Service
public class ProductService {

	
	@Autowired
	private List<Product> productList;


	public List<Product> getAll(){
		
		return this.productList;
	}

}
