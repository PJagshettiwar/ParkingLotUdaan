package service;

import com.example.model.Ticket;

public interface PaymentStrategies {

	public void calculatePayment(Ticket ticket);
}
