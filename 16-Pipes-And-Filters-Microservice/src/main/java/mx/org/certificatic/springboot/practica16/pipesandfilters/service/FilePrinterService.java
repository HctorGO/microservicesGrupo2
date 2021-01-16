package mx.org.certificatic.springboot.practica16.pipesandfilters.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilePrinterService {

	@SneakyThrows
	public File print(File file, Map<String, String> headers) {

		// Implementa
		log.info("headers: {}", headers);
		
		@Cleanup
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String linea = null;
		
		while((linea = br.readLine()) != null) {
			log.info(linea);
		}
		
		return file;
	}
}
