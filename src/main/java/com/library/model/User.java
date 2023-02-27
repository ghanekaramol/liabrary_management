package com.library.model;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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


	public User(int id, String firstName, String lastName, String emailid, String password, Set<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		this.password = password;
		this.roles = roles;
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
	

	
	
}
