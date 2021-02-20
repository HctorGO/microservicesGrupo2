package mx.org.certificatic.springboot.practica26.zuul.employeemicroservice.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${random-microservice.service-name:random-microservice}", 
			 path = "${random-microservice.context-path:random-service}")
public interface IRandomService {
	
	@GetMapping("/next")
	public Map<String, Object> next();
}
