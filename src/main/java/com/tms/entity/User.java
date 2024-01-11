package com.tms.entity;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="city")
	private String city;

	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Task> tasks=new ArrayList<>();
	
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String email, String password, String city, List<Task> tasks) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.city = city;
		this.tasks = tasks;
	}

	public User(int id, String username, String email, String password, String city) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", city="
				+ city + ", tasks=" + tasks + "]";
	}
	
	
	
	
}
