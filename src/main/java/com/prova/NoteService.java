package com.prova;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

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
	public String addNote(@FormParam("title") String title,@FormParam("author") String author, @FormParam("review") String review,
			@Context HttpServletResponse servletResponse) throws IOException {
		return noteDao.addNote(title, author, review);
	}
	
	@DELETE
	@Path("/deletenote")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteNote(@FormParam("id") Long id, @Context HttpServletResponse servletResponse) throws IOException{
		noteDao.deleteNote(id);
		return "elemento eliminato";
	}

}
