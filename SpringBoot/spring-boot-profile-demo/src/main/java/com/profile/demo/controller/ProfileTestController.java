package com.profile.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.demo.bean.User;
import com.profile.demo.service.ProfileService;

@RestController
public class ProfileTestController {

	@Value("${appName}")
	private String appName;
	
	@Autowired
	private User user;
	
	@Autowired
	private ProfileService profileService; 
	
	@GetMapping
	public String welcomeController() {
	
		return "Welcome to : " + appName;
	}
	
	@GetMapping("/user")
	public User userDetailsController() {
	
		return user;
	}
	
	@GetMapping("/user-service")
	public User userDetailsfromService() {
	
		return profileService.getUserDetails();
	}
}
