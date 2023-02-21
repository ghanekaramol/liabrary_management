package com.library.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@Column(name="Category_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Category_Name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<Book> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category(int id, String categoryName, List<Book> books) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.books = books;
	}

	public Category() {
		super();
	}	
}
