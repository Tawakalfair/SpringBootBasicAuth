package com.mit.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.basic.model.UserModel;
import com.mit.basic.repository.UserRepository;

@Service
@Transactional
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel registerUser(UserModel user) {
		
		return userRepository.save(user);
	}

}
