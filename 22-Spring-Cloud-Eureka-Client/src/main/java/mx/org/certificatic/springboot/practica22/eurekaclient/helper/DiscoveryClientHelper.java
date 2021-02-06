package mx.org.certificatic.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DiscoveryClientHelper {

	// Inyecta DiscoveryClient discoveryClient;

	private Random random = new Random();

	public URI getServiceURI(String appName) {
		// Implementa
		return null;
	}

	public List<?> getInstances(String appName) {
		// Implementa obten instancias del DiscoveryClient
		return null;
	}
}
