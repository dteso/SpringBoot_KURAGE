package com.springbootbase.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbase.app.entity.System;
import com.springbootbase.app.entity.User;

@Repository
public interface SystemRepository extends JpaRepository<System, Long> {
	public List<System> findListByUser(User user);
}
