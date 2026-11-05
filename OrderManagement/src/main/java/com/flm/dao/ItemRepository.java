package com.flm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	public List<Item> findByItemNameStartingWith(String itemName);
	
	public List<Item> findByItemNameContaining(String itemName);
	
	public List<Item> findByRatingGreaterThan(double rating);
	
	public List<Item> findByPriceBetween(double minPrice, double maxPrice);
}
