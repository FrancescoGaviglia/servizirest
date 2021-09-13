package com.prova;

import java.util.List;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
	
	public String addNote(@FormParam("title") String title,@FormParam("author") String author, @FormParam("review") String review )

}
