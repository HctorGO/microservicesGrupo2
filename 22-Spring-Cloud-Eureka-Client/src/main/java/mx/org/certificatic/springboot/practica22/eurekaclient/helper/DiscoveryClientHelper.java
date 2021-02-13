package mx.org.certificatic.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryClientHelper {

	// Inyecta DiscoveryClient discoveryClient;
	@Autowired
	private DiscoveryClientHelper discoveryClient;
	
	private Random random = new Random();

	public URI getServiceURI(String appName) {
		// Implementa
		List<ServiceInstance> listInstances = getInstances(appName);
		if(listInstances != null && listInstances.size() > 0) {
			return listInstances.get(random.nextInt(6) % listInstances.size()).getUri();
		}
		
		return null;
	}

	public List<ServiceInstance> getInstances(String appName) {
		// Implementa obten instancias del DiscoveryClient
		return discoveryClient.getInstances(appName);
	}
}
