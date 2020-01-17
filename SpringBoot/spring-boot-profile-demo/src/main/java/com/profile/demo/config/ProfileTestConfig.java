package com.profile.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.profile.demo.bean.User;

@Configuration
public class ProfileTestConfig {

	@Value("${user.fullname}")
	private String name;
	
	@Value("${user.passwprd}")
	private String password;
	
	@Value("${user.profile}")
	private String profile;
	
	@Profile("dev")
	@Bean
	public User devUser() {
		
		return new User(name, password, profile);	
	}
	
	@Profile("test")
	@Bean
	public User testUser() {
		
		return new User(name, password, profile);	
	}
	
	@Profile("prod")
	@Bean
	public User prodUser() {
		
		return new User(name, password, profile);	
	}
}
