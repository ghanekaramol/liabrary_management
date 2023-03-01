package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
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
	@GetMapping("/getCategory")
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
	@GetMapping("/getAllCategory")
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
	
	//update a category
	@PutMapping("/admin/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category)
	{
		try {
			CategoryService.updateCategory(category);
			System.out.println("try executing"+category);
			return new ResponseEntity<>(category,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("catch is executing");
			System.out.println(category);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//adding a book
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
	
	//retrieve a book
	@GetMapping("/getBook")
	public ResponseEntity<Book> getBook(@RequestBody Integer bookId)
	{
		try {
			return new ResponseEntity<>(bookService.getBook(bookId),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//get all book as a list
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		try {
			return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//delete a book
	@DeleteMapping("/admin/deleteBook")
	public ResponseEntity<String> deleteBook(@RequestBody Integer bookId)
	{
		bookService.deleteBook(bookId);
		return new ResponseEntity<>("Book deleted where book id is = " + bookId,HttpStatus.OK);
	}
	
	@PutMapping("/admin/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		try {
			System.out.println(book);
			return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//issuing a book
	@PostMapping("/admin/issueBook")
	public ResponseEntity<String> issueBook(@RequestBody BookDTO bookDto) throws Exception
	{
			bookService.issueBook(bookDto);
			return new ResponseEntity<>("Book is issued !!",HttpStatus.OK);
	}
		
	
	//removing book from issue status
	@PostMapping("/admin/removeIssueBook")
	public ResponseEntity<String> removeIssuedBook(@RequestBody Integer bookId)
	{
		try {
			bookService.removeIssuedBook(bookId);
			return new ResponseEntity<>("Book is removed from issue status ..!!",HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Can't change the issue status...!",HttpStatus.BAD_REQUEST);
		}
	}
	
	// list of all issued book
	@GetMapping("/admin/listOfIssuedBook")
	public ResponseEntity<List<Book>> listOfIssueBook() throws Exception
	{
			return new ResponseEntity<>(bookService.listOfIssueBook(),HttpStatus.OK);
		
	}
	
	
		
}
