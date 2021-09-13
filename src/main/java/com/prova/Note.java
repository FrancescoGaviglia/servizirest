package com.prova;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="note")
public class Note {
	
	private Long id;
	private String title;
	private String author;
	private String review;
	
	public Note() {
		super();
	}
	
	public Note(Long id, String title, String author, String review) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.review = review;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	

	
}
