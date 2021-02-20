package mx.org.certificatic.springboot.practica26.zuul.apigateway.filter.route;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyRouteFilter /*extends ZuulFilter*/ {

	//@Override
	public boolean shouldFilter() {
		return true;
	}

	//@Override
	public Object run() /*throws ZuulException*/ {
		/*RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("[{} filter {}] Request Method: {}, Request URL: {}", filterType(), filterOrder(), request
				.getMethod(), request.getRequestURL().toString());
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
