package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/detail-accounts")
public class AdminDetailAccountController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ModelAndView getMethodName(@PathVariable Integer id) {
		
		ModelAndView mav = new ModelAndView("/admin/detailAccount");
		mav.addObject("user",userService.getUserById(id));
		return mav;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> putMethodName(@PathVariable Integer id, @RequestBody UserEntity userEntity) {
		//TODO: process PUT request

		userService.LockUserById(id);
		
		return ResponseEntity.ok("success");
	}
	
}
