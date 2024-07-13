package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AmountResponse;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.utils.Calculation;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/carts")
public class CartController {

	
	
	@Autowired
	private CartItemService cItemService ;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ModelAndView getMethodName(HttpSession session) {
		
		session.setAttribute("user",userService.getUser());
		System.out.println(userService.getUser());
		
		ModelAndView mav = new ModelAndView("web/cart.html");		
		List<CartItemsDTO> cDtos = cItemService.getCartItems();		
		mav.addObject("cartItems",cDtos);
		mav.addObject("total",Calculation.getSum(cDtos));

		return mav;
	}
	
	@DeleteMapping("")
	public ResponseEntity<String> deleteCartItem(HttpServletResponse response
			,@RequestParam(defaultValue = "0", required = false) int id) throws IOException {
		cItemService.deleteItem(id);
		
		return ResponseEntity.ok("success");
//		response.sendRedirect("/cart");
	}
	@GetMapping("/{id}")
	public void addCartItems(@PathVariable Integer id,
			@RequestParam Integer quantity,
			HttpServletResponse response
			) throws IOException {
		
		
		
		System.out.println("id va quantity:   aaaaaaaa "+id+" " +quantity);
		cItemService.addCartItems(id,quantity);
		response.sendRedirect("/carts");

	}
	
	
	
	
	
}
