package com.twg.springboot.services;

import java.util.List;

import com.twg.springboot.entities.User;

public interface UserService {
	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User findById(Long id);
	public List<User> findAll();
	public User findByUsername(String username);

}
