package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.impl;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.IUppercaseService;

@Slf4j
@Primary
@Service
public class UppercaseServiceClientRibbonApi implements IUppercaseService {

	//@Autowired
	//private RestTemplate loadBalancedRestTemplate;

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${uppercase-service-name:uppercase-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public String toUppercase(String name, Map<String, String> vars) {

		name = URLEncoder.encode(name, "UTF-8").replace("+", "%20");
		
		ServiceInstance se = loadBalancer.choose(serviceName);
		
		String host = se.getHost();
		int port = se.getPort();
		
		// build URI using service-name
		URI uri = new URI("http://" + host + ":" + port + serviceName + "/uppercase-service/toUppercase/" + name);
		// cambiar por string format
		// URI uri = new URI("http://" + serviceName + "/uppercase-service/toUppercase/" + name);

		// getting map from loadBalanced RestTemplate
		Map<String, Object> mapResponse = restTemplate.getForObject(uri, Map.class);

		log.info("{} response: {}", serviceName, mapResponse);

		vars.put("from-uppercase-service", mapResponse.get("from").toString());
		
		return (String) mapResponse.get("uppercase");
	}

}
