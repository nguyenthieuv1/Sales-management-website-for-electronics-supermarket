package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CartItemsConverter;
import com.example.demo.entity.CartItemsEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.CartItemsDTO;
import com.example.demo.model.OrderDTO;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.CartItemsRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public UserEntity getUser() {
		// TODO Auto-generated method stub
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			if (userName!=null) {
				UserEntity uEntity = userRepository.findByUsername(userName);
				System.out.println(uEntity);
				return uEntity;
			}
			
		}
		return null;
	}
	
	@Transactional
	@Override
	public void addNewUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = mapper.map(userDTO,UserEntity.class);
		RoleEntity roleEntity = roleRepository.findByRole("CUSTOMER");						
		
		List<RoleEntity> roles= new ArrayList<>();
		roles.add(roleEntity);
		userEntity.setRoleEntities(roles);
		String password = bCryptPasswordEncoder.encode(userDTO.getPassword());
		userEntity.setPassword(password);
		userEntity.setEnabled(true);
		
		
		userRepository.save(userEntity);
		
	}

	@Override
	@Transactional
	public void updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub	
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			if (userName!=null) {
				UserEntity uEntity = userRepository.findByUsername(userName);
				System.out.println("userentity 1   "+uEntity);
				uEntity.setAddress(userDTO.getAddress());
				uEntity.setEmail(userDTO.getEmail());
				uEntity.setName(userDTO.getName());
				uEntity.setPhone(userDTO.getPhone());
				
				if (!uEntity.getPassword().equals(userDTO.getUsername())) {
					String newPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
					
					
					uEntity.setPassword(newPassword);
				}
				
				
				
				
				System.out.println("userentity 2   "+uEntity);
				userRepository.save(uEntity);
			}
		}
		
	}

	@Override
	public List<OrderDTO> getOrders() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();

			if (userName!=null) {
				UserEntity uEntity = userRepository.findByUsername(userName);
				
				List<OrderEntity> orderEntities = uEntity.getOrderEntities();
				
				List<OrderDTO> orderDTOs = new ArrayList<>();
				for(OrderEntity oEntity:orderEntities) {
					OrderDTO oDto = mapper.map(oEntity,OrderDTO.class);
					orderDTOs.add(oDto);
					
//					System.out.println("oderDTO     "+oDto);
				}
				
				return orderDTOs;
				
			}
		}
		
		return null;
	}

	@Override
	public List<UserEntity> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void LockUserById(int id) {
		// TODO Auto-generated method stub
		UserEntity uEntity = userRepository.findById(id).get();
		uEntity.setEnabled(false);
		userRepository.save(uEntity);
	}

	@Override
	public UserEntity getUserByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	

}
