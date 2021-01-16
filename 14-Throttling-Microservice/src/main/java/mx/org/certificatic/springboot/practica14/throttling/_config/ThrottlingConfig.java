package mx.org.certificatic.springboot.practica14.throttling._config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.org.certificatic.springboot.practica14.throttling.throttler.CallsCount;
import mx.org.certificatic.springboot.practica14.throttling.throttler.Tenant;
import mx.org.certificatic.springboot.practica14.throttling.throttler.ThrottleTimerImpl;
import mx.org.certificatic.springboot.practica14.throttling.throttler.Throttler;

// Define clase de configuracion
@Configuration
public class ThrottlingConfig {

	// Define bean CallsCount callsCounter
	@Bean
	public CallsCount callsCounter() {
		return new CallsCount();
	}
	// Define bean Throttler throttler, llama a su metodo de inicializacion
	@Bean
	public Throttler throttler() {
		return new ThrottleTimerImpl(1000, callsCounter());
	}
	// Define bean Map<String, Tenant> tenantsMap

	@Bean
	public Map<String, Tenant> tenantsMap() {
		Map<String, Tenant> map = new HashMap<>();
		
		Tenant tenant1 = new Tenant("xvanhalenk", 1, callsCounter());
		map.put(tenant1.getName(), tenant1);
		
		return map;
	}
	
}
