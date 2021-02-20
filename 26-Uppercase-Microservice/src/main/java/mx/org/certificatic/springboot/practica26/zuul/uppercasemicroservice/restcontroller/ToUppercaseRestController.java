package mx.org.certificatic.springboot.practica26.zuul.uppercasemicroservice.restcontroller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica26.zuul.uppercasemicroservice.MyListener;
import mx.org.certificatic.springboot.practica26.zuul.uppercasemicroservice.service.UppercaseService;

@Slf4j
@RestController
public class ToUppercaseRestController {

	@Autowired
	private UppercaseService uppercaseService;

	@Autowired
	private Environment env;

	@GetMapping("/toUppercase/{name}")
	public Map<String, Object> toUppercase(@PathVariable String name) {

		log.info("sending toUppercase 1");

		Map<String, Object> map = new LinkedHashMap<>();

		map.put("uppercase", uppercaseService.toUppercase(name));
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);

		return map;
	}

	@GetMapping("/upper/toUppercase/{name}")
	public Map<String, Object> toUppercase2(@PathVariable String name) {

		log.info("sending toUppercase 2");

		Map<String, Object> map = new LinkedHashMap<>();

		map.put("uppercase", uppercaseService.toUppercase(name));
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);

		return map;
	}
}
