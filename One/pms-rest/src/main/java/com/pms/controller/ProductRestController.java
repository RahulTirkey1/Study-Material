package com.pms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;
import com.pms.repository.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository   repository;
	
	@GetMapping("/products")
	public   ResponseEntity<List<ProductDTO>>   getProducts() {
		List<Product>   productsList = repository.findAll();
		
		List<ProductDTO>  productsDtoList = new  ArrayList<>();
		
		productsList.forEach( product -> {
			ProductDTO   pDTO =new  ProductDTO();
			BeanUtils.copyProperties(product, pDTO);
			productsDtoList.add(pDTO);
		});
		
		return  new  ResponseEntity<List<ProductDTO>>(productsDtoList, HttpStatus.OK);
	}
	
	@GetMapping("/products/{productid}")
	public   ResponseEntity<ProductDTO>   getProductById(@PathVariable("productid") Integer  productId) {
		Optional<Product>  opt = repository.findById(productId);
		
		ProductDTO  pDTO=new  ProductDTO();
		if(opt.isPresent()) {
			Product  product = opt.get();
		   	BeanUtils.copyProperties(product, pDTO);
		}
		
		return   new  ResponseEntity<ProductDTO>(pDTO, HttpStatus.OK);
	}
	
	@PostMapping("/product/create")
	public   String   createProduct(@RequestBody   ProductDTO   pDTO) {
		
		Product   product =new  Product();
		BeanUtils.copyProperties(pDTO, product);
		boolean  flag=repository.existsById(product.getProductId());
		if(flag == true) {
			return  "Sorry, The product  already exist";
		}
		else {
			repository.save(product);
			return  "The product is  added. ";
		}
		
	}
	
	@PutMapping("/product/update")
	public   String   updateProduct(@RequestBody   ProductDTO   pDTO) {
		
		Product   product =new  Product();
		BeanUtils.copyProperties(pDTO, product);
		boolean  flag=repository.existsById(product.getProductId());
		if(flag == true) {
			repository.saveAndFlush(product);
			return  "The product is updated.";  
		}
		else {
			
			return  "Sorry, The product does not exist";
		}
		
	}
	
	@DeleteMapping("/product/delete")
	public   String   deleteProduct(@RequestParam("productid") Integer   productId) {
		
		boolean  flag=repository.existsById(productId);
		if(flag==true) {
			repository.deleteById(productId);
			return  "The product is  deleted.";
			
		}
		else {
			return  "Sorry, The product doesn't  exist";
		}
	}
	
}
