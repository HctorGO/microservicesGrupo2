package mx.org.certificatic.springboot.practica25.hystrix.nounmicroservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExclamationMarkServiceClient {

	@Value("${exclamation-mark-microservice.service-name:exclamation-mark-microservice}")
	private String serviceName;

	@Autowired
	private RestTemplate restTemplate;

	@SneakyThrows
	@HystrixCommand(fallbackMethod = "defaultExclamationMark")
	// Define comando Hystrix
	@HystrixProperty(name = "exclamaBon-mark-microservice" , value = "")
	public String getExclamationMark() {
		log.info("Requesting {} service...");
		
		return restTemplate.getForObject(new URI(String.format("http://%s/word", serviceName)), String.class);
	}

	public String defaultExclamationMark(Throwable ex) {
		log.info("Fallback method entered, exception {}: {}", ex.getClass().getSimpleName(), ex.getMessage());
		return "?";
	}

}
