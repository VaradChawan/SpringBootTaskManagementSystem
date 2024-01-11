package com.tms.service;

import java.util.List;


import com.tms.payloads.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto userDto);
	
	UserDto updatedUser(UserDto userDto, Integer userId);
	
	void deleteUser(Integer userId);
	
	List<UserDto> getAllUsers();
	
	UserDto getUserById(Integer id);
	
}
