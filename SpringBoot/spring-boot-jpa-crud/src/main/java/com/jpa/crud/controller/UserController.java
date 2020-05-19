package com.jpa.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.crud.entity.User;
import com.jpa.crud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> list = userService.findAll();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
	
		userService.save(user);
		return new ResponseEntity<String>("User created successfully.", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetailsById(@PathVariable("id") int id) {
		
		Optional<User> user = userService.findUserById(id);
        return new ResponseEntity<User>(user.get(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/user/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		
		userService.deleteUserById(id);
		return new ResponseEntity<String>("User deleted succeessfully.", new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	
		Optional<User> oldUser = userService.findUserById(id);
		if(oldUser.isPresent()) {
			
			 return oldUser.map(u -> {
				u.setFirstName(user.getFirstName());
				u.setLastName(user.getLastName());
				u.setAge(user.getAge());
				u.setDateOfBirth(user.getDateOfBirth());
				u.setEmailId(user.getEmailId());
				
				User updatedUser = userService.update(u);
				return new ResponseEntity<User>(updatedUser, new HttpHeaders(), HttpStatus.OK);
			}).get();
		} else {
			return new ResponseEntity<String>("This user is not found.", new HttpHeaders(), HttpStatus.OK);
		}
		
	}
}
