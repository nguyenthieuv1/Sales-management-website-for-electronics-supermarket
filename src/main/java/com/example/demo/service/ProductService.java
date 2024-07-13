package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.ProductDTO;

public interface ProductService {
	public Page<ProductEntity> getProducts(String name, int page, int pageSize);
	public ProductEntity getProductById(Integer id);
	public Page<ProductEntity> getProductByCategory(int id,int page, int pageSize);
	public List<ProductEntity> getAllProducts();
	public void upadateProduct( ProductDTO productDTO);
	public void addProduct(ProductDTO productDTO);
}
