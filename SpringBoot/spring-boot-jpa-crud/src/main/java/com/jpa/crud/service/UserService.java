package com.jpa.crud.service;

import java.util.List;
import java.util.Optional;

import com.jpa.crud.entity.User;

public interface UserService {

	public User save(User user);
	
	public List<User> findAll();
	
	public Optional<User> findUserById(int id);
	
	public User update(User user);
	
	public void deleteUserById(int id);
}
