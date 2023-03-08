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

import com.library.dto.CategoryDto;
import com.library.dto.CategoryResponseDto;
import com.library.message.Message;
import com.library.model.Category;
import com.library.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService CategoryService;
	
	// adding a category
	@PostMapping("/admin/addcat")
	public ResponseEntity<Message> addCategory(@RequestBody Category category)
	{
		CategoryService.addCategory(category);
		Message m = new Message();
		m.setMessage("Category added sucessfully !!");
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	// Retrieving a category
	@GetMapping("/user/getCategory")
	public ResponseEntity<CategoryResponseDto> getCategory(@RequestBody Integer categoryId)
	{	
			return new ResponseEntity<>(CategoryService.getCategory(categoryId),HttpStatus.OK);	
	}
	
	//Retrieving list of Category
	@GetMapping("/user/getAllCategory")
	public ResponseEntity<List<CategoryResponseDto>> getAllCategory()
	{
			return new ResponseEntity<>(CategoryService.getAllCategory(),HttpStatus.OK);	
	}
	
	// Delete a category
	@DeleteMapping("/admin/deleteCategory")
	public ResponseEntity<Message> deleteCategory(@RequestBody Integer categoryId)
	{
			CategoryService.deleteCategory(categoryId);
			Message m = new Message();
			m.setMessage("Category deleted Successfully!!");
			return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	//update a category
	@PutMapping("/admin/updateCategory")
	public ResponseEntity<CategoryResponseDto> updateCategory(@RequestBody CategoryDto categoryDto)
	{
			return new ResponseEntity<>(CategoryService.updateCategory(categoryDto),HttpStatus.OK);
	}
	
	
		
}
