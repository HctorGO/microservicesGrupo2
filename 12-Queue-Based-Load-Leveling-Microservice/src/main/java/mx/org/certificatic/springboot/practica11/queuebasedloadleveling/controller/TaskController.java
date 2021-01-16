package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;

@Slf4j
// Define Rest Controller
@RestController
public class TaskController {

	// Inyecta ITaskService
	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/{triggeredTasks}")
	public String getResponse(@PathVariable int triggeredTasks) {

		long startTime = System.nanoTime();
		String response = taskService.triggerTasks(triggeredTasks);
		long elaspsedtime = System.nanoTime() - startTime;
		
		String elapsedTimeText = String.format("elapsed tome %s sec.", (double) elaspsedtime / 1_000_000_000);
		
		log.info("{}" , elapsedTimeText);
		
		// Implementa
		return response + ", " + elapsedTimeText;
	}

}
