package service;

public class EntryGate implements Runnable{
	
	ParkingLotService parkingLotService;
	EntryGate(ParkingLotService parkingLotService){
		this.parkingLotService = parkingLotService; 
	}
	
	public void run() {
		
	}
}
