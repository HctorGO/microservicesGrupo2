package mx.org.certificatic.springboot.practica9.embedded.broker.service.restcontroller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica9.embedded.broker.service.model.Order;
import mx.org.certificatic.springboot.practica9.embedded.broker.service.producer.OrderProducer;

// Define Bean Rest Controller
@RestController
public class OrderController {

	private static int i = 1;

	// Inyecta OrderProducer
	@Autowired
	private OrderProducer orderProducer;

	// Implementa handler method "/place-order"
	@GetMapping("/place-order")
	public int placeOrder() {
		
		Order order = new Order(1+i, "My message is 'Hello "+(i)+"'", new Date());
		orderProducer.send(order);
		
		return i++;
	}
	
}