package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository cRepository;
	
	public List<CategoryEntity> getAllCategory() {

		return cRepository.findAll();
	}

	@Override
	public CategoryEntity getCategorybyId(int id) {
		// TODO Auto-generated method stub
		return cRepository.findById(id).get();
	}

	@Override
	public void updateOrAddCAtegory(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		cRepository.save(categoryEntity);
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		cRepository.deleteById(id);
	}
	
}
