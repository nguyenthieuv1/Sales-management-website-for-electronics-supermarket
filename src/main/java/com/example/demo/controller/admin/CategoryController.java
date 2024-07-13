package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ModelAndView getMethodName() {		
		ModelAndView mav = new ModelAndView("admin/categories");
		mav.addObject("categories",categoryService.getAllCategory());
		return mav;
	}
	@GetMapping("/{id}")
	public ModelAndView getMethodName(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("admin/detailCategory");
		mav.addObject("category",categoryService.getCategorybyId(id));
		return mav;
	}
	
	@PutMapping("/{id}")
	public void updateCategory(@PathVariable Integer id, @RequestBody CategoryEntity categoryEntity) {
		//TODO: process PUT request
		
		categoryEntity.setId(id);
		System.out.println(id);
		categoryService.updateOrAddCAtegory(categoryEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		//TODO: process PUT request
		
//		System.out.println();
		categoryService.deleteCategory(id);
		
	}
}
