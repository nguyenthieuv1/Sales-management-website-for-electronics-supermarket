package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.model.CartItemsDTO;

public interface OrderService {
	public void addOrder() throws Exception;
	public List<CartItemsDTO> getOrderDetail(int id);
	public List<OrderEntity> getOrders(String status);
	public void UpdateStatus(String status,int id);
}
