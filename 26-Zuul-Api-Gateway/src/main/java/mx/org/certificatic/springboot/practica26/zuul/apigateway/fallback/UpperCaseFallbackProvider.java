package mx.org.certificatic.springboot.practica26.zuul.apigateway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpperCaseFallbackProvider /*implements FallbackProvider*/ {

	private String responseBody = "{\"message\":\"Service Unavailable. Please try after sometime\"}";

	// @Override
	public String getRoute() {
		return "uppercase-microservice";
	}

	// @Override
	public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
		log.info("[Fallback Provider] Exception {}: {}", cause.getClass().getSimpleName(), cause.getMessage());
		/*if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return response(HttpStatus.SERVICE_UNAVAILABLE);
		}*/
		
		return null; // eliminar
	}

	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase() + " customized";
			}

			@Override
			public void close() {
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream(responseBody.getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}