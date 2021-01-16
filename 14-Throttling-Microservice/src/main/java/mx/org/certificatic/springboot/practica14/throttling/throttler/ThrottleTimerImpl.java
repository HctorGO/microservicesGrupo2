package mx.org.certificatic.springboot.practica14.throttling.throttler;

import java.util.Timer;
import java.util.TimerTask;

public class ThrottleTimerImpl implements Throttler {

	// Define propiedad correspondiente el delay en el cual el throttler (regulador)
	// va a regular la cantidad de llamadas por segundo.
	private final int throttletPeriod;
	
	// Define la propiedad de bean CallsCount 
	private final CallsCount callsCount;
	// Inyecta propiedades por constructor

	public ThrottleTimerImpl(int throttletPeriod, CallsCount callsCount) {
		this.throttletPeriod = throttletPeriod;
		this.callsCount = callsCount;
	}
	
	@Override
	public void start() {

		// Implementa
		new Timer(true).schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				callsCount.resetAll();
			}
		}, 0, throttletPeriod);
	}
}
