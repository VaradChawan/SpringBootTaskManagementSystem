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
import com.tms.payloads.UserDto;
import com.tms.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		UserDto newUserAdd= this.userService.createUser(userDto);
		
		
		return new ResponseEntity<UserDto>(newUserAdd, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto , @PathVariable Integer userId){
		
		UserDto updateUser=this.userService.updatedUser(userDto, userId);
		
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUserDetail(){
		
		List<UserDto> userDetails=this.userService.getAllUsers();
		
		return ResponseEntity.ok(userDetails);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getAllUser(@PathVariable Integer userId){
		
		UserDto singleUserDetails=this.userService.getUserById(userId);
		
		return new ResponseEntity<UserDto>(singleUserDetails, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", false), HttpStatus.OK);
	}
	
}

