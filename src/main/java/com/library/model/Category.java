package com.library.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Category {

	@Id
	@Column(name="Category_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Category_Name")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "category")
	@JsonManagedReference(value="BC_reference")
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
