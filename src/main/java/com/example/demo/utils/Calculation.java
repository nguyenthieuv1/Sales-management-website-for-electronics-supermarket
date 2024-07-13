package com.example.demo.utils;

import java.util.List;

import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.model.CartItemsDTO;

public class Calculation {

	public static float getSum(List<CartItemsDTO> cDtos) {
		float sum=0;
		for(CartItemsDTO cDto:cDtos) {
			sum+=cDto.getSubTotal();
		}
		return sum;
	}

}
