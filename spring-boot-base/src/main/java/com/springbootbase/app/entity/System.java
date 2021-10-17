package com.springbootbase.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "systems")
public class System {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false, length = 10)
	private String name;
	
	@Column(length = 10)
	private String location;
	
	@Column(length = 50)
	private String description;
	
	@Column(nullable = false)
	private Boolean active;

	@ManyToOne
	private User user;
}
