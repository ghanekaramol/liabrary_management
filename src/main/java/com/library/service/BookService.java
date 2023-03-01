package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.model.BookDTO;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;
import com.library.repository.UserRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//adding a book
	public void addBook(BookDTO bookRequest)
	{
		String bookRequestName = bookRequest.getBookName();
		Integer requestCategoryId = bookRequest.getCategoryId();
		Book book = new Book();
		book.setBookName(bookRequestName);
		book.setCategory(categoryRepository.findById(requestCategoryId).get());
		bookRepository.save(book);
	}
	
	//fetching a single book
	public Book getBook(Integer bookId)
	{
		return bookRepository.findById(bookId).get();
	}
	
	//fetching all books
	public List<Book> getAllBook()
	{
		return bookRepository.findAll();
	}
	
	//delete a book
	public void deleteBook(Integer bookId)
	{
		bookRepository.deleteById(bookId);
	}
	
	//update the book
	public Book updateBook(Book book)
	{
		Book bookObj = bookRepository.findById(book.getBookId()).get();
		bookObj.setBookName(book.getBookName());
		book.setCategory(bookObj.getCategory());
		return bookRepository.save(bookObj);	
	}
	
	//issue a book
	public Book issueBook(BookDTO bookDto) throws Exception
	{
			
		Book book = bookRepository.findById(bookDto.getBookId()).get();
		User user = userRepository.findById(bookDto.getUserId()).get();
		if(book.getIssueStatus() == null)
		{
			book.setIssueStatus("Issued");
			book.setUser(user);
			return bookRepository.save(book);
		}
		else {
			throw new Exception("Book is issued already");
		}
		}
			
	
	public Book removeIssuedBook(Integer bookId) throws Exception
	{
		try {
		Book book = bookRepository.findById(bookId).get();
		if(book.getIssueStatus()!=null)
		{
			book.setIssueStatus(null);
			book.setUser(null);
			return bookRepository.save(book);
		}
		else {
			throw new Exception();
		}
		}catch(Exception e)
		{
			throw new Exception();
		}
		
	}

	//list of issued book
	public List<Book> listOfIssueBook() throws Exception
	{
		return bookRepository.findAllIssuedBook();	
	}

}