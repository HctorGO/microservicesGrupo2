package mx.org.certificatic.springboot.practica18.gateway._config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica18.gateway.client.ImageMicroserviceClient;
import mx.org.certificatic.springboot.practica18.gateway.client.PriceMicroserviceClient;

@Configuration
@Slf4j
public class GatewayMicroserviceConfig {

	// Define RestTemplate restTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/*
	@Bean
	public CommandLineRunner startup(ImageMicroserviceClient imageService, PriceMicroserviceClient priceService) {
		
		return (args -> {
			log.info(imageService.getImagePath());
			log.info(priceService.getPrice());
		});
	}
	*/
}
