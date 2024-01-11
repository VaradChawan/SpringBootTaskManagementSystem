package com.tms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class TaskManagementAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementAppApisApplication.class, args);
	}

	//model mapper is use to convert from one class to another class
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
}
