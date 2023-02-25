package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Category;
import com.library.model.CategoryDTO;
import com.library.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired	
	private CategoryRepository categoryRepository;
	
	// add a category
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}	
	
	// get a single category
	public Category getCategory(Integer categoryId)
	{
		return categoryRepository.findById(categoryId).get();
	}
	
	// get all categories
	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}
	
	//deletion of a category
	public void deleteCategory(Integer categoryId)
	{
		categoryRepository.deleteById(categoryId);
	}
	
	public Category updateCategory(Category category )
	{
		Category cat = new Category();
		
			
		category.setCategoryNamecat.getCategoryName()))
		category.setBooks(cat.getBooks());
			
		return categoryRepositorysave(category));
	}
		

}