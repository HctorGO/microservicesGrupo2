package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.impl;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

@Slf4j
// elimina abstract
public class TaskService implements ITaskService {
	
	// Implementa
	private ExecutorService executorService;
	
	private ObjectFactory<? extends ITaskProducer> taskProducerFactory;
	
	public TaskService(ExecutorService executorService, ObjectFactory<? extends ITaskProducer> taskProducerFactory) {
		this.executorService = executorService;
		this.taskProducerFactory = taskProducerFactory;
	}
	
	@Override
	public String triggerTasks(int triggeredTasks) {
		
		int triggered = 0;
		for(int i = 0; i < triggered; i++) {
			ITaskProducer producer = taskProducerFactory.getObject();
			
			executorService.submit((Runnable)producer);
			
			triggered++;
			
			log.info("Task {} triggered!", (i+ 1));
		}
		
		return String.format("%d task triggered", triggered);
	}

	

}
