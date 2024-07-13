package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CartItemsEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.model.OrderDTO;
import com.example.demo.model.UserDTO;

public interface UserService {
	public UserEntity getUser();
	public void  addNewUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public List<OrderDTO> getOrders();
	public List<UserEntity> getAllUser();
	public UserEntity getUserById(int id);
	public void LockUserById(int id);
	public UserEntity getUserByUsername(String username);
}
