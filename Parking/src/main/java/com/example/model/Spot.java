package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spot extends BaseModel{
	
	private VehicleType type;
	private SpotStatus spotStatus = SpotStatus.available;
	
	public Spot(VehicleType vehicleType, int id) {
		type = vehicleType;
		this.id=id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "type :"+type+" spotStatus: "+spotStatus;
	}
}
