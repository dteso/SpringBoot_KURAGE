package com.springbootbase.app.controller;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbase.app.entity.User;
import com.springbootbase.app.service.UserService;
import com.springbootbase.app.utils.JwtUtils;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	private final static Logger LOGGER = Logger.getLogger("com.springbootbase.app.controller.Controller");

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> verifyUser(@RequestBody User user) { 
		try {
			int strength = 10; // work factor of bcrypt
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
			
			User dbUser = userService.findByEmail(user.getEmail()).get();
			String dbPassword = dbUser.getPassword();
			
			if(!bCryptPasswordEncoder.matches(user.getPassword(), dbPassword)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INCORRECT PASSWORD");
			}
						
			String token = JwtUtils.getJWTToken(user.getName());
			dbUser.setToken(token);
			
			return ResponseEntity.status(HttpStatus.OK).body(dbUser);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getCause().getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().getLocalizedMessage());
		}
	}

}
