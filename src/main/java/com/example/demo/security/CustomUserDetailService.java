package com.example.demo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.CustomUserDetail;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository uRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity uEntity = uRepository.findByUsername(username);
		
		if (uEntity==null) {
			throw new UsernameNotFoundException("sai tài khoản hoặc mật khẩu");
		}
		
		List<RoleEntity> rEntities =uEntity.getRoleEntities();
		
		Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(RoleEntity rEntity:rEntities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rEntity.getRole()));
		}
		
		return new CustomUserDetail(uEntity,grantedAuthorities);
	}

}
