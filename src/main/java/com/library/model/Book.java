package com.library.model;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@ComponentScan
public class Book {

	@Id
	@Column(name="Book_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name="Issue_status")
	private String issueStatus;
	@Column(name="Book_Name")
	private String bookName;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "book")
	@Column(name="feedbackId")
	@JsonManagedReference (value="BF_reference")
	private List<Feedback> feedbacks;

	@ManyToOne
	@JoinColumn(name="Category_Id")
	@JsonBackReference(value="BC_reference")
	private Category category;

	
	
	public Book(int bookId, String issueStatus, String bookName, User user, List<Feedback> feedbacks,
			Category category) {
		super();
		this.bookId = bookId;
		this.issueStatus = issueStatus;
		this.bookName = bookName;
		this.user = user;
		this.feedbacks = feedbacks;
		this.category = category;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
