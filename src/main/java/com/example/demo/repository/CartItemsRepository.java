package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CartItemsEntity;
import com.example.demo.entity.UserEntity;

import java.util.List;


public interface CartItemsRepository extends JpaRepository<CartItemsEntity,Integer>{
	List<CartItemsEntity> findByUserEntity(UserEntity userEntity);
}
