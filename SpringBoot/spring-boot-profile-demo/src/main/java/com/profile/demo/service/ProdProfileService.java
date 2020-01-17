package com.profile.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.profile.demo.bean.User;

@Profile("prod")
@Service
public class ProdProfileService implements ProfileService {

	@Override
	public User getUserDetails() {
		
		return new User("Admin", "admin-password", "System Admin");
	}

}
