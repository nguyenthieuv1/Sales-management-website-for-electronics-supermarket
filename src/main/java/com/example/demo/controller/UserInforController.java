package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/user")
public class UserInforController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ModelAndView getMethodName(Model model,HttpSession session ) {
										
		UserEntity uSession = (UserEntity) session.getAttribute("user");		
		ModelAndView mav = new ModelAndView("/web/user.html");
		
		mav.addObject("orders",userService.getOrders());
		mav.addObject("user",uSession);
		
		return mav;
	}
	
	@PutMapping("")
	public ResponseEntity<String> uppdatUser(@RequestBody UserDTO userDTO,
			HttpSession session
			) {
		//TODO: process POST request
		
		UserEntity uSession = (UserEntity) session.getAttribute("user");
		userDTO.setId(uSession.getId());		
//		System.out.println("cap nhat: "+userEntity);
		
		
		userService.updateUser(userDTO);
		
		return ResponseEntity.ok("success");
	}
	
	
	
}
