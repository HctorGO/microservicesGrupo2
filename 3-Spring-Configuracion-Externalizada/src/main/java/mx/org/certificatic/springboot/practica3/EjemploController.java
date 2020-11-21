package mx.org.certificatic.springboot.practica3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EjemploController {

	// define propiedad controller.message:No message available
		@Value("${controller.message:No message available}")
		private String message;

		// define propiedad server.port:8080
		@Value("${server.port:8080}")
		private int port;

		@GetMapping("/")
		public String message() {
			log.info("serving from port: {}", port);
			return message;
		}
	
}
