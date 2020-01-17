package com.profile.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.profile.demo.bean.User;

@Profile("test")
@Service
public class TestProfileService implements ProfileService {

	@Override
	public User getUserDetails() {
		
		return new User("Test User", "test-password", "Tester");
	}

}
