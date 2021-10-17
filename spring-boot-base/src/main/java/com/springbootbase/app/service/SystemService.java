package com.springbootbase.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootbase.app.entity.System;
import com.springbootbase.app.entity.User;

public interface SystemService  {
	
	public Iterable<System> findAll();
	
	public Page<System> findAll(Pageable pageable);
	
	public Optional<System> findById(Long id);
	
	public System save(System system);
	
	public void deleteById(Long id);
	
	public List<System> findListByUser(User user);
	
}
