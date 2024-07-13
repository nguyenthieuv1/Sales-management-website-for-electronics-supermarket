package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;

public interface CategoryService {

	public List<CategoryEntity> getAllCategory();
	public CategoryEntity getCategorybyId(int id);
	public void updateOrAddCAtegory(CategoryEntity categoryEntity);
	public void deleteCategory(int id);
}
