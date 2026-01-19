package com.twg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.twg.springboot.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value="select * from user where username=:username", nativeQuery = true)
	public User findByUsername(String username);

}
