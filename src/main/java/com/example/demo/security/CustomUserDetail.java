package com.example.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.UserEntity;

public class CustomUserDetail implements UserDetails{

	
	private UserEntity uEntity;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	
	public CustomUserDetail() {
		super();
	}

	public CustomUserDetail(UserEntity uEntity, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.uEntity = uEntity;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return uEntity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return uEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserEntity getuEntity() {
		return uEntity;
	}

	public void setuEntity(UserEntity uEntity) {
		this.uEntity = uEntity;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
