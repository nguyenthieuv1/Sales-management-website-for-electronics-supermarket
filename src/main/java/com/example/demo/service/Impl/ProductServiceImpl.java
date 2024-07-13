package com.example.demo.service.Impl;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import jakarta.transaction.Transactional;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository cRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Page<ProductEntity>  getProducts(String name,int page, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page,pageSize,Sort.by("name").ascending());
						
		return productRepository.findByNameContaining(name,pageable);
	}

	@Override
	public ProductEntity getProductById(Integer id) {
		// TODO Auto-generated method stub
		
		ProductEntity pEntity = productRepository.findById(id).get();		
		
		return pEntity;
	}

	@Override
	public Page<ProductEntity> getProductByCategory(int idCategory, int page, int pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pageable = PageRequest.of(page,pageSize);
		
		CategoryEntity cEntity = cRepository.findById(idCategory).get();
		
		return productRepository.findByCategory(cEntity,pageable);
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		
		
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void upadateProduct(ProductDTO productDTO) {
//		System.out.println(productDTO);
		// TODO Auto-generated method stub
		ProductEntity productEntity =productRepository.findById(productDTO.getId()).get();
		productEntity.setAmount(productDTO.getAmount());
		productEntity.setDescription(productDTO.getDescription());
		productEntity.setName(productDTO.getName());
		productEntity.setStatus(productDTO.getStatus());
		productEntity.setPrice(productDTO.getPrice());
		if (productDTO.getImg()!=null) {
			productEntity.setImg(productDTO.getImg());
		}
		
		CategoryEntity cEntity = cRepository.findById(productDTO.getCategoryId()).get();
		productEntity.setCategory(cEntity);
		
//		System.out.println(productEntity);
		productRepository.save(productEntity);
	}

	@Override
	public void addProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		ProductEntity pEntity = mapper.map(productDTO,ProductEntity.class);
		CategoryEntity cEntity = cRepository.findById(productDTO.getCategoryId()).get();
		pEntity.setCategory(cEntity);
		productRepository.save(pEntity);
		
	}
	
	
}
