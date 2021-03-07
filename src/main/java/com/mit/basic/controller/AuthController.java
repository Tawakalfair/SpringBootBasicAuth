package com.mit.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mit.basic.model.UserModel;
import com.mit.basic.service.AuthService;

@RestController
@Controller
@RequestMapping(value = "/api/user")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserModel user){
		try {
			return ResponseEntity.ok(authService.registerUser(user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Register Failed");
		}
	}
	
}
