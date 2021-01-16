package mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.appdemo.service.AppDemoService;

@RestController
public class TicketController {

	@Autowired
	private AppDemoService appDemoService;
	
	@PostMapping("/reserve-ticket")
	public String reserve(@RequestBody TicketReserve ticketReservation) {
		
		appDemoService
		.reserveTicket("Hector", 123, "Muse", "palacio de los deportes", "xyz-123", 1000.30, 325, 0, 2150);
		
		return null;
	}
	
}

@Data
class TicketReserve {
	private String user;
	private String ticketId;
	private String concert;
	private String place;
	private String folio;
	private double ccost;
	
}
