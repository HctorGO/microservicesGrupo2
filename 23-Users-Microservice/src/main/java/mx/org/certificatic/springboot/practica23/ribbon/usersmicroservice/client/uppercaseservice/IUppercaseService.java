package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice;

import java.util.Map;

public interface IUppercaseService {

	String toUppercase(String name, Map<String, String> vars);

}
