package mx.org.certificatic.springboot.practica9.embedded.broker.service;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.org.certificatic.springboot.practica9.embedded.broker.service.model.Order;
import mx.org.certificatic.springboot.practica9.embedded.broker.service.producer.OrderProducer;

@SpringBootApplication
public class OrderProducerMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(OrderProducerMicroservice.class, args);
	}

	@Bean
	public CommandLineRunner startup(OrderProducer orderProducer) {

		return (args) -> {

			for (int i = 0; i < 10; i++) {
				Order order = new Order(1+i, "My message is 'Hello "+(1+i)+"'", new Date());
				orderProducer.send(order);
				Thread.sleep(1000);
			}
		};
	}

}
