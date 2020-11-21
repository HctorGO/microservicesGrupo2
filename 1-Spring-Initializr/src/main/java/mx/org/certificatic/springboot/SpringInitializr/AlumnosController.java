package mx.org.certificatic.springboot.SpringInitializr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AlumnosController {
	
	@GetMapping("/alumno/{name}")
	public Alumno getAlumno(@PathVariable String name) {
		
		log.info("getAlumno");
		log.info("{}" , name);
		
		return new Alumno(name);
	}
	
}
