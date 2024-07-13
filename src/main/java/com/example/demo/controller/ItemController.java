package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ProductService;


@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("")
	public String getMethodName(@RequestParam(defaultValue = "0",required = false) Integer id,Model model) {
		
		model.addAttribute("product",pService.getProductById(id));
		model.addAttribute("related_products",pService.getProducts("",1,4));
//		System.out.println(pService.getProducts("",1,4).getContent());
		
		
		return "web/items";
	}
	
}
