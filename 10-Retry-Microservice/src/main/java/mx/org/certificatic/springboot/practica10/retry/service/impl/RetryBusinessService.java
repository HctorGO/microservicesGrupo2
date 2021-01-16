package mx.org.certificatic.springboot.practica10.retry.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import mx.org.certificatic.springboot.practica10.retry.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica10.retry.service.IBusinessService;
import mx.org.certificatic.springboot.practica10.retry.service.exception.ServiceException;

//Cambie de abstract a final
public abstract class RetryBusinessService implements IBusinessService {

	// Define propiedad Target Object
	private final IBusinessService proxiesBusinessService;
	private final int maxAttempts;
	private final long delay;
	private final AtomicInteger attempts;

	// Inyecta propiedades por constructor excepto attempts, en el constructor
	// inicializa el atomic integer.
	public RetryBusinessService(IBusinessService proxiesBusinessService, int maxAttempts, int delay) {
		this.proxiesBusinessService = proxiesBusinessService;
		this.maxAttempts = maxAttempts;
		this.delay = delay;
		this.attempts = new AtomicInteger();
	}
	
	public int attempts() {
		return this.attempts.intValue();
	}

	// Define metodo attempts

	@Override
	public StatusResponse perform() throws ServiceException {
		// Implemente
		return null;
	}

	// Implementa metodo setRetries
	
	// Implementa metodo setAttempts
}
