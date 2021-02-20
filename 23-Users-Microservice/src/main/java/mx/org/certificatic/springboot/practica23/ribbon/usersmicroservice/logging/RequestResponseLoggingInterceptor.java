/**
 * 
 */
package mx.org.certificatic.springboot.practica23.ribbon.usersmicroservice.logging;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hgore
 *
 */
@Slf4j
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		logRequest(request, body);
	
		ClientHttpResponse response =  execution.execute(request, body);
		
		logResponse(response);
		
		return response;
	}

	@SneakyThrows
	private void logRequest(HttpRequest request, byte[] body) {
		if (log.isDebugEnabled()) {
			log.debug("====================== Request Begin ======================");
			log.debug("URI			: {}", request.getURI().toString());
			log.debug("Method		: {}", request.getMethod());
			log.debug("Headers		: {}", request.getHeaders());
			log.debug("Request Body	: {}", new String(body, "UTF-8"));
			log.debug("====================== Request End ======================");
		}
	}
	
	@SneakyThrows
	private void logResponse(ClientHttpResponse response) {
		if (log.isDebugEnabled()) {
			log.debug("====================== Response Begin ======================");
			log.debug("Status code		: {}", response.getStatusCode());
			log.debug("Status text		: {}", response.getStatusText());
			log.debug("Headers			: {}", response.getHeaders());
			//log.debug("Response Body	: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
			log.debug("====================== Response End ======================");
		}
	}
	
}
