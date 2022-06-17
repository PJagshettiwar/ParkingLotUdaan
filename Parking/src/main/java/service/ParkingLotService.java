package service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.model.Lot;
import com.example.model.Spot;
import com.example.model.SpotStatus;
import com.example.model.Ticket;
import com.example.model.VehicleType;

import lombok.Setter;
import repository.ParkingLotRepository;
import sun.awt.Mutex;

@Service
@Setter
public class ParkingLotService {
	
	private SpotStrategies spotStrategies;
	private PaymentStrategies paymentStrategies;
	
	public Ticket generateTicket(Spot spot) {
		Ticket ticket = new Ticket();
		ticket.setSpot(spot);
		ticket.setInTime(LocalDateTime.now());
		return ticket;
	}
	
	public Spot getFreeSpot(VehicleType vehicleType) {
		synchronized (this) {
			Lot lot = ParkingLotRepository.getLot();
			Spot spot= spotStrategies.getFreeSpot(vehicleType, lot);
			if(spot!=null) {
				spot.setSpotStatus(SpotStatus.occupied);
			}
			return spot;
		}
	}
	
	public Spot getFreeSpotMutex(VehicleType vehicleType) {
		synchronized (this) {
			//method1
			//method2
			//method3
			Lot lot = ParkingLotRepository.getLot();
			Spot spot= spotStrategies.getFreeSpot(vehicleType, lot);
			if(spot!=null) {
				spot.setSpotStatus(SpotStatus.occupied);
			}
			return spot;
		}
	}
	
	public Ticket payment(Ticket ticket) {
		ticket.setOutTime(LocalDateTime.now());
		paymentStrategies.calculatePayment(ticket);
		return ticket;
	}
	
	public void markSpotAvailable(Spot spot) {
		spot.setSpotStatus(SpotStatus.available);
	}
		
	
}
