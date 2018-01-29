package com.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("params")
public class ParamsDemo {

	@GET
	@Path("queryParams")
	public String queryParams(@QueryParam("managername") String managername) {
		return managername;
	}

	@GET
	@Path("queryParamsList")
	public String queryParamsList(
			@QueryParam("managername") List<String> managername) {
		return managername.toString();
	}

	@GET
	@Path("matrixParams")
	public String matrixParams(@MatrixParam("managername") String managername) {
		return managername;
	}

	@POST
	@Path("formParam")
	@Consumes("application/x-www-form-urlencoded")
	public String formParam(@FormParam("managername") String managername) {
		return managername;
	}

	@POST
	@Path("allFormParams")
	@Consumes("application/x-www-form-urlencoded")
	public String allFormParams(MultivaluedMap<String, String> formParams) {
		return formParams.entrySet().toString();
	}

	@GET
	@Path("uriInfo")
	public String uriInfo(@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
//		MultivaluedMap<String, String> pathParams = ui.getPathParameters();
//		URI absPath = ui.getAbsolutePath();
		return queryParams.entrySet().toString();
	}

	@GET
	@Path("headerInfo")
	public String headerInfo(@Context HttpHeaders hh) {
//		MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
//		Map<String, Cookie> pathParams = hh.getCookies();
		hh.getAcceptableLanguages();
//		hh.getAcceptableMediaTypes();
		return hh.getAcceptableLanguages().toString();
	}

}
