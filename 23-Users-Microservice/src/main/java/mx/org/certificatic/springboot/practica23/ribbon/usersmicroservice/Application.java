package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

// Habilita Eureka Client
@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Define Bean Balanceado con Ribbon RestTemplate loadBalancedRestTemplate
	@Bean
	@LoadBalanced
	public RestTemplate loadBalancedRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters()
		.add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		return restTemplate;
	}
}
