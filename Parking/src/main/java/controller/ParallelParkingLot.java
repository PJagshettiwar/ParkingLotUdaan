package controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Floor;
import com.example.model.Lot;
import com.example.model.Spot;
import com.example.model.VehicleType;

import repository.ParkingLotRepository;
import service.FindFirstSpotStrategy;
import service.ParkingLotService;
import service.WeekdayPaymentStrategy;

public class ParallelParkingLot {
	
	static ParkingLotService parkingLotService;
	public static void main(String[] args) {
		
		initialiseLot();
		parkingLotService = new ParkingLotService();
		setSpotStrategy("FindFirst");
		setPaymentStrategy("weekDay");
		
		//thread entry
		//thread exit
		
		
	}
	
	private static void initialiseLot() {
		Floor floor1 = new Floor();
		floor1.setId(1);
		floor1.getSpots().add(new Spot(VehicleType.BIG,1));
		floor1.getSpots().add(new Spot(VehicleType.BIG,2));
		/*
		 * floor1.getSpots().add(new Spot(VehicleType.MEDIUM,3));
		 * floor1.getSpots().add(new Spot(VehicleType.MEDIUM,4));
		 * floor1.getSpots().add(new Spot(VehicleType.MEDIUM,5));
		 * floor1.getSpots().add(new Spot(VehicleType.SMALL,6));
		 * floor1.getSpots().add(new Spot(VehicleType.SMALL,7));
		 */
		List<Floor> floors = new ArrayList<>();
		floors.add(floor1);
		
		Lot.Builder builder= new Lot.Builder();
		Lot lot = builder.setFloors(floors).build();
		
		ParkingLotRepository lotRepository = new ParkingLotRepository(lot);
		System.out.println(ParkingLotRepository.getLot().getFloors().get(0).getSpots().size());
	}
	
	private static void setSpotStrategy(String strategyName) {
		if(strategyName.equals("FindFirst")) {
			parkingLotService.setSpotStrategies(new FindFirstSpotStrategy());
		}
	}
	
	private static void setPaymentStrategy(String strategyName) {
		if(strategyName.equals("weekDay")) {
			parkingLotService.setPaymentStrategies(new WeekdayPaymentStrategy());
		}
	}

}
