package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CartItemsConverter;
import com.example.demo.entity.CartItemsEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.repository.CartItemsRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartItemsConverter cartItemConverter;

	@Autowired
	private CartItemsRepository cartItemsRepository;

	@Autowired
	private ProductRepository pRepository;

	@Override
	public List<CartItemsDTO> getCartItems() {
		// TODO Auto-generated method stub

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			UserEntity uEntity = userRepository.findByUsername(userName);
			List<CartItemsEntity> cEntities = cartItemsRepository.findByUserEntity(uEntity);

			List<CartItemsDTO> cDtos = new ArrayList<>();
			for (CartItemsEntity cEntity : cEntities) {

				cDtos.add(cartItemConverter.toCartItemsDTO(cEntity));
			}

			return cDtos;

		}
		return null;
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub

		cartItemsRepository.deleteById(id);

	}

	@Override
	public void addCartItems(int idProduct, int quantity) {
		// TODO Auto-generated method stub

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			UserEntity uEntity = userRepository.findByUsername(userName);

			ProductEntity pEntity = pRepository.findById(idProduct).get();
			CartItemsEntity cEntity = new CartItemsEntity();
			cEntity.setPrice(pEntity.getPrice());
			cEntity.setQuantity(quantity);
			cEntity.setProductEntity(pEntity);
			cEntity.setUserEntity(uEntity);
			
			cartItemsRepository.save(cEntity);

		}
	}

}
