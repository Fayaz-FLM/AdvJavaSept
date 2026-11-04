package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flm.model.Product;
import com.flm.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/save")
	public String saveProduct() {
		
		productService.saveProduct();
		
		return "Saved Product";
	}
	
	@GetMapping("/byid")
	public Product findProductById() {
		return productService.getProductById();
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/delete")
	public String deleteProduct() {
		productService.deleteProduct();
		return "Deleted Product";
	}
	
	@GetMapping("/update")
	public Product updateProduct() {
		return productService.updateProduct();
	}
	
	@GetMapping("/byname")
	public Product getProductByName() {
		return productService.getProductByName();
	}
	
	@GetMapping("/byprice/{price}")
	public Product getProductByPrice(@PathVariable int price) {
		return productService.getProductByPrice(price);
	}
	
	@GetMapping("/bypricegreater/{price}")
	public List<Product> getProductByPriceGreaterThan(@PathVariable int price) {
		return productService.getProductByPriceGreaterThan(price);
	}
}
