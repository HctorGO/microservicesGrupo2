package mx.org.certificatic.springboot.practica26.zuul.apigateway.filter.pre;

import java.util.Random;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyPreFilter2 /*extends ZuulFilter*/ {

	private Random random = new Random();

	//@Override
	public boolean shouldFilter() {
		return true;
	}

	//@Override
	public Object run() /*throws ZuulException*/ {
		/*RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest servletRequest = ctx.getRequest();

		log.info("[{} filter {}] Request Method: {}, Request URL: {}", filterType(), filterOrder(), servletRequest
				.getMethod(), servletRequest.getRequestURL().toString());

		if (random.nextBoolean())
			throw new RuntimeException("random is true =(");
		*/
		return null;
	}

	// @Override
	public String filterType() {
		return null; // modificar
	}

	// @Override
	public int filterOrder() {
		return 0; // modificar
	}

}
