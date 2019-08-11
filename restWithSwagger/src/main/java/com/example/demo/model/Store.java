package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {

	@ApiModelProperty("Store ID in 6 Digit")
	private long storeId;
	@ApiModelProperty("Store Location as Pincode")
	private String location;
	@ApiModelProperty("Name of the Store Incharge")
	private String storeIncharge;
	@ApiModelProperty("yearly income target in Thousands")
	private double yearlyTarget;
	
	
}
