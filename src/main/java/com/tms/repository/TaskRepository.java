package com.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.entity.Task;
import com.tms.entity.User;


public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	List<Task> findByUser(User user);
	
}
