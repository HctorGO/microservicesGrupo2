package mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.model.Message;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import mx.org.certificatic.springboot.practica11.queuebasedloadleveling.task.consumer.impl.SimpleTaskConsumer;

@Slf4j
// Elimina abstract
public class SimpleTaskProducer implements ITaskProducer, Runnable {
	
	// Implementa
	private ITaskConsumer taskConsumer;
	private int messageCount;
	private int delay;
	
	public SimpleTaskProducer(int messageCount, int delay, SimpleTaskConsumer taskConsumer) {
		this.messageCount = messageCount;
		this.delay = delay;
		this.taskConsumer = taskConsumer;
	}
	
	@Override
	public void run() {
		int count =  this.messageCount;
		
		try {
			while(count > 0) {
				String msg =  "Message-"+ count + " produced by " + Thread.currentThread().getName();
				Thread.sleep(delay);
				
				log.info(msg);
				
				this.produce(new Message(msg));
			}
		} catch(Exception e) {
			log.error("Error {}" , e);
		}
	}

	@Override
	public void produce(Message message) {
		// TODO Auto-generated method stub
		//this.me
	}

	
}