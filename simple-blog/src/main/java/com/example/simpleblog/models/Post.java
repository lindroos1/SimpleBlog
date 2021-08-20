package com.example.simpleblog.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.User;

import javax.persistence.Id;



@Entity
@Table(name="posts")
public class Post {
	

    @Id	
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private User author;
	private String body;
	private Date date;
	private String title;

	public String getTitle() { 
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Post() {
		date = new Date();
		//TODO: create a timestamp at the creation of the post
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setText(String text) {
		this.body = text;
	}
}
