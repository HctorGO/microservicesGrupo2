/**
 * 
 */
package mx.org.certificatic.springboot.practica23.ribbon.randommicroservice.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.randommicroservice.MyListener;
import mx.org.certificatic.springboot.practica23.ribbon.randommicroservice.service.RandomService;

/**
 * @author hgore
 *
 */
@Slf4j
@RestController
public class RandomRestController {

	@Autowired
	private RandomService randomService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/next")
	public Map<String, Object> next() {

		log.info("next");
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("random", randomService.next());
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);
		
		return map;
	}
	
}
