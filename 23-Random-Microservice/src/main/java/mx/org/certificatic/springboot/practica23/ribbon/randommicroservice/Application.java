package mx.org.certificatic.springboot.practica23.ribbon.randommicroservice;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public Random random() {
		return new Random();
	}

	@Bean
	public RandomService randomService(Random random) {
		return () -> {
			return random.nextInt(40);
		};
	}

}

@FunctionalInterface
interface RandomService {
	int next();
}