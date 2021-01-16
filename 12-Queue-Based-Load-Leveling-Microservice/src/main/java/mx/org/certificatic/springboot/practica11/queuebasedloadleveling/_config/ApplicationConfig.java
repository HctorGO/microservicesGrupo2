package mx.org.certificatic.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	public static int PRODUCER_TASK_DELAY;
	public static int CONSUMER_TASK_DELAY;
	
	public ApplicationConfig(
		@Value("${producer.task.delay}")
		int producerTaskDelay,
		
		@Value("${consumer.task.delay}")
		int consumerTaskDelay
		) {
		
		PRODUCER_TASK_DELAY = producerTaskDelay;
		CONSUMER_TASK_DELAY = consumerTaskDelay;
		
	}
	
	// Implementa
	@Bean
	public ExecutorService myExecutorService() {
		return Executors.newFixedThreadPool(2);
	}
}
