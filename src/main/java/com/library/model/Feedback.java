package com.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@Column(name="feedback_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="feedback")
	private String feedback;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	@JsonBackReference(value="BF_reference")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference(value="UF_reference")
	private User user;

	
	public Feedback(int id, String feedback, Book book, User user) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.book = book;
		this.user = user;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
