package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.CartItemsDTO;
import com.example.demo.service.OrderService;
import com.example.demo.utils.Calculation;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("")
	public ResponseEntity<String> makeOrder() throws Exception {
		//TODO: process POST request
		orderService.addOrder();
		
		return ResponseEntity.ok("success");
	}
	
	
	@GetMapping("/{id}")
	public ModelAndView showOrderDetail(@PathVariable Integer id) {
		
		ModelAndView mav = new ModelAndView("/web/orderdetail.html");
		List<CartItemsDTO> cartItemsDTOs = orderService.getOrderDetail(id);
		mav.addObject("orders",cartItemsDTOs);
		mav.addObject("total",Calculation.getSum(cartItemsDTOs));
		
		return mav;
	}
	
}
