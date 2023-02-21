package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Category;
import com.library.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired	
	private CategoryRepository categoryRepository;
	
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}	
}