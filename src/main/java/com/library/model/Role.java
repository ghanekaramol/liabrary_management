package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role {

	@Id
	@Column(name = "Role_Id")
	private int id;
	@Column(name = "Role_Name")
	private String role;
	@ManyToMany
	private Set<User> user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Role(int id, String role, Set<User> user) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
