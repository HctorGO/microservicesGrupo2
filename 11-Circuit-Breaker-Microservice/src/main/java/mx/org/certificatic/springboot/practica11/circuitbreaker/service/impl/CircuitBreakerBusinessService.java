package mx.org.certificatic.springboot.practica11.circuitbreaker.service.impl;

import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import mx.org.certificatic.springboot.practica11.circuitbreaker.controller.model.StatusResponse;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.IBusinessService;
import mx.org.certificatic.springboot.practica11.circuitbreaker.service.exception.ServiceException;

public class CircuitBreakerBusinessService implements IBusinessService {

	// Defina Target object IBusinessService businessService
	private IBusinessService proxiedBusinessService;
	
	// Defina propiedad Circuit Breaker
	private CircuitBreaker circuitBreaker;

	// Defina propiedad Supplier<StatusResponse> decoratedSupplier
	private Supplier<StatusResponse> decoretedSupplier; 
	
	// Inyecte por constructor propiedades IBusinessService businessService, CircuitBreaker circuitBreaker
	// En el constructor decore el Supplier mediante CircuitBreaker.decorateSupplier(this.circuitBreaker, this.businessService::perform);
	public CircuitBreakerBusinessService() {
		this.proxiedBusinessService = proxiedBusinessService;
		this.circuitBreaker = circuitBreaker;
		this.decoretedSupplier = CircuitBreaker.decorateSupplier(this.circuitBreaker, this.proxiedBusinessService::perform);
	}
	
	@Override
	public StatusResponse perform() throws ServiceException {
		
		// implemente
		return Try.ofSupplier(this.decoretedSupplier)
				.recover(this::fallback)
				.get();
	}

	// Defina metodo fallback
	public StatusResponse fallback(Throwable ex) {
		return new StatusResponse(200, "DEFAULT RESPONSE");
	}
	
}
