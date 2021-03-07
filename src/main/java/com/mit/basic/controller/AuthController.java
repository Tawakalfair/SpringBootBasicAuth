package com.mit.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	
	@Autowired
	private AuthenticationManager authenticateManager;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserModel user){
		try {
			return ResponseEntity.ok(authService.registerUser(user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Register Failed");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserModel user){
		try {
			authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			return ResponseEntity.ok().body("Welcome "+user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Username or Password ");
		}
	}
	
	
}
