package com.flm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	
	@Column(nullable = false, name = "item_name")
	private String itemName;
	
	private String category;
	
	@Column(nullable = false)
	private double price;
	
	private String brand;
	
	private int quantity;
	
	private int discount;
	
	private double rating;
	
	public Item(String itemName, String category, double price, String brand, int quantity, int discount,
			double rating) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.brand = brand;
		this.quantity = quantity;
		this.discount = discount;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", price=" + price
				+ ", brand=" + brand + ", quantity=" + quantity + ", discount=" + discount + ", rating=" + rating + "]";
	}
}
