package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.model.BookRequest;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired(required = false)
	private Book book;
	
	public void addBook(BookRequest bookRequest)
	{
		//Book book = null;
		String bookRequestName = bookRequest.getBookName();
		Integer requestCategoryId = bookRequest.getCategoryId();
		
		book.setBookName(bookRequestName);
		book.setCategory(categoryRepository.findById(requestCategoryId).get());
		bookRepository.save(book);
	}	
}