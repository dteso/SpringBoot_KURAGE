package com.springbootbase.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public User(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}	
	
	public String getPassword() {
		return password;
	}

	public void setPasword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getGoogle() {
		return google;
	}

	public void setGoogle(Boolean google) {
		this.google = google;
	}
	
}
