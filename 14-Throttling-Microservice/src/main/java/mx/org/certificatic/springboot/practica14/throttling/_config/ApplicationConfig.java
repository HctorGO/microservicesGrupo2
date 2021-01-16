package mx.org.certificatic.springboot.practica14.throttling._config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.org.certificatic.springboot.practica14.throttling.restcontroller.model.User;
import mx.org.certificatic.springboot.practica14.throttling.restcontroller.model.Users;

// Define clase de Configuracion
@Configuration
public class ApplicationConfig {

	// Define bean Users
	@Bean
	public Users users() {
		return new Users(userList());
	}
	
	// Define beanList<User>
	@Bean
	public List<User> userList() {
		List<User> users = new ArrayList<>();
		for(int i = 0; i <3; i++) {
			users.add(new User("Hector", 30 + i));
		}
		return users;
	}
}
