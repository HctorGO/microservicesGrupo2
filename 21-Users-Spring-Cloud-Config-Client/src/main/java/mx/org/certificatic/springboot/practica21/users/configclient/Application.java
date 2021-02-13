package mx.org.certificatic.springboot.practica21.users.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
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

	@Bean
	public CommandLineRunner startUp() {
		return (args) -> {
			System.out.println(hi);
			System.out.println(profile);
		};
	}
}
