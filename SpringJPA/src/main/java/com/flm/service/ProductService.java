package com.flm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dao.ProductRepository;
import com.flm.model.Product;

@Component
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveProduct() {
		Product product = new Product("AC", 29999);
		
		productRepository.save(product);
	}
	
	public Product getProductById() {
		
//		Optional<Product> productOptional = productRepository.findById(1);
//		Product product = productOptional.get();
		
		Product product = productRepository.getProductById(1);
		return product;
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public void deleteProduct() {
		
		Product product =new Product(1, null , 0);
		productRepository.delete(product);
	}
	
	public Product updateProduct() {
		
		Product product = productRepository.findById(1).get();
		
		product.setPrice(90000);
		
		return productRepository.save(product);
	}
	
	public Product getProductByName() {
		return productRepository.getProductByName("AC");
	}
	
	public Product getProductByPrice(int price) {
		return productRepository.findByPrice(price);
	}
	
	public List<Product> getProductByPriceGreaterThan(int price) {
		return productRepository.findByPriceGreaterThan(price);
	}
}
