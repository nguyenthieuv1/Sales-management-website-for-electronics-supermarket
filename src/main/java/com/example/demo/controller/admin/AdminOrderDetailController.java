package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.CartItemsDTO;
import com.example.demo.model.ResponseStatus;
import com.example.demo.service.OrderService;
import com.example.demo.utils.Calculation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders-detail")
public class AdminOrderDetailController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public ModelAndView showOrderDetail(@PathVariable Integer id) {
		
		ModelAndView mav = new ModelAndView("/admin/order_detail.html");
		List<CartItemsDTO> cartItemsDTOs = orderService.getOrderDetail(id);
		mav.addObject("orders",cartItemsDTOs);
		mav.addObject("total",Calculation.getSum(cartItemsDTOs));
		mav.addObject("idOrder",id);
		
		return mav;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> UpdateStatus(@PathVariable Integer id, @RequestBody ResponseStatus responseStatus) {
		//TODO: process PUT request
		
//		System.out.println(responseStatus+" ;"+id);
		
		orderService.UpdateStatus(responseStatus.getStatus(),id);
		
		return ResponseEntity.ok("success");
	}
	
}
