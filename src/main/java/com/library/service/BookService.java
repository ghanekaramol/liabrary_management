package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addBook(Book book)
	{
//		Category cat = (Category) categoryRepository.findByCategoryName();
//		book.setCategory(cat);
		book.setCategory(categoryRepository.findById(1).get());
		bookRepository.save(book);
	}	
}