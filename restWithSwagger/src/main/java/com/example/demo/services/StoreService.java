package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Store;

@Service
public class StoreService {

	@Autowired
	List<Store> storeList;
	
	
	public List<Store> getAll(){
		
		return this.storeList;
	}
	
	
	public Store findById(long id) {
		
		
		return this.storeList.stream().
				filter(eachStore -> eachStore.getStoreId()==id).findFirst().get();
		
	}
}
