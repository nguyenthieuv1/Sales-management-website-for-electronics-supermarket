package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ModelAndView ShowRegisterpPage(
			) {
		
		ModelAndView mav = new ModelAndView("/web/register");
		
		
		return mav;
	}
	
	@PostMapping("")
	public ResponseEntity<String> postMethodName(@RequestBody UserDTO userDTO,
			HttpServletResponse response
			) throws IOException {
		//TODO: process POST request
//		System.out.println(userDTO);
		if (userService.getUserByUsername(userDTO.getUsername())==null) {
			userService.addNewUser(userDTO);
		}
		else {
			return ResponseEntity.badRequest().body("tài khoản đã tồn tại");
		}
		
		
		return ResponseEntity.ok("success");
	}
	
}
