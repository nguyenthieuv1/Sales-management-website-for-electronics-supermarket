package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/add-category")
public class AddCategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ModelAndView getMethodName() {
		ModelAndView mav = new ModelAndView("admin/addCategory");
		
		return mav;
	}
	@PostMapping("")
	public ResponseEntity<String> postMethodName(@RequestBody CategoryEntity categoryEntity) {
		//TODO: process POST request
		
		System.out.println(categoryEntity);
		categoryService.updateOrAddCAtegory(categoryEntity);
		
		return ResponseEntity.ok("success");
	}
	
	
}
