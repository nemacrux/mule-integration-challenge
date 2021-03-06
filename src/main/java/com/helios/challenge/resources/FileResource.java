package com.helios.challenge.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.helios.challenge.service.DatabaseMongoServiceImpl;
import com.helios.challenge.service.IDatabaseService;

@Path("/files")
@Produces(MediaType.APPLICATION_JSON)
public class FileResource {
	
	IDatabaseService databaseService = new DatabaseMongoServiceImpl();
	
	@GET
	public Response getAllFiles(){
		List<String> documentNames;
		documentNames = databaseService.getAllDocumentNames();
		return Response
				.status(Status.OK)
				.entity(documentNames)
				.build();
	}
	
	@GET
	@Path("/{filename}")
	public Response getFileByName(@PathParam("filename") String filename){
		String document = databaseService.getDocumentByName(filename);
		return Response
				.status(Status.OK)
				.entity(document)
				.build();
	}

}
