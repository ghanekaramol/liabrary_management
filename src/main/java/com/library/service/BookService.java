package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.model.BookDTO;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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
}