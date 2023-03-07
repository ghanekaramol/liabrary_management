package com.library.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex, WebRequest request)
	{
		Map<String, Object> body = new HashMap<>();
		
		//body.put("timestamp", LocalDateTime.now());
		body.put("message","No student found..");
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BookDeleteException.class)
	public ResponseEntity<Object> handleBookDeleteException(BookDeleteException e, WebRequest request)
	{
		Map<String, Object> body = new HashMap<>();
		
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Book is issued You can not delete....");
		
		return new ResponseEntity<>(body,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(BookIssueException.class)
	public ResponseEntity<Object> handleAddBookIssueException()
	{
		Map<String, Object> body = new HashMap<>();
		
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Book is issued already....");
		
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookRemoveIssueException.class)
	public ResponseEntity<Object> handleBookRemoveIssueException()
	{
		Map<String, Object> body = new HashMap<>();
		
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Book is not issued to anyone....");
		
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<Object> handleFeedbackException()
	{
		Map<String, Object> body = new HashMap<>();
		
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Issue booki first..");
		
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}
}
