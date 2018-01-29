package com.jersey.logging;

import java.io.IOException;

import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class LoggingResponseFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest requestContext,
			ContainerResponse responseContext) {
		String method = requestContext.getMethod();

		System.out.println("Requesting " + method + " for path "
				+ requestContext.getPath());
		Object entity = responseContext.getEntity();
		if (entity != null) {
			try {
				System.out.println("Response "
						+ new ObjectMapper().writerWithDefaultPrettyPrinter()
								.writeValueAsString(entity));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return responseContext;
	}

}