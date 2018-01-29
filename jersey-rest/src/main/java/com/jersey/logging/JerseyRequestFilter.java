package com.jersey.logging;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Provider
public class JerseyRequestFilter implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		System.out.println(request.getPath());
		return request;
	}

}
