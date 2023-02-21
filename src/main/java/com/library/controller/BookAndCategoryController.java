package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.model.Book;
import com.library.model.Category;
import com.library.service.BookService;
import com.library.service.CategoryService;

@RestController
public class BookAndCategoryController {

	@Autowired
	private CategoryService CategoryService;
	@Autowired
	private BookService bookService;
	
	@PostMapping("/admin/addcategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
	{
		try {
			if(category!=null)
			{
				CategoryService.addCategory(category);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Category is null !!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Category added sucessfully !!", HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/addbook")
	public ResponseEntity<String> addBook(@RequestBody Book book)
	{
		try {
			if(book!=null && book.getCategory()!=null)
			{
					bookService.addBook(book);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Book is null !!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Book added sucessfully !!", HttpStatus.OK);
	}
	
}
