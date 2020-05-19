package com.jpa.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String helloController() {
		
		return "Welcome to Spring Boot JPA.";
	}
}
