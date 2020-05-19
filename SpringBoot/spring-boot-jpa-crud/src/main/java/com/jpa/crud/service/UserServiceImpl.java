package com.jpa.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.crud.entity.User;
import com.jpa.crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public User save(User user) {
		
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public void deleteUserById(int id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public User update(User user) {
		
		userRepository.save(user);
		return user;
	}

}
