package com.example.demo.service.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CartItemsEntity;
import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.CartItemsRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;

import jakarta.transaction.Transactional;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository oRepository;
	@Autowired
	private OrderDetailRepository oDetailRepository;
	@Autowired
	private CartItemsRepository cItemsRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	@Transactional
	public void addOrder() throws Exception {
		// TODO Auto-generated method stub
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			
			UserEntity uEntity = userRepository.findByUsername(userName);
			
			// add new order
			OrderEntity oEntity = new OrderEntity();
			oEntity.setUserEntity(uEntity);
			LocalDateTime currentDateTime = LocalDateTime.now();			
			oEntity.setOrderDate(currentDateTime);
			oEntity.setStatus("ordered");
			
			oRepository.save(oEntity);
			
			// add new orderdetail
			List<CartItemsEntity> cEntities = cItemsRepository.findAll();
			if (cEntities.size()==0) {
				throw new Exception();
			}
			
			for(CartItemsEntity cEntity:cEntities) {
				OrderDetailEntity oDetailEntity = new OrderDetailEntity();
				oDetailEntity.setOrderEntity(oEntity);
				oDetailEntity.setPrice(cEntity.getPrice());
				oDetailEntity.setQuantity(cEntity.getQuantity());
				oDetailEntity.setProductEntity(cEntity.getProductEntity());
				
				oDetailRepository.save(oDetailEntity);
			}
			
			cItemsRepository.deleteAll();
			
		}
		
	}

	@Override
	public List<CartItemsDTO> getOrderDetail(int id) {
		// TODO Auto-generated method stub
		
		OrderEntity orderEntity = oRepository.findById(id).get();
		List<OrderDetailEntity> oDetailEntities = orderEntity.getOrderDetailEntities();
		List<CartItemsDTO> res = new ArrayList();
		for(OrderDetailEntity oEntity : oDetailEntities) {
			CartItemsDTO cDto = mapper.map(oEntity,CartItemsDTO.class);
			ProductDTO pDto = mapper.map(oEntity.getProductEntity(), ProductDTO.class);
			cDto.setProduct(pDto);
			cDto.setSubTotal(cDto.getPrice()*cDto.getQuantity());
			res.add(cDto);
		}
		
		
		return res;
	}

	@Override
	public List<OrderEntity> getOrders(String status) {
		// TODO Auto-generated method stub

		return oRepository.findByStatus(status);
	}

	@Override
	public void UpdateStatus(String status,int id) {
		// TODO Auto-generated method stub
		
		OrderEntity oEntity = oRepository.findById(id).get();
		oEntity.setStatus(status);
		oRepository.save(oEntity);

	}

}
