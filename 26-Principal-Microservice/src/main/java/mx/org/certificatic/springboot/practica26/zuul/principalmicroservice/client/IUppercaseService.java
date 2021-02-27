package mx.org.certificatic.springboot.practica26.zuul.principalmicroservice.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${uppercase-microservice.service-name:uppercase-microservice}")
			//,  path = "${uppercase-microservice.context-path:uppercase-service}")
public interface IUppercaseService {

	@GetMapping("/toUppercase/{name}")
	public Map<String, Object> toUppercase(@PathVariable String name);
}