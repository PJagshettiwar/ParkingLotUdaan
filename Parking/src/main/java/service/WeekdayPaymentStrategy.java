package service;

import com.example.model.Ticket;

public class WeekdayPaymentStrategy implements PaymentStrategies{

	@Override
	public void calculatePayment(Ticket ticket) {
		// TODO Auto-generated method stub
		int duration = ticket.getOutTime().getSecond()-ticket.getInTime().getSecond();
		int tarrifAmout = duration * ticket.getSpot().getType().getAmount();
		ticket.setCharges(tarrifAmout);
	}

}
