package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.ageservice.AgeServiceClient;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.IUppercaseService;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.model.User;

@Slf4j
@Service
public class UsersService {

	@Autowired
	private AgeServiceClient ageServiceClient;

	@Autowired
	private IUppercaseService uppercaseServiceClient;

	@SneakyThrows
	public User getUser(String name) {

		log.info("before sending GET Age HTTP Request");

		Map<String, String> vars = new HashMap<>();
		
		int age = ageServiceClient.getAge(vars);

		log.info("age web service endpoint was called and response recieved ");

		log.info("before sending GET Age HTTP Request");

		String nameUppercase = uppercaseServiceClient.toUppercase(name, vars);

		log.info("Age web service endpoint was called and response recieved ");
		
		return new User(String.format("%s, from: %s", nameUppercase, vars.get("from-upercase-service")),
						String.format("%s, from: %s", age, vars.get("from-age-service")));

	}

}
