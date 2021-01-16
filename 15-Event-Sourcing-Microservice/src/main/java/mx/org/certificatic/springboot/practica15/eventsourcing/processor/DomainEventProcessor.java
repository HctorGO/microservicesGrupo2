package mx.org.certificatic.springboot.practica15.eventsourcing.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.org.certificatic.springboot.practica15.eventsourcing.events.DomainEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;

@Component
public class DomainEventProcessor {

	@Autowired
	private JsonFileJournal processorJournal;

	public void process(DomainEvent domainEvent) {

		// Implementa
		domainEvent.process();
		processorJournal.write(domainEvent);
	}

	public void reset() {
		// Implementa
		processorJournal.reset();
	}

	public void recover() {

		// Implementa
		processorJournal.readJournal();
		DomainEvent event;
		
		while(true) {
			event = processorJournal.readNext();
			if(event == null) {
				break;
			} else {
				
				event.process();
				//AccountHolder.nextEventId(); 
			}
		}
	}
}
