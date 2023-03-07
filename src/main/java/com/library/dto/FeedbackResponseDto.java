package com.library.dto;

import com.library.model.Book;
import com.library.model.User;

public class FeedbackResponseDto {

	private String feedback;
	private String book;
	private String user;
	
	
	
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	

	
}
