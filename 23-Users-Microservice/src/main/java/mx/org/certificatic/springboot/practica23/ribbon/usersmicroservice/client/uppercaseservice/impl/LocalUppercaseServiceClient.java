package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.impl;

import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.client.uppercaseservice.IUppercaseService;

@Slf4j
//@Primary
@Service
public class LocalUppercaseServiceClient implements IUppercaseService {

	@Override
	@SneakyThrows
	public String toUppercase(String name, Map<String, String> vars) {

		log.info("generating uppercase value for {}", name);

		return name.toUpperCase();
	}

}
