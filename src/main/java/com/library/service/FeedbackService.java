package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.FeedbackDto;
import com.library.dto.FeedbackResponseDto;
import com.library.exception.DataNotFoundException;
import com.library.exception.FeedbackException;
import com.library.model.Book;
import com.library.model.Feedback;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	// set feedback
	public void setFeedback(FeedbackDto feedbackDto)
	{
		Integer bookid = feedbackDto.getBookId();
		Book book = bookRepository.findById(bookid).get();
		if(bookRepository.findById(bookid).get().getIssueStatus() == null)
		{
			throw new FeedbackException();
		}
		User user = book.getUser();
		String feedbackDetail = feedbackDto.getFeedback();
		Feedback feedback = new Feedback();
		feedback.setBook(book);
		feedback.setFeedback(feedbackDetail);
		feedback.setUser(user);
		
		feedbackRepository.save(feedback);
	}
	
	//get feedback
	public List<FeedbackResponseDto> getFeedback()
	{
		List<FeedbackResponseDto> feedbackResponseDtoList = new ArrayList<>();
		List<Feedback> feedback = feedbackRepository.findAll();
		
		if(feedback.isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		feedback.forEach(
				(n) -> {
					FeedbackResponseDto feedbackResponseDto = new FeedbackResponseDto();
					feedbackResponseDto.setBook(n.getBook().getBookName());
					feedbackResponseDto.setFeedback(n.getFeedback());
					feedbackResponseDto.setUser(n.getUser().getEmailid());
					feedbackResponseDtoList.add(feedbackResponseDto);	
				}
				);
		return feedbackResponseDtoList;		
	}
	
}
