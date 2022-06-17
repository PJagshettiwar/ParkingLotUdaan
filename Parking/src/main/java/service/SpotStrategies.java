package service;

import com.example.model.Lot;
import com.example.model.Spot;
import com.example.model.VehicleType;

public interface SpotStrategies {
	
	public Spot getFreeSpot(VehicleType vehicleType, Lot lot);
}
