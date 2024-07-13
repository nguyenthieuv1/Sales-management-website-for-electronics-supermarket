package com.example.demo.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CartItemsEntity;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.model.ProductDTO;

@Component
public class CartItemsConverter {

	@Autowired
	private ModelMapper mapper;
	
	public CartItemsDTO toCartItemsDTO(CartItemsEntity cEntity) {
		
		CartItemsDTO cDto = mapper.map(cEntity,CartItemsDTO.class);
		cDto.setSubTotal(cDto.getPrice()*cDto.getQuantity());
		cDto.setProduct(mapper.map(cEntity.getProductEntity(),ProductDTO.class));
		return cDto;
	}
}
