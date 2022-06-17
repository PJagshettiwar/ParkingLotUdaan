package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FloorVehicleDetails {
	Floor floor;
	VehicleType vehicleType;
	Integer total;
	Integer available;
}
