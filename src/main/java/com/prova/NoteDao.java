package com.prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {

	public List<Note> getAllNotes(){


		List<Note> noteList = null;
		Note note = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servizirest", "root", "CeLaFaremo2020!");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from note");
			noteList = new ArrayList<>();
			while(rs.next()) {
				note = new Note();
				note.setId(rs.getLong("id"));
				note.setTitle(rs.getString("title"));
				note.setAuthor(rs.getString("author"));//all'interno della parentesi è il nome della colonna del db
				note.setReview(rs.getString("review"));

				noteList.add(note);
			}
			rs.close();
			stmt.close();
			con.close();

			return noteList;
		}catch (Exception e) {
			System.out.println(e);
		}
		return noteList;
	}

	public String addNote(String title, String author, String review) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servizirest", "root", "CeLaFaremo2020!");
			Statement stmt=con.createStatement();
			int result = stmt.executeUpdate("insert into note(title, author, review) values ('"+title+"','"+author+"','"+review+"')");

			if (result == 1) {
				return "success";
			}
			stmt.close();
			con.close();

		}catch (Exception e) {
			System.out.println(e);
		}
		return "fail";
	}

	public void deleteNote(Long id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servizirest", "root", "CeLaFaremo2020!");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("delete from note where id =("+id+")");

			stmt.close();
			con.close();

		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public String updateNote(Long id, String title, String author, String review) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servizirest", "root", "CeLaFaremo2020!");
			Statement stmt=con.createStatement();
			int result = stmt.executeUpdate("update note set title='"+title+"', author ='"+author+"', review='"+review+"' where id= "+id+"");

			if (result == 1) {
				return "success";
			}
			stmt.close();
			con.close();

		}catch (Exception e) {
			System.out.println(e);
		}
		return "fail";
	}

}




