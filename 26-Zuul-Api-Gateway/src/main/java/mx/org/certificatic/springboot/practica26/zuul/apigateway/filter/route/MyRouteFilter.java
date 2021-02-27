package mx.org.certificatic.springboot.practica26.zuul.apigateway.filter.route;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyRouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("[{} filter {}] Request Method: {}, Request URL: {}", filterType(), filterOrder(), request
				.getMethod(), request.getRequestURL().toString());
				
		return null;
	}

	// @Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE; // modificar
	}

	// @Override
	public int filterOrder() {
		return FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER - 1; // modificar
	}

}
