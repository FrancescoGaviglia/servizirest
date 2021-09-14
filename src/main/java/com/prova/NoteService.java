package com.prova;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/noteservice")
public class NoteService {

	NoteDao noteDao = new NoteDao();

	@GET
	@Path("/notelist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> displayNote(){
		return noteDao.getAllNotes();
	}
	@POST
	@Path("/addnote")
	@Produces(MediaType.APPLICATION_JSON)
	public String addNote(@FormParam("title") String title,@FormParam("author") String author, @FormParam("review") String review) throws IOException {
		return noteDao.addNote(title, author, review);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNote(@PathParam("id") Long id) {
		noteDao.deleteNote(id);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Path("/updatenote/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateNote(@PathParam("id") Long id, @FormParam("title") String title,@FormParam("author") String author, @FormParam("review") String review) throws IOException {
		return noteDao.updateNote(id, title, author, review);
	}

}
