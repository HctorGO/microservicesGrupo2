package mx.org.certificatic.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
public class EurekaClientHelper {

	// Inyecta EurekaClient eurekaClient;

	@SneakyThrows
	public URI getServiceURI(String appName) {
		// Implementa
		return null;
	}

	public List<?> getInstances(String appName) {
		// Implementa
		return null;
	}
}
