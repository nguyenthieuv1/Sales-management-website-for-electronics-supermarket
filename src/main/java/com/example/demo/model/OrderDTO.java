package com.example.demo.model;

import java.time.LocalDateTime;

public class OrderDTO {

	private int id;
	private LocalDateTime orderDate ;
	private String status;
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
	
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
	
	
}
