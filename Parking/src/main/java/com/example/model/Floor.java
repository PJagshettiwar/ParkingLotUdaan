package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Floor extends BaseModel{
	
	String name;
	List<Spot> spots = new ArrayList<>();
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+id+" spots: "+spots;
	}
}
