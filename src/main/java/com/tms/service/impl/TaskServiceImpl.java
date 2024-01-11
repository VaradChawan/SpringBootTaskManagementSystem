package com.tms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entity.Task;
import com.tms.entity.User;
import com.tms.exception.ResourceNotFoundException;
import com.tms.payloads.TaskDto;
import com.tms.repository.TaskRepository;
import com.tms.repository.UserRepository;
import com.tms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TaskDto createTasks(TaskDto taskDto, Integer userId) {
	
		User user=this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "user Id", userId)
				);
		
		
		Task newTask=this.modelMapper.map(taskDto, Task.class);
		
		newTask.setCurrentDate(new Date());
		newTask.setUser(user);
		
		
		Task savedTask=this.taskRepository.save(newTask);
				
		return this.modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public TaskDto updateTasks(TaskDto taskDto, Integer taskId) {
		// TODO Auto-generated method stub
		
		Task tasks=this.taskRepository.findById(taskId).orElseThrow(
				()-> new ResourceNotFoundException("Task", " task id ", taskId)
				);
		
		tasks.setTitle(taskDto.getTitle());
		tasks.setDescription(taskDto.getDescription());
		
		Task updatedTask=this.taskRepository.save(tasks);
		
		
		return this.modelMapper.map(updatedTask, TaskDto.class);
	}

	@Override
	public void deleteTask(Integer taskId) {
		// TODO Auto-generated method stub
		
		Task task=this.taskRepository.findById(taskId).orElseThrow(
				()-> new ResourceNotFoundException("Task ", "task Id", taskId)
				);
		
		this.taskRepository.delete(task);
	}

	@Override
	public List<TaskDto> getAllTask() {
		// TODO Auto-generated method stub
		List<Task> allTasks=this.taskRepository.findAll();
		
		List<TaskDto> allTaskDto=allTasks.stream().map
				((t)-> this.modelMapper.map(t, TaskDto.class))
				.collect(Collectors.toList());
				
				
		
		return allTaskDto;
	}

	@Override
	public TaskDto getTaskById(Integer taskId) {
		// TODO Auto-generated method stub
		
		Task task=this.taskRepository.findById(taskId).orElseThrow(
				()-> new ResourceNotFoundException("Task ", "task Id", taskId) 
				);
				
		return this.modelMapper.map(task, TaskDto.class);
	}

	@Override
	public List<TaskDto> getTaskByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user= this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "user id", userId)
				);
		
		List<Task> tasks=this.taskRepository.findByUser(user);
		
		List<TaskDto> taskDto=tasks.stream().map(
				(t)-> this.modelMapper.map(t, TaskDto.class)
				).collect(Collectors.toList());
				
		
		return taskDto;
		
	}

}
