package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "orderdate")
	private LocalDateTime orderDate;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne()
	@JoinColumn(name = "userid")
	private UserEntity userEntity;
	
	@OneToMany(mappedBy = "orderEntity")
	private List<OrderDetailEntity> orderDetailEntities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<OrderDetailEntity> getOrderDetailEntities() {
		return orderDetailEntities;
	}

	public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
		this.orderDetailEntities = orderDetailEntities;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderDate=" + orderDate + ", status=" + status + "]";
	}




	
	
	
}
