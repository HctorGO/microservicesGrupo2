package mx.org.certificatic.springboot.practica23.ribbon.agemicroservice.client;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Service
public class RandomServiceClient implements RandomService {

	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${random-service-name:random-microservice}")
	private String serviceName;
	
	@Override
	@SneakyThrows
	public int getRandomValue() {
		
		ServiceInstance se = loadBalancer.choose(serviceName);
		
		String host = se.getHost();
		int port = se.getPort();
		
		// build URI using service-name
		//URI uri = new URI("http://" + host + ":" + port + "/" + serviceName + "/random-service/next");
		URI uri = new URI("http://" + host + ":" + port + "/" + serviceName + "/random-service/next");
		
		Map<String, Object> mapResponse = restTemplate.getForObject(uri, Map.class);
		
		return Integer.valueOf(mapResponse.get("random").toString());
	}
	
}
