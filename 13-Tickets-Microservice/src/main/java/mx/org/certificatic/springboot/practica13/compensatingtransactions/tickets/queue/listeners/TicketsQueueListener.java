package mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.listeners;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.producers.CheckoutMicroserviceQueueProducer;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.TicketsMicroserviceQueues;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.event.CancelTicketReservationEvent;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.event.TicketReservationEvent;

@Slf4j
// Define Bean
@Component
public class TicketsQueueListener {

	@Autowired
	private CheckoutMicroserviceQueueProducer checkoutMicroserviceQueueProducer;

	private boolean ticketReservation = true;

	private boolean ticketReservationCompensation = true;

	// Define JMS Listener de queue TicketsMicroserviceQueues.TICKET_RESERVATION_QUEUE
	@JmsListener(destination = TicketsMicroserviceQueues.TICKET_RESERVATION_QUEUE)
	public void ticketReservation(@Payload TicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
		
		log.info("---");
		
		log.info("[Tickets Microservice] appling 'ticket reservation envent' for ticket order Id {}" , reservationEvent.getTicketOrderId());
	
		if(!successTicketReservation()) {
			log.info("[Ticket Reservation] 'ticket reservation envent id {}'" , reservationEvent.getTicketOrderId());
		} else {
			log.info("[Ticket Reservation] 'ticket reservation envent id {}'" , reservationEvent.getTicketOrderId());
			
			checkoutMicroserviceQueueProducer.reservationCheckoutWithdrawal
			(reservationEvent.getUser(), reservationEvent.getTicketOrderId(), reservationEvent.getTotal(), "1234-5678");
		}
		
	}

	// Define JMS Listener de queue TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE
	public void ticketReservationCompenstation(@Payload CancelTicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
		
		log.info("---");
		
		log.info("id {}" , TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE);
		
		if(!successTicketReservationCompensation()) {
			log.info("id {}" , reservationEvent.getTicketOrderId());
		} else {
			log.info("sucess id {}" , reservationEvent.getTicketOrderId());
		}
		
	}

	private boolean successTicketReservation() {
		return ticketReservation;
	}

	private boolean successTicketReservationCompensation() {
		return ticketReservationCompensation;
	}

}