package com.tms.entity;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "task_title")
	private String title;
	
	@Column(name="task_description")
	private String description;
	
	@Column(name="task_created_date")
	private Date currentDate;


	@ManyToOne
	private User user;

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String title, String description, Date currentDate, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.currentDate = currentDate;
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", currentDate=" + currentDate
				+ "]";
	}
	
	
	
	
	
}
