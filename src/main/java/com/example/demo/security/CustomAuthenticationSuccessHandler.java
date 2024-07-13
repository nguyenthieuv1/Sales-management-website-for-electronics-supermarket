package com.example.demo.security;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	private UserService userService;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
//		UserEntity userEntity = userService.getUserByUsername(customUserDetail.getUsername());
		request.getSession().setAttribute("username",customUserDetail.getUsername());
		
		var authorites = authentication.getAuthorities();
		
		if (authorites.stream().anyMatch(a->a.getAuthority().equals("ADMIN"))) {
			response.sendRedirect("/products");
		}
		else if (authorites.stream().anyMatch(a->a.getAuthority().equals("CUSTOMER"))) {
			response.sendRedirect("/carts");
		}
		else {
			response.sendRedirect("/home");
		}
		
	}
	
	

}
