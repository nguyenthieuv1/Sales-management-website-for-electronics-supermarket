package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;


@Controller
@RequestMapping("/home")
public class HomeWebController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService cService;
	
	@GetMapping("")
	public String getMethodName(@RequestParam(defaultValue = "",required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0",required = false) int categoryid,       
            Model model) {
		
		model.addAttribute("categories",cService.getAllCategory());
//		System.out.println(name);
		System.out.println("id là:     "+categoryid);
		if (categoryid==0) {
			Page<ProductEntity> productPage = productService.getProducts(name,page,12);
			model.addAttribute("productPage", productPage);
			model.addAttribute("currentPage",page);
		}
		else {
			Page<ProductEntity> productPage = productService.getProductByCategory(categoryid,page,12);
			model.addAttribute("productPage", productPage);
			model.addAttribute("currentPage",page);
		}
		
		return "/web/home.html";
	}
//	@GetMapping("/category/{category}")
//	public String getMethodName(@PathVariable Integer categoryID,Model model) {
//		
//		model.addAttribute("categories",cService.getAllCategory());
//		
//		return "/web/home.html";
//	}
//	
	
}
