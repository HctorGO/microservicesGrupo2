package mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.listeners;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.CheckoutMicroserviceQueues;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.checkout.queue.event.ReservationCheckoutWithdrawalEvent;
import mx.org.certificatic.springboot.practica13.compensatingtransactions.tickets.queue.producers.TicketsMicroserviceQueueProducer;

@Slf4j
// Defina Bean
@Component
public class CheckoutQueueListener {

	// Inyecte TicketsMicroserviceQueueProducer ticketsMicroserviceQueueProducer;
	
	@Autowired
	private TicketsMicroserviceQueueProducer ticketsMicroserviceQueueProducer;
	
	private boolean reservationCheckoutWithdrawal = true;

	// Defina JMS Listener de queue
	// CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE
	@JmsListener(destination = CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE)
	public void applyReserveWithdrawal(@Payload ReservationCheckoutWithdrawalEvent reservationEvent,
			@Headers MessageHeaders headers, Message message, Session session) {

		// Implemente
		
		
		
	}

	private boolean successReservationCheckoutWithdrawal() {
		return reservationCheckoutWithdrawal;
	}

}