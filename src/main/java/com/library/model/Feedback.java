package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


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
