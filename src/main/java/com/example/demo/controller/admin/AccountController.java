package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ModelAndView ShowAccounts() {
		
		ModelAndView mav = new ModelAndView("/admin/accounts");
		mav.addObject("users",userService.getAllUser());
		return mav;
	}
	
}
