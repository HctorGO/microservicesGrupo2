package mx.org.certificatic.springboot.practica26.zuul.apigateway.filter.post;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyPostFilter extends ZuulFilter {

	//@Override
	public boolean shouldFilter() {
		return true;
	}

	//@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest servletRequest = ctx.getRequest();
		HttpServletResponse servletResponse = ctx.getResponse();

		servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());

		log.info("[{} filter {}] Request Method: {}, Request URL: {}", filterType(), filterOrder(), servletRequest
				.getMethod(), servletRequest.getRequestURL().toString());
		

		//throw new RuntimeException("Algun error");
		
		return null;
	}

	// @Override
	public String filterType() {
		return FilterConstants.POST_TYPE; // modificar
	}

	// @Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1; // modificar
	}

}
