package mx.org.certificatic.springboot.practica21.hello.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${hello.message:no message}")
	private String hi;

	@Value("${spring.profiles.active:no active profile}")
	private String profile;

	@GetMapping
	public String hi() {
		return hi + ", using profile: " + profile;
	}
	
	@Value("${someKey:no value}")
	private String someKey;
	
	@GetMapping("/key")
	public String key() {
		return "somekey = " + someKey;
	}
}
