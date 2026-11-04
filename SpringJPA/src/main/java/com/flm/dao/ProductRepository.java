package com.flm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flm.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p From Product p where p.productId = :id")
	public Product getProductById(int id);
	
	@Query(nativeQuery = true, value = "select * from Products where name=:name")
	public Product getProductByName(String name);
	
	public Product findByPrice(int price);
	
	public List<Product> findByPriceGreaterThan(int price);
} 
