package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.BookDTO;
import com.library.model.Category;
import com.library.service.BookService;
import com.library.service.CategoryService;

@RestController
public class BookAndCategoryController {

	@Autowired
	private CategoryService CategoryService;
	@Autowired
	private BookService bookService;
	
	// adding a category
	@PostMapping("/admin/addcat")
	public ResponseEntity<String> addCategory(@RequestBody Category category)
	{
		try {
			if(category!=null)
			{
				CategoryService.addCategory(category);
			}
			else
			{
				return new ResponseEntity<>("Category is null !!",HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Category addition is failed !!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Category added sucessfully !!", HttpStatus.OK);
	}
	
	// Retrieving a category
	@GetMapping("/admin/getCategory")
	public ResponseEntity<Category> getCategory(@RequestBody Integer categoryId)
	{
		try {
			
			return new ResponseEntity<>(CategoryService.getCategory(categoryId),HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//Retrieving list of Category
	@GetMapping("/admin/getAllCategory")
	public ResponseEntity<List<Category>> getAllCategory()
	{
		try {
			return new ResponseEntity<>(CategoryService.getAllCategory(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	// Delete a category
	@DeleteMapping("/admin/deleteCategory")
	public ResponseEntity<String> deleteCategory(@RequestBody Integer categoryId)
	{
		try
		{
			CategoryService.deleteCategory(categoryId);
			return new ResponseEntity<>("Category deleted successfully !!",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Can't delete category!!",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	@PostMapping("/admin/addbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO bookRequest)
	{
		try {
			if(bookRequest!=null)
			{
				bookService.addBook(bookRequest);
			}
			else
			{
				return new ResponseEntity<>("Book is null !!",HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>("Book addition is failed!!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Book added sucessfully !!", HttpStatus.OK);
	}
	
}
