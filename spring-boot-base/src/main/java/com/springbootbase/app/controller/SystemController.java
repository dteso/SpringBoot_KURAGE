package com.springbootbase.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbase.app.entity.System;
import com.springbootbase.app.entity.User;
import com.springbootbase.app.service.SystemService;
import com.springbootbase.app.service.UserService;

@RestController
@RequestMapping("/api/systems")
public class SystemController {
	
	private final static Logger LOGGER = Logger.getLogger("com.springbootbase.app.controller.Controller");
	
	@Autowired
	SystemService systemService;
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createSystem(@RequestBody System system){
		LOGGER.log(Level.INFO, "Creando sistema");
		try {
			Optional<User> user = userService.findById(system.getUser().getId());
			system.setUser(user.get());
			System savedSystem = systemService.save(system);
			savedSystem.getUser().setPassword("XXXXXXXXX");
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSystem);
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllSystems(){
		LOGGER.log(Level.INFO, "Obteniendo sistemas...");
		try {
			Iterable<System> savedSystems = systemService.findAll();
			savedSystems.forEach(sys -> sys.getUser().setPassword("XXXXXXXXXX")); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedSystems);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	@GetMapping({"/user/{user_id}"})
	public ResponseEntity<?> getSystemsByUser(@PathVariable(value="user_id") Long userId){
		LOGGER.log(Level.INFO, "Obteniendo sistemas por usuario con Id..." + userId);
		try {
			Optional<User> user = userService.findById(userId);
			List<System> systemsByUser = systemService.findListByUser(user.get());
			systemsByUser.forEach(sys -> sys.getUser().setPassword("XXXXXXXXXX")); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(systemsByUser);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
	}

}
