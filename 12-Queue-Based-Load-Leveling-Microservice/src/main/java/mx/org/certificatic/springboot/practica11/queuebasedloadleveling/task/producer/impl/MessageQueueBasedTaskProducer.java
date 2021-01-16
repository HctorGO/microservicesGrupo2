package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

@Slf4j
// Elimina abstract
public class MessageQueueBasedTaskProducer implements ITaskProducer, Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void produce(Message message) {
		// TODO Auto-generated method stub
		
	}

	// Implementa
	
	
}