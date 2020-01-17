package com.profile.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.profile.demo.bean.User;

@Profile("dev")
@Service
public class DevProfileService implements ProfileService {

	@Override
	public User getUserDetails() {
		
		return new User("Dev User", "dev-password", "Developer");
	}

}
