package com.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.client.model.ProductBean;

@Controller
public class AdminController {
	
	@Value("${ADD_PRODUCT_URL}")
	private  String  addProductUrl;
	
	@Value("${UPDATE_PRODUCT_URL}")
	private  String   updateProductUrl;
	
	@Value("${DELETE_PRODUCT_URL}")
	private   String   deleteProductUrl;
	
	@Value("${FETCH_PRODUCTS_URL}")
	private  String   fetchProductsUrl;
	
	@Value("${FETCH_PRODUCT_URL}")
	private  String  fetchProductUrl;
			
	@Autowired
	RestTemplate   restTemplate;
	
	@GetMapping("/home")
	public   String   getHomePage() {
		return  "home";
	}
	
	@GetMapping("/addProduct")
	public   String   getAddProductPage(Model  model) {
		ProductBean   productBean = new ProductBean();
		model.addAttribute("pbean", productBean);
		return  "addProduct";
	}
	
	@PostMapping("/save")
	public   String  saveProduct(@ModelAttribute("pbean") ProductBean    productBean) {
		
		/*
		 * postForObject(param1, param2, param3)
		 * param1 :  Restendpoint  url
		 * param2:  Java object to send  in request
		 * param3:  Class  object  of  response type
		 */
		String  str = restTemplate.postForObject(addProductUrl, productBean, String.class);
		System.out.println(str);
		return  "home";
		
	}
	
	@GetMapping("/updateProduct")
	public  String   getUpdateProductPage(Model  model) {
		ProductBean   productBean = new ProductBean();
		model.addAttribute("pbean2", productBean);
		return  "updateProduct";
	}
	
	@PostMapping("/update")
	public  String  updateProduct(@ModelAttribute("pbean2")ProductBean  productBean) {
		
		HttpEntity<ProductBean>  requestEntity=new  HttpEntity<ProductBean>(productBean);
		/*
		 * exchange(param1, param2, param3,param4)
		 * param1 : Restendpoint  url
		 * param2: HttpMethod
		 * param3: HttpEntity, it is an entity with headers and/or body to add to the request
		 * param4: Class object of response
		 */
		
		ResponseEntity<String>  re = restTemplate.exchange(updateProductUrl, HttpMethod.PUT, requestEntity,String.class);
		System.out.println(re.getBody());
		return  "home";
	}
	
	@GetMapping("/deleteProduct")
	public   String  getDeleteProductPage() {
		return  "deleteProduct";
	}
	
	@GetMapping("/delete")
	public  String   deleteProduct(@RequestParam  Integer  productid) {
		
		ResponseEntity<String>  re = restTemplate.exchange(deleteProductUrl+"?productid="+productid,HttpMethod.DELETE,null,String.class );
		System.out.println(re.getBody());
		return  "home";
	}
	
	@GetMapping("/findAllProducts")
	public   String   findProducts(Model  model) {
		
		ParameterizedTypeReference<List<ProductBean>>  typeRef = new  ParameterizedTypeReference<List<ProductBean>>() { };
		
		ResponseEntity<List<ProductBean>>   re = restTemplate.exchange(fetchProductsUrl, HttpMethod.GET, null, typeRef);
		List<ProductBean>   plist = re.getBody();
		model.addAttribute("products", plist);
		return "showProducts";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
