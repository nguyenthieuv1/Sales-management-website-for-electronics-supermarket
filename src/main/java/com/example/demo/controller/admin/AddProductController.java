package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ProductDTO;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/add-products")
public class AddProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ModelAndView showAddProduct() {
		ModelAndView mav = new ModelAndView("admin/addProduct");
		mav.addObject("categories",categoryService.getAllCategory());
		return mav;
	}
	@PostMapping("")
	 public ResponseEntity<?> addProduct( 
	            @RequestParam(value = "name", required = false) String name,
	            @RequestParam(value = "price", required = false) Float price,
	            @RequestParam(value = "amount", required = false) Integer amount,
	            @RequestParam(value = "status", required = false) String status,
	            @RequestParam(value = "categoryId", required = false) Integer categoryId,
	            @RequestParam(value = "description", required = false) String description,
	            @RequestParam(value = "img", required = false) MultipartFile img ) {
	 	//TODO: process POST request
	 	
		
		 // Lưu tệp tin nếu có 
	        if (img != null && !img.isEmpty()) {
	            try {
	            	String currentDirectory = new File(".").getAbsolutePath();
	                String uploadDirectory = Paths.get(currentDirectory, "src", "main", "resources", "static", "img").toString();
	                String fileName = img.getOriginalFilename();
	                File destinationFile = new File(uploadDirectory, fileName);
	                img.transferTo(destinationFile);
	            } catch (IOException e) {
	                e.printStackTrace();
	                return ResponseEntity.status(500).body("Error saving file");
	            }
	            
	            ProductDTO pDto = new ProductDTO();
		       
		        pDto.setAmount(amount);
		        pDto.setCategoryId(categoryId);
		        pDto.setDescription(description);
		        pDto.setName(name);
		        pDto.setPrice(price);
		        pDto.setStatus(status);
		        if (img != null && !img.isEmpty()) {
		        	pDto.setImg("/img/"+img.getOriginalFilename());
				}
//		        System.out.println(pDto);
		        productService.addProduct(pDto);
	        }
		 
		 return ResponseEntity.ok().body("Product updated successfully");
	 }
	
}
