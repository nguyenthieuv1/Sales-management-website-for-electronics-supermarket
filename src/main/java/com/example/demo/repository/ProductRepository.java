package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{
	Page<ProductEntity> findByNameContaining(String name, Pageable pageable);
	Page<ProductEntity> findByCategory(CategoryEntity category, Pageable pageable);
}
