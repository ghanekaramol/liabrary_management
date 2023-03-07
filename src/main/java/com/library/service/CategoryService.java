package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.BookDTO;
import com.library.dto.CategoryDto;
import com.library.dto.CategoryResponseDto;
import com.library.exception.BookDeleteException;
import com.library.exception.DataNotFoundException;
import com.library.model.Book;
import com.library.model.Category;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired	
	private CategoryRepository categoryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	// add a category
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}	
	
	// get a single category
	public CategoryResponseDto getCategory(Integer categoryId)
	{
		if(categoryRepository.findById(categoryId).isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		Category cat = categoryRepository.findById(categoryId).get();
		CategoryResponseDto catRes = new CategoryResponseDto();
		catRes.setCategoryName(cat.getCategoryName());
		
		return catRes;
	}
	
	// get all categories
	public List<CategoryResponseDto> getAllCategory()
	{
		List<Category> catList = categoryRepository.findAll();
		if(catList.isEmpty())
		{
			throw new DataNotFoundException();
		}
		
		List<CategoryResponseDto> catResList = new ArrayList<>();
		catList.forEach(			
				(n) -> {
					CategoryResponseDto catRes = new CategoryResponseDto();
					catRes.setCategoryName(n.getCategoryName());
					catRes.setCategoryId(n.getId());
					catResList.add(catRes);
				}
				
				);
		return catResList;
	}
	
	//deletion of a category
	public void deleteCategory(Integer categoryId)
	{
	
	Category cat = categoryRepository.findById(categoryId).get();
	
	List<Book> book = cat.getBooks();
		
	book.forEach(		
			(n) ->
			{	
				if(n.getIssueStatus()!=null)
				{
					throw new BookDeleteException();
				}
			});
		
	categoryRepository.delete(cat);;
	}
	
	//update Category
	public CategoryResponseDto updateCategory(CategoryDto categoryDto)
	{
		Category cat = categoryRepository.findById(categoryDto.getCategoryId()).orElseThrow(() -> new DataNotFoundException());
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		
		cat.setCategoryName(categoryDto.getCategoryName());
		categoryRepository.save(cat);
		categoryResponseDto.setCategoryName(cat.getCategoryName());
		categoryResponseDto.setCategoryId(categoryDto.getCategoryId());
		
		return categoryResponseDto;
		
	}
}