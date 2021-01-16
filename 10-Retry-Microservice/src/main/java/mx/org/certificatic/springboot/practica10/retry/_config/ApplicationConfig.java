package mx.org.certificatic.springboot.practica10.retry._config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import mx.org.certificatic.springboot.practica10.retry.service.IBusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.impl.BusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.impl.RetryBusinessService;

@Configuration
public class ApplicationConfig {

	// Define Bean Rest template
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// Inyecta propiedad String failingServiceURL
	@Value("${falling.service.url}")
	private String fallingServiceURL;
	
	// Define Bean IBusinessService noRetriableBusinessService
	// de tipo concreto BusinessService
	@Bean
	IBusinessService noRetriableBusinessService() {
		return new BusinessService(restTemplate(), fallingServiceURL);
	}
	
	// Define Bean IBusinessService retriableBusinessService
	// de tipo concreto RetryBusinessService

}
