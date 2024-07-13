package com.example.demo.entity;

import java.util.List;

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
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "img")
	private String img;
	
	@ManyToOne()
	@JoinColumn(name = "categoryid")
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "productEntity")
	private List<CartItemsEntity> cartItemsEntities;
	
	@OneToMany(mappedBy = "productEntity")
	private List<OrderDetailEntity> orderDetailEntities;
	
	
	
	
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", status=" + status + ", amount=" + amount + ", price="
				+ price + ", description=" + description + ", img=" + img + ", category=" + category
				+ ", cartItemsEntities=" + cartItemsEntities + ", orderDetailEntities=" + orderDetailEntities + "]";
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<CartItemsEntity> getCartItemsEntities() {
		return cartItemsEntities;
	}

	public void setCartItemsEntities(List<CartItemsEntity> cartItemsEntities) {
		this.cartItemsEntities = cartItemsEntities;
	}

	public List<OrderDetailEntity> getOrderDetailEntities() {
		return orderDetailEntities;
	}

	public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
		this.orderDetailEntities = orderDetailEntities;
	}
	
	
	
	
}
