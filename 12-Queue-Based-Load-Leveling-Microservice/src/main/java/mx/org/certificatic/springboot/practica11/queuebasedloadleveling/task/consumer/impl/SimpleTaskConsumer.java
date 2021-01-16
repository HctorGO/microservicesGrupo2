package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;

@Slf4j
// elimina abstract
public class SimpleTaskConsumer implements ITaskConsumer {

	// Implementa
	private int delay;
	
	public SimpleTaskConsumer(int delay) {
		this.delay = delay;
	}

	@Override
	@SneakyThrows
	public void consume(Message message) {
		// TODO Auto-generated method stub
		Thread.sleep(delay);
		
		log.info(message.getMessage() + "is consumeed.");
	}
	
}
