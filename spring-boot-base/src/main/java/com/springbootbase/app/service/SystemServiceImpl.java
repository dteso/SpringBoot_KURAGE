package com.springbootbase.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootbase.app.entity.System;
import com.springbootbase.app.entity.User;
import com.springbootbase.app.repository.SystemRepository;

@Service
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	SystemRepository systemRepository;

	@Override
	public Iterable<System> findAll() {
		return systemRepository.findAll();
	}

	@Override
	public System save(System system) {
		return systemRepository.save(system);
	}


	@Override
	public List<System> findListByUser(User user) {
		return systemRepository.findListByUser(user);
	}

	@Override
	public Page<System> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<System> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
