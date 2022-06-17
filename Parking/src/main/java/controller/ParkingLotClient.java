package controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Floor;
import com.example.model.Lot;
import com.example.model.Spot;
import com.example.model.Ticket;
import com.example.model.VehicleType;

import net.bytebuddy.asm.Advice.This;
import repository.ParkingLotRepository;
import service.FindFirstSpotStrategy;
import service.ParkingLotService;
import service.SpotStrategies;
import service.WeekdayPaymentStrategy;

public class ParkingLotClient {
	
	static ParkingLotService parkingLotService;
	public static void main(String[] args) throws InterruptedException {
		
		initialiseLot();
		parkingLotService = new ParkingLotService();
		setSpotStrategy("FindFirst");
		setPaymentStrategy("weekDay");
		
		
		//vehicle entry 1
		Spot spot = parkingLotService.getFreeSpot(VehicleType.BIG);
		if(spot==null) {
			System.out.println("Parking is full");
		}
		Ticket ticket1 = parkingLotService.generateTicket(spot);
		System.out.println("step1: "+ParkingLotRepository.getLot());
		
		//vehicle entry 2
		Spot spot2 = parkingLotService.getFreeSpot(VehicleType.BIG);
		if(spot2==null) {
			System.out.println("Parking is full");
		}
		Ticket ticket2 = parkingLotService.generateTicket(spot2);
		System.out.println("step2: "+ParkingLotRepository.getLot());
		
		//vehicle entry 3
		Spot spot3 = parkingLotService.getFreeSpot(VehicleType.BIG);
		if(spot3==null) {
			System.out.println("Parking is full");
		}
		
			
		parkingLotService.payment(ticket1);
		System.out.println("ticket charges :"+ticket1.getCharges());
		parkingLotService.markSpotAvailable(ticket1.getSpot());
		System.out.println("step3: "+ParkingLotRepository.getLot());
		
		spot3 = parkingLotService.getFreeSpot(VehicleType.BIG);
		if(spot3==null) {
			System.out.println("Parking is full");
		}
		Ticket ticket3 = parkingLotService.generateTicket(spot3);
		System.out.println("step4: "+ParkingLotRepository.getLot());
		
		
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


