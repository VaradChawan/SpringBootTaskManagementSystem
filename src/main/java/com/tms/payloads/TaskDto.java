package com.tms.payloads;

import java.util.Date;


public class TaskDto {

	private int id;
	
	private String title;
	
	private String description;
	
	private Date currentDate;

	private UserDto user;
	
	
	
	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
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

	
	
	public TaskDto(int id, String title, String description, Date currentDate, UserDto user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.currentDate = currentDate;
		this.user = user;
	}

	public TaskDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
