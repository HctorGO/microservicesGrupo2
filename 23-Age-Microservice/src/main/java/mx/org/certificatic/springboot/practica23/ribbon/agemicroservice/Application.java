package mx.org.certificatic.springboot.practica23.ribbon.agemicroservice;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Habilita Eureka Client
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Random random() {
		return new Random();
	}

	@Bean
	@LoadBalanced // Definido despues, al hacer la integración con 23-Random-Microservice
	public RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
}
