package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{
	public List<OrderEntity> findByStatus(String status);
	
	
}
