package com.library.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="User_Table")
public class User{

	@Id
	@Column(name="User_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Email_Id")
	private String emailid;
	@Column(name = "Password")
	private String password;
	
	
	@ManyToMany
	@JoinTable(name="User_Role", 
			joinColumns= {@JoinColumn(name = "User_Id")}
			,inverseJoinColumns = {@JoinColumn(name = "Role_Id")})
	
	private Set<Role> roles;
	
	@OneToMany
	@JoinTable(name="User_Book", 
	joinColumns= {@JoinColumn(name = "User_Id")}
	,inverseJoinColumns = {@JoinColumn(name = "Book_Id")})
	private List<Book> books;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value="UF_reference")
	private List<Feedback> feedbacks;
	

	public User(int id, String firstName, String lastName, String emailid, String password, Set<Role> roles,
			List<Book> books, List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		this.password = password;
		this.roles = roles;
		this.books = books;
		this.feedbacks = feedbacks;
	}


	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

	
	
}
