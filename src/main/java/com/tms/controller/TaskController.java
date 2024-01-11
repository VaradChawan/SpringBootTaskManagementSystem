package com.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tms.payloads.ApiResponse;
import com.tms.payloads.TaskDto;
import com.tms.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	
	
	@PostMapping("/tasks/{userId}")
	public ResponseEntity<TaskDto> createNewTask(@RequestBody TaskDto taskDto, @PathVariable Integer userId){
		
		TaskDto createTask = this.taskService.createTasks(taskDto,userId);
		
		
		return new ResponseEntity<TaskDto>(createTask,HttpStatus.CREATED); 
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<TaskDto> updateTaskDetail(@RequestBody TaskDto taskDto, @PathVariable Integer taskId ){
		
		TaskDto updateTask= this.taskService.updateTasks(taskDto, taskId);
		
		
		return new ResponseEntity<TaskDto>(updateTask,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<TaskDto>> getAllTasks()
	{
		
		List<TaskDto> taskDto= this.taskService.getAllTask();
		
		return ResponseEntity.ok(taskDto);
	}
	
	
	@GetMapping("/{taskId}")
	public ResponseEntity<TaskDto> getSingleTask(
			@PathVariable Integer taskId
			)
	{
		
		TaskDto taskDto=this.taskService.getTaskById(taskId);
		
		return new ResponseEntity<TaskDto>(taskDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<ApiResponse> deleteTask(@PathVariable Integer taskId){
		
		this.taskService.deleteTask(taskId);		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Task is deleted successfully", false), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/tasks")
	public ResponseEntity<List<TaskDto>> getTaskByUser(@PathVariable Integer userId){
		
		List<TaskDto> taskDto=this.taskService.getTaskByUser(userId);
		
		return new ResponseEntity<List<TaskDto>>(taskDto,HttpStatus.OK);
	}
	
	

}
