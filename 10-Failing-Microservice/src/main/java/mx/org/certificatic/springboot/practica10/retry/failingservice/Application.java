package mx.org.certificatic.springboot.practica10.retry.failingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Implementa handler method "/{statusCode}"
	
	@GetMapping("/{statusCode}")
	public Integer prueba(@RequestParam Integer statusCode) {
		
		return statusCode;
	}
	
}
