package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.ageservice;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AgeServiceClient {

	//Inyecta Bean Balanceado con Ribbon RestTemplate loadBalancedRestTemplate
	@Autowired
	private RestTemplate loadBalancedRestTemplate;
	
	@Value("${age-service-name:age-microservice}")
	private String serviceName;

	@SneakyThrows
	public int getAge(Map<String, String> vars) {
		
		// Implementa
		URI uri = URI.create(String.format("http://%s/age-service/age", serviceName));
		Map<String, Object> mapResponse = loadBalancedRestTemplate.getForObject(uri, Map.class);
		
		log.info("Service: {}, response: {}", serviceName, mapResponse);
		
		vars.put("from-age-service", mapResponse.get("from").toString());
		
		return Integer.valueOf(mapResponse.get("age").toString());
	}

}
