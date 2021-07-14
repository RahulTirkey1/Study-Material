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
import com.pms.dto.ProductListDTO;
import com.pms.entity.Product;
import com.pms.exception.NoSuchProductException;
import com.pms.repository.ProductRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class ProductRestController {
	@Autowired
	ProductRepository   repository;
	
	@ApiOperation(value="This endpoint fetches all products in JSON/XML Format")
	@ApiResponses({
		@ApiResponse(code=200, message="The products are fetched from Database successfully"),
		@ApiResponse(code=404, message="Check the endpoint url once before making a request"),
		@ApiResponse(code=403, message="The Resource is available but not accessible to you")
	})
	@GetMapping(value="/products",  produces= {"application/json","application/xml"})
	public   ResponseEntity<ProductListDTO>   getProductsJson() {
		List<Product>   productsList = repository.findAll();
		
		List<ProductDTO>  productsDtoList = new  ArrayList<>();
		
		productsList.forEach( product -> {
			ProductDTO   pDTO =new  ProductDTO();
			BeanUtils.copyProperties(product, pDTO);
			productsDtoList.add(pDTO);
		});
		
		ProductListDTO  listDto =new  ProductListDTO();
		listDto.setDtoList(productsDtoList);
		
		return  new  ResponseEntity<ProductListDTO>(listDto, HttpStatus.OK);
	}
	
	
	
	
	
	
	@ApiOperation(value="This endpoint fetches a product in JSON/XML Format for a given productid")
	@GetMapping(value="/products/{productid}", produces= {"application/json", "application/xml"})
	public   ResponseEntity<ProductDTO>   getProductById(@PathVariable("productid") Integer  productId) {
		Optional<Product>  opt = repository.findById(productId);
		
		ProductDTO  pDTO=new  ProductDTO();
		if(opt.isPresent()) {
			Product  product = opt.get();
		   	BeanUtils.copyProperties(product, pDTO);
		}
		
		return   new  ResponseEntity<ProductDTO>(pDTO, HttpStatus.OK);
	}
	
	@ApiOperation(value="This endpoint adds a new product to Database")
	@PostMapping(value="/product/create",  consumes= {"application/xml", "application/json"},  produces="text/plain")
	public   String   createProduct(@ApiParam(value="A product data in json/xml format") @RequestBody   ProductDTO   pDTO) {
		
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
	
	@ApiOperation(value="This endpoint updates an existing product")
	@PutMapping("/product/update")
	public   String   updateProduct(@ApiParam(value="A product data in json/xml format") @RequestBody   ProductDTO   pDTO) {
		
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
	
	@ApiOperation(value="This endpoint deletes a product from Database for a given productid")
	@DeleteMapping("/product/delete")
	public   String   deleteProduct(@RequestParam("productid") Integer   productId) throws NoSuchProductException {
		
		boolean  flag=repository.existsById(productId);
		if(flag==true) {
			repository.deleteById(productId);
			return  "The product is  deleted.";
			
		}
		else {
			//return  "Sorry, The product doesn't  exist";
			throw  new  NoSuchProductException();
		}
	}
	
}
