package com.example.simpleblog.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {
	
	private int ID;
	private String Name;
	private String Password;

	private SimpleGrantedAuthority authorities;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(authorities);
	}

	public CustomUserDetails(UserEntity user) {
		this.Name = user.getName();
		this.Password = user.getPassword();
		
		this.setAuthorities(new SimpleGrantedAuthority("ADMIN"));
		//this.setAuthorities(new SimpleGrantedAuthority(user.getRole()));
	}
	@Override
	public String getPassword() {
		return Password;
	}

	@Override
	public String getUsername() {
		return Name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setAuthorities(SimpleGrantedAuthority authorities) {
		this.authorities = authorities;
	}

}
