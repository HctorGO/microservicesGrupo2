package mx.org.certificatic.springboot.practica26.zuul.apigateway.filter.post;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyPostFilter /*extends ZuulFilter*/ {

	//@Override
	public boolean shouldFilter() {
		return true;
	}

	//@Override
	public Object run() /*throws ZuulException*/ {
		/*RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest servletRequest = ctx.getRequest();
		HttpServletResponse servletResponse = ctx.getResponse();

		servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());

		log.info("[{} filter {}] Request Method: {}, Request URL: {}", filterType(), filterOrder(), servletRequest
				.getMethod(), servletRequest.getRequestURL().toString());
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
