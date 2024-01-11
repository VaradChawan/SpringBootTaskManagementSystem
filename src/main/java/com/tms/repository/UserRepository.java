package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
