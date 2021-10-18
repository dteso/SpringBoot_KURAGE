package com.springbootbase.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") 
public class User implements java.io.Serializable{
	
	private static final long serialVersionUID = -3659638582243741589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
	
	@Column(length = 50)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name = "mail", nullable=false, length=50, unique = true ) // unique --> implica que no puede repetirse el valor de la propiedad
	private String email;
	
	private Boolean enable;
	
	private String role;
	
	private Boolean google;
	
	@Transient
	private String token;
	
	public User(){
		
	}
	
}
