package mx.org.certificatic.springboot.practica23.ribbon.agemicroservice.client;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RandomServiceClient {

	@Autowired
	private Random random;

	public int getRandomValue() {

		log.info("[local implementation] generating random value from");

		return random.nextInt(40);
	}

}
