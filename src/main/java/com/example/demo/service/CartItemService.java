package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CartItemsDTO;

public interface CartItemService {
	public void deleteItem(int id);

	public List<CartItemsDTO> getCartItems();
	public void addCartItems(int idProduct,int quantity);
}
