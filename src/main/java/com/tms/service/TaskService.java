package com.tms.service;

import java.util.List;

import com.tms.payloads.TaskDto;

public interface TaskService {

	//create new tasks
	TaskDto createTasks(TaskDto taskDto,Integer userId);
	
	//update tasks
	TaskDto updateTasks(TaskDto taskDto, Integer taskId);
	
	//delete tasks
	void deleteTask(Integer taskId);
	
	//Get all tasks
	List<TaskDto> getAllTask();
	
	//get task by Id
	TaskDto getTaskById(Integer taskId);
	
	//get tasks by userId
	List<TaskDto> getTaskByUser(Integer userId);
}
