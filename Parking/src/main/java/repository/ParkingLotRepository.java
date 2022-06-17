package repository;

import com.example.model.Lot;

public class ParkingLotRepository {
	
	private static Lot lot;
	
	public ParkingLotRepository(Lot lot){
		this.lot=lot;
	}
	
	public static Lot getLot() {
		return lot;
	}
}
