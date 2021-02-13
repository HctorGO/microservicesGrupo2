package mx.org.certificatic.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import lombok.SneakyThrows;

@Component
public class EurekaClientHelper {

	// Inyecta EurekaClient eurekaClient;
	@Autowired
	private EurekaClient eurekaClient;

	private Random random = new Random();
	
	@SneakyThrows
	public URI getServiceURI(String appName) {
		// Implementa
		
		/*
		List<InstanceInfo> listInstances = getInstances(appName);
		if(listInstances != null && listInstances.size() > 0) {
			return  new URI(listInstances.get(random.nextInt(6) % listInstances.size()).getHomePageUrl());
		}
		
		return null;
		
		*/
		InstanceInfo instance =  eurekaClient.getNextServerFromEureka(appName, false);
		return new URI(instance.getHomePageUrl());
	}

	public List<InstanceInfo> getInstances(String appName) {
		// Implementa
		return eurekaClient.getInstancesByVipAddress(appName, false);
	}
}
