package mx.org.certificatic.springboot.practica19.account.observer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica19.account.events.AccountCreatedEvent;

@Slf4j
@Component
public class AccountCreatedListener {

	// Implemente lo necesario para cumplir con el requerimiento del slide 408
}
