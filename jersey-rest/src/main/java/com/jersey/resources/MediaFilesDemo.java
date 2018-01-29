package com.jersey.resources;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("files")
public class MediaFilesDemo {

	private static final String TEXTFILE_PATH = "project.log";

	private static final String IMAGEFILE_PATH = "Chrysanthemum.jpg";

	private static final String PDFFILE_PATH = "w_hado01.pdf";

	private static final String EXCELFILE_PATH = "EXCEL12.XLSX";

	@GET
	@Path("/text")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getTextFile() {
		
		InputStream in = this.getClass().getResourceAsStream(TEXTFILE_PATH);
		ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
		response.header("Content-Disposition",
				"attachment; filename=\"" + TEXTFILE_PATH + "\"");
		return response.build();

	}

	@GET
	@Path("/image")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getImageFile() {

		InputStream in = this.getClass().getResourceAsStream(IMAGEFILE_PATH);

		ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
		response.header("Content-Disposition",
				"attachment; filename=\"" + IMAGEFILE_PATH + "\"");
		return response.build();

	}

	@GET
	@Path("/pdf")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getPDFFile() {

		InputStream in = this.getClass().getResourceAsStream(PDFFILE_PATH);

		ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
		response.header("Content-Disposition",
				"attachment; filename=\"" + PDFFILE_PATH + "\"");
		return response.build();

	}

	@GET
	@Path("/excel")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getExcelFile() {

		InputStream in = this.getClass().getResourceAsStream(EXCELFILE_PATH);

		ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
		response.header("Content-Disposition",
				"attachment; filename=\"" + EXCELFILE_PATH + "\"");
		return response.build();

	}
}
