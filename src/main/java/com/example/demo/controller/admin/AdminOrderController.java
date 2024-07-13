package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.CartItemsDTO;
import com.example.demo.service.OrderService;
import com.example.demo.utils.Calculation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/new-orders")
public class AdminOrderController {

	
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("")
	public ModelAndView showOrders(@RequestParam(required = false) String status) {
		ModelAndView mav = new ModelAndView("/admin/neworder.html");
		
		mav.addObject("orders",orderService.getOrders(status));

		return mav;
	}
	
	
	
}
