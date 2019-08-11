package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.*;

@Service
public class ProductService {

	
	@Autowired
	private List<Product> productList;


	@Cacheable(value="stored-cache", key="'product-cache'+#id")
	public Product getAll(long id) throws InterruptedException{
		
		Thread.sleep(4000);
		return this.productList.stream().filter(eachProduct -> eachProduct.getProductId() == id).findFirst().orElse(null);
	}

}
