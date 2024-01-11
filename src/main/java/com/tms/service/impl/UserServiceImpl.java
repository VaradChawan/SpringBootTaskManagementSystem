package com.tms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entity.User;
import com.tms.exception.ResourceNotFoundException;
import com.tms.payloads.UserDto;
import com.tms.repository.UserRepository;
import com.tms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User newUser= this.modelMapper.map(userDto, User.class);
		
		//List<User> lengthCheck=this.userRepository.findAll();
		
		
		User savedUser= this.userRepository.save(newUser);
		
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updatedUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User users=this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "user Id", userId)
				);
		
		users.setUsername(userDto.getUsername());
		users.setCity(userDto.getCity());
		
		User updatedUser= this.userRepository.save(users);
		
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "user id", userId)
				);
		
		this.userRepository.delete(user);
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> user=this.userRepository.findAll();
		
		List<UserDto> allUserList=user.stream().map(
				(u)-> this.modelMapper.map(u,UserDto.class)).collect(Collectors.toList());
				
		System.out.println(allUserList.size());
		
		return allUserList;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException("User", "user Id", userId)
				);
		
		
		
		return this.modelMapper.map(user, UserDto.class);
	}

	
	
}
