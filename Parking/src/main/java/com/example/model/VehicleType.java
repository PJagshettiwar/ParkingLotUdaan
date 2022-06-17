package com.example.model;

import lombok.Getter;

@Getter
public enum VehicleType {
	
	
	SMALL(20), MEDIUM(30), BIG(50);
	int amount;
	private VehicleType(int amount){
		this.amount = amount; 
	}
}
