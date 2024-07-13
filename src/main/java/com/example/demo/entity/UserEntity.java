package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	
	@OneToMany(mappedBy = "userEntity")
	private List<CartItemsEntity> cartItemsEntities;  
	
	@OneToMany(mappedBy = "userEntity")
	private List<OrderEntity> orderEntities;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private List<RoleEntity> roleEntities =new ArrayList();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<CartItemsEntity> getCartItemsEntities() {
		return cartItemsEntities;
	}

	public void setCartItemsEntities(List<CartItemsEntity> cartItemsEntities) {
		this.cartItemsEntities = cartItemsEntities;
	}

	

	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

	public List<RoleEntity> getRoleEntities() {
		return roleEntities;
	}

	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", cartItemsEntities=" + cartItemsEntities + ", orderEntities=" + orderEntities + ", roleEntities="
				+ roleEntities + "]";
	}
	
	
}
