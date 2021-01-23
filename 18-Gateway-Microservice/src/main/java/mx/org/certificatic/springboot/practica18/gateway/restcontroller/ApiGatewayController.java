package mx.org.certificatic.springboot.practica18.gateway.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica18.gateway.aggregates.DesktopProductAggregate;
import mx.org.certificatic.springboot.practica18.gateway.aggregates.MobileProductAggregate;
import mx.org.certificatic.springboot.practica18.gateway.client.ImageMicroserviceClient;
import mx.org.certificatic.springboot.practica18.gateway.client.PriceMicroserviceClient;

// Define RestController
@Slf4j
@RestController
public class ApiGatewayController {

	// Implementa
	@Autowired
	private ImageMicroserviceClient imageClient;
	
	@Autowired
	private PriceMicroserviceClient priceClient;
	
	
	@GetMapping("/desktop")
	public DesktopProductAggregate desktop() {
		return new DesktopProductAggregate(priceClient.getPrice(), imageClient.getImagePath());
	}

	@GetMapping("/mobile")
	public MobileProductAggregate mobile() {
		return new MobileProductAggregate(priceClient.getPrice());

	}
	
	@GetMapping("/")
	public IProductAggregate getProduct(@RequestHeader("user-agent") String userAgent) {
		log.info(userAgent);
		if("desktop".equals(userAgent)) {
			return new DesktopProductAggregate(priceClient.getPrice(), imageClient.getImagePath());
		} else if("mobile".equals(userAgent)) {
			return new MobileProductAggregate(priceClient.getPrice());
		} else {
			throw new IllegalArgumentException("Unknown user agent");
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public Map<?,?> illegalArgumentException(IllegalArgumentException ex) {
		
		Map<String, String> map = new HashMap<>();
		map.put("code", HttpStatus.BAD_REQUEST.getReasonPhrase());
		map.put("exception", ex.getClass().getSimpleName());
		map.put("message", ex.getMessage());
		
		return map;
	}
	
}
