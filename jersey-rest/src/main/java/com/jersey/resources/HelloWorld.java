package com.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloWorld {

	@GET
	@Path("{firstname}/{lastname}")
	public Response getMessage(@PathParam("firstname") String firstname,
			@PathParam("lastname") String lastname) {
		String output = "Jersey say Hello World!!! : " + firstname + "  "
				+ lastname;
		return Response.status(200).entity(output).build();
	}
}
