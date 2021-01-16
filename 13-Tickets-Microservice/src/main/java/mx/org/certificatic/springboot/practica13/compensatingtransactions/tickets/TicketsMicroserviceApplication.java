package mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.appdemo.service.AppDemoService;

@SpringBootApplication
public class TicketsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsMicroserviceApplication.class, args);
	}

	@Autowired
	private AppDemoService appDemoService;

	@Bean
	@Profile("reserve-ticket")
	public CommandLineRunner reserveTicket() {

		return (args) -> {

			// Implementa
			appDemoService.reserveTicket("Hector", 123, "Muse", "palacio de los deportes", "xyz-123", 1000.30, 325, 0, 2150);
		};
	}

	@Bean
	@Profile("cancel-ticket")
	public CommandLineRunner cancelTicketReservation() {

		return (args) -> {

			// Implementa
			appDemoService.cancelTicketReservation(123);
		};
	}

}
