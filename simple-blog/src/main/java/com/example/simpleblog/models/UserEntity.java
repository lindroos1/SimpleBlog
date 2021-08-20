package com.example.simpleblog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_users")
public class UserEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String Name;
	private String Password;
	private String Roles;
	
	public String getRole() {
		return Roles;
	}
	public void setRole(String role) {
		Roles = role;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
