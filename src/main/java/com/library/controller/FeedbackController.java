package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.dto.FeedbackDto;
import com.library.dto.FeedbackResponseDto;
import com.library.message.Message;
import com.library.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/user/feedback")
	public ResponseEntity<Message> setFeedback(@RequestBody FeedbackDto feedbackDto )
	{
		feedbackService.setFeedback(feedbackDto);
		Message m = new Message();
		m.setMessage("Feedback is added successfully !!");
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@GetMapping("/user/listOfFeedbacks")
	public ResponseEntity<List<FeedbackResponseDto>> getFeedbackList()
	{
		return new ResponseEntity<List<FeedbackResponseDto>>(feedbackService.getFeedback(),HttpStatus.OK);
	}
	
}
