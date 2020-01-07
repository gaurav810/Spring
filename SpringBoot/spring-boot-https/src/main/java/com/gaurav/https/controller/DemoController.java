package com.gaurav.https.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/")
	public String httpsDemoController() {
		
		String response = "Hello, this is secured connection. " + new Date();
		return response;
	}
}
