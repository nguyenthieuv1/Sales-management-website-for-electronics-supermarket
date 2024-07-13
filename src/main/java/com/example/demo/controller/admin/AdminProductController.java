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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/products")
public class AdminProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public ModelAndView showProducts() {
		ModelAndView mav =new ModelAndView("admin/products");
		mav.addObject("products",productService.getAllProducts());		
		return mav;
	}
	
	@GetMapping("/{id}")
	public ModelAndView showDetailProduct(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("admin/detailProduct");
		mav.addObject("product",productService.getProductById(id));
		mav.addObject("categories",categoryService.getAllCategory());
		return mav;
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<?> updateProduct(
	            @PathVariable Integer id,
	            @RequestParam("name") String name,
	            @RequestParam("price") Float price,
	            @RequestParam("amount") Integer amount,
	            @RequestParam("status") String status,
	            @RequestParam("categoryId") Integer categoryId,
	            @RequestParam("description") String description,
	            @RequestParam(value = "img", required = false) MultipartFile img) {

		 	
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
	        }

	        // Xử lý logic cập nhật sản phẩm tại đây
	        ProductDTO pDto = new ProductDTO();
	        pDto.setId(id);
	        pDto.setAmount(amount);
	        pDto.setCategoryId(categoryId);
	        pDto.setDescription(description);
	        pDto.setName(name);
	        pDto.setPrice(price);
	        pDto.setStatus(status);
	        if (img != null && !img.isEmpty()) {
	        	pDto.setImg("/img/"+img.getOriginalFilename());
			}
	        
//	        System.out.println(pDto);
	        productService.upadateProduct(pDto);
	        return ResponseEntity.ok().body("Product updated successfully");
	    }
	
	 
	 
	 
}
