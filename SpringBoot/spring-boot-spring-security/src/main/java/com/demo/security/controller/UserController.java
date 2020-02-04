package com.demo.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.bean.User;

@RestController
public class UserController {

	List<User> list = new ArrayList();
	
	@PostConstruct
	public List<User> initData() {
		
		list.add(new User(1, "A1", "a1@gmail.com"));
		list.add(new User(2, "A2", "a2@gmail.com"));
		list.add(new User(3, "A3", "a3@gmail.com"));
		list.add(new User(4, "A4", "a4@gmail.com"));
		list.add(new User(5, "A5", "a5@gmail.com"));
		list.add(new User(6, "A6", "a6@gmail.com"));
		
		return list;
	}
	
	@GetMapping("/user")
	public List<User> listOfUser() {
		
		return list;
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		
		list.remove(id-1);
		
		return "deleted";
	}
}
