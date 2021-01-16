package mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config.profile.SimpleProfile;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.service.impl.TaskService;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl.SimpleTaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl.SimpleTaskProducer;

@Configuration
@SimpleProfile
public class SimpleProfileConfiguration {

	// Implementa
	@Autowired
	private ExecutorService myExecutorService;
	
	@Bean
	public ITaskConsumer simpleTaskConsumer() {
		return new SimpleTaskConsumer(ApplicationConfig.CONSUMER_TASK_DELAY);
	}
	
	@Bean
	public ITaskProducer simpleTaskProducer() {
		return new SimpleTaskProducer(1, ApplicationConfig.PRODUCER_TASK_DELAY, simpleTaskConsumer());
	}
	
	@Bean
	public ITaskService taskService() {
		return new TaskService(myExecutorService, taskService()):
	}
	
}
