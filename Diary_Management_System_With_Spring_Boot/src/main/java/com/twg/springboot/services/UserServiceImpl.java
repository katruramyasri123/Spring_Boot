package com.twg.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.springboot.entities.User;
import com.twg.springboot.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public void  save(User user) {
		 userRepo.save(user);
		
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
	}

	@Override
	public void update(User user) {
		 userRepo.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User findByUsername(String username) {
		User user=userRepo.findByUsername(username);
		if(user==null) {
			return null;
		}
		else {
			return user;
		}
		
	}

}
