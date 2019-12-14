package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.*;
@Service
public class ProductService {

	
	
	@Autowired
	private List<Product> productList;


	@Cacheable(value="twenty-second-cache", key="'#id'")
	public Product getProductById(long id) throws InterruptedException{
		
		Thread.sleep(4000);
		return this.productList.stream().filter(eachProduct -> eachProduct.getProductId() == id).findFirst().orElse(null);
	}

	
	@CacheEvict(value="twenty-second-cache", key="'#id'",beforeInvocation=true)
	public Product updateProductById(long id,double ratePerUnit) {
		
	    Product product= this.productList.stream().filter(eachProduct -> eachProduct.getProductId()==id).findFirst().get();
	    
	    product.setRatePerUnit(ratePerUnit);
	    
	    return product;
	    		
	}

}
