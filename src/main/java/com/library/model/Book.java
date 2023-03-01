package com.library.model;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	public Book(int bookId, String issueStatus, String bookName, User user, Category category) {
		super();
		this.bookId = bookId;
		this.issueStatus = issueStatus;
		this.bookName = bookName;
		this.user = user;
		this.category = category;
	}

	@ManyToOne
	@JoinColumn(name="Category_Id")
	@JsonBackReference
	private Category category;

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
