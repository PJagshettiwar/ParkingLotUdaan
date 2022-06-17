package service;

import java.util.Optional;

import com.example.model.Lot;
import com.example.model.Spot;
import com.example.model.SpotStatus;
import com.example.model.VehicleType;

public class FindFirstSpotStrategy implements SpotStrategies{

	@Override
	public Spot getFreeSpot(VehicleType vehicleType, Lot lot) {
		Optional<Spot> optional = lot.getFloors().stream().flatMap(floor -> floor.getSpots().stream()).filter(spot -> spot.getSpotStatus().equals(SpotStatus.available)).findFirst();
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

}
