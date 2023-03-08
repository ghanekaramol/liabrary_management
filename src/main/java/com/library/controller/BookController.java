package com.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.ResponseClass.BookResponse;
import com.library.dto.BookDTO;
import com.library.message.Message;
import com.library.model.Book;
import com.library.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	//adding a book
	@PostMapping("/admin/addbook")
	public ResponseEntity<Message> addBook(@RequestBody @Validated BookDTO bookRequest)
	{
		Message m = new Message();
		m.setMessage("Book added successfully..!!");
		bookService.addBook(bookRequest);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	//retrieve a book
	@GetMapping("/user/getBook")
	public ResponseEntity<BookResponse> getBook(@RequestBody Integer bookId)
	{
			return new ResponseEntity<>(bookService.getBook(bookId),HttpStatus.OK);	
	}
	
	//get all book as a list
	@GetMapping("/user/getAllBooks")
	public ResponseEntity<List<BookResponse>> getAllBooks()
	{
			return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
	}
	
	//delete a book
	@DeleteMapping("/admin/deleteBook")
	public ResponseEntity<Message> deleteBook(@RequestBody Integer bookId)
	{
		bookService.deleteBook(bookId);
		Message m = new Message();
		m.setMessage("Book deleted successfully..!!");
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@PutMapping("/admin/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
	}
	
	//issuing a book
	@PostMapping("/admin/issueBook")
	public ResponseEntity<Message> issueBook(@RequestBody BookDTO bookDto) throws Exception
	{
			bookService.issueBook(bookDto);
			Message m = new Message();
			m.setMessage("Book issues");
			return new ResponseEntity<>(m,HttpStatus.OK);
	}
		
	//removing book from issue status
	@PostMapping("/admin/removeIssueBook")
	public ResponseEntity<Message> removeIssuedBook(@RequestBody Integer bookId)
	{
			bookService.removeIssuedBook(bookId);
			Message m = new Message();
			m.setMessage("Book is removed from issue status..!");
			return new ResponseEntity<>(m,HttpStatus.OK);
		
	}
	
	// list of all issued book
	@GetMapping("/user/listOfIssuedBook")
	public ResponseEntity<List<BookResponse>> listOfIssueBook() throws Exception
	{
			return new ResponseEntity<>(bookService.listOfIssueBook(),HttpStatus.OK);
		
	}
	
	
}
